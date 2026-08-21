package com.luv2code.springboot.cruddemo.service;
import java.util.List;
import com.luv2code.springboot.cruddemo.entity.Team;



public interface TeamService {

    List<Team> findAll();

    Team findById(int theId);

    Team save(Team theTeam);

    void deleteById(int theId);

}

