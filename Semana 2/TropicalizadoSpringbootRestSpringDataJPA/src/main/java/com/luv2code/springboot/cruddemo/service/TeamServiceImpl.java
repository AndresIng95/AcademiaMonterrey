package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.TeamRepository;
import com.luv2code.springboot.cruddemo.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

	private TeamRepository teamRepository;

	@Autowired
    public TeamServiceImpl(TeamRepository theTeamRepository) {
        teamRepository = theTeamRepository;
    }

	@Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

	@Override
    public Team findById(int theId) {
        Optional<Team> result = teamRepository.findById(theId);

        Team theTeam = null;

        if (result.isPresent()) {
            theTeam = result.get();
        }
        else {
            // we didn't find the team
            throw new RuntimeException("Did not find team id - " + theId);
        }

        return theTeam;
    }

	@Override
    public Team save(Team theTeam) {
        return teamRepository.save(theTeam);
    }

    @Override
    public void deleteById(int theId) {
        teamRepository.deleteById(theId);
    }
}






