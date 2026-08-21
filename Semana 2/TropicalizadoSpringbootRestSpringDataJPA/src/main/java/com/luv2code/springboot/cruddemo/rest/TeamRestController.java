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

    // expose "/employees" and return a list of employees
    @GetMapping("/teams")
    public List<Team> findAll() {
        return teamService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/teams/{teamId}")
    public Team getTeam(@PathVariable int teamId) {

    	Team theTeam = teamService.findById(teamId);

        if (theTeam == null) {
            throw new RuntimeException("Team id not found - " + teamId);
        }

        return theTeam;
    }

    // add mapping for POST /employees - add new employee

    @PostMapping("/teams")
    public Team addTeam(@RequestBody Team theTeam) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theTeam.setId(0);

        Team dbTeam = teamService.save(theTeam);

        return dbTeam;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/teams")
    public Team updateTeam(@RequestBody Team theTeam) {

        Team dbTeam = teamService.save(theTeam);

        return dbTeam;
    }

    // add mapping for PATCH /employees/{employeeId} - patch employee ... partial
    // update

    @PatchMapping("/teams/{teamId}")
    public Team patchTeam(@PathVariable int teamId,
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

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/teams/{teamId}")
    public String deleteTeam(@PathVariable int teamId) {

        Team tempTeam = teamService.findById(teamId);

        // throw exception if null

        if (tempTeam == null) {
            throw new RuntimeException("Team id not found - " + teamId);
        }

        teamService.deleteById(teamId);

        return "Deleted team id - " + teamId;
    }

}




/*The Windows powershell terminal commands that were used to test the program
 * 
 * 
 * 
 * $BASE = "http://localhost:8070/api/teams" 
 * Invoke-RestMethod -Uri $BASE -Method GET | ConvertTo-Json
 * 
 * $team = @{
>>     name  = "America"
>>     city  = "Cd de Mexico"
>>     sport = "Soccer"
>> } | ConvertTo-Json
 * 
 * 
 * Invoke-RestMethod -Uri $BASE -Method POST `
>>     -ContentType "application/json" `
>>     -Body $team | ConvertTo-Json
 * 
 * Invoke-RestMethod -Uri "$BASE/3" -Method GET | ConvertTo-Json
 * 
 * Invoke-RestMethod -Uri "$BASE/6" -Method GET | ConvertTo-Json
 * 
 * $team = @{
>>     id    = 3
>>     name  = "Los Angeles Dodgers"
>>     city  = "Los Angeles"
>>     sport = "Baseball"
>> } | ConvertTo-Json
 * 
 * Invoke-RestMethod -Uri $BASE -Method PUT `
>>     -ContentType "application/json" `
>>     -Body $team | ConvertTo-Json
 * 
 * $patch = @{
>>     city = "San Nicolas de los Garza"
>> } | ConvertTo-Json
 * 
 * Invoke-RestMethod -Uri "$BASE/1" -Method PATCH `
>>     -ContentType "application/json" `
>>     -Body $patch | ConvertTo-Json
 * 
 * Invoke-RestMethod -Uri "$BASE/3" -Method DELETE
 * 
 * 
 * All changes where reflected on the database.
 * 
 */
