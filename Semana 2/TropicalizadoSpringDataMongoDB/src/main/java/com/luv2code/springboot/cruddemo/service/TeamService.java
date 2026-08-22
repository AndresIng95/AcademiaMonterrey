package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Team;

import java.util.List;

public interface TeamService {

    List<Team> findAll();

    Team findById(String theId);

    Team save(Team theTeam);

    void deleteById(String theId);

}
