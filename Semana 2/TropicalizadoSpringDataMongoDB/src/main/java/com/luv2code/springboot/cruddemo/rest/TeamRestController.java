package com.luv2code.springboot.cruddemo.rest;

import tools.jackson.databind.json.JsonMapper;
import com.luv2code.springboot.cruddemo.entity.Team;
import com.luv2code.springboot.cruddemo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TeamRestController {

    private TeamService teamService;

    private JsonMapper jsonMapper;

    @Autowired
    public TeamRestController(TeamService theTeamService, JsonMapper theJsonMapper) {
        teamService = theTeamService;
        jsonMapper = theJsonMapper;
    }

    // expose "/teams" and return a list of teams
    @GetMapping("/teams")
    public List<Team> findAll() {
        return teamService.findAll();
    }

    // add mapping for GET /teams/{teamId}
    //
    // El teamId ahora es String: un ObjectId de MongoDB, no un entero.

    @GetMapping("/teams/{teamId}")
    public Team getTeam(@PathVariable String teamId) {

        Team theTeam = teamService.findById(teamId);

        if (theTeam == null) {
            throw new RuntimeException("Team id not found - " + teamId);
        }

        return theTeam;
    }

    // add mapping for POST /teams - add new team

    @PostMapping("/teams")
    public Team addTeam(@RequestBody Team theTeam) {

        // also just in case they pass an id in JSON ... set id to null
        // this is to force a save of new item ... instead of update
        //
        // En JPA esto era setId(0). En MongoDB el equivalente es null: si el id
        // viene nulo se inserta un documento nuevo, y si viene con valor se
        // REEMPLAZA el documento que ya existía con ese id.

        theTeam.setId(null);

        Team dbTeam = teamService.save(theTeam);

        return dbTeam;
    }

    // add mapping for PUT /teams - update existing team

    @PutMapping("/teams")
    public Team updateTeam(@RequestBody Team theTeam) {

        Team dbTeam = teamService.save(theTeam);

        return dbTeam;
    }

    // add mapping for PATCH /teams/{teamId} - patch team ... partial
    // update

    @PatchMapping("/teams/{teamId}")
    public Team patchTeam(@PathVariable String teamId,
            @RequestBody Map<String, Object> patchPayload) {

        // Step 1: Retrieve the existing team from database
        Team tempTeam = teamService.findById(teamId);

        if (tempTeam == null) {
            throw new RuntimeException("Team id not found - " + teamId);
        }

        // Step 2: Security check - prevent ID modifications
        // The ID should never change, so reject any attempts to modify it
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException(
                    "Team id cannot be modified. Remove 'id' from request body.");
        }

        // Step 3: Apply the partial update
        // This creates a NEW team object with the updates applied
        Team patchedTeam = jsonMapper.updateValue(tempTeam, patchPayload);

        // Step 4: Save the updated team to database and return it
        Team dbTeam = teamService.save(patchedTeam);

        return dbTeam;
    }

    // add mapping for DELETE /teams/{teamId} - delete team

    @DeleteMapping("/teams/{teamId}")
    public String deleteTeam(@PathVariable String teamId) {

        Team tempTeam = teamService.findById(teamId);

        // throw exception if null

        if (tempTeam == null) {
            throw new RuntimeException("Team id not found - " + teamId);
        }

        teamService.deleteById(teamId);

        return "Deleted team id - " + teamId;
    }

}
