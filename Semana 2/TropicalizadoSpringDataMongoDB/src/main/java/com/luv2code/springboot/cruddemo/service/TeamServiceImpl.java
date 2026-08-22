package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Team;
import com.luv2code.springboot.cruddemo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    // Antes se inyectaba DAO. Ahora es el repositorio de Spring Data,
    // que no tiene implementación escrita a mano.
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
    public Team findById(String theId) {

        // findById() devuelve Optional<Team>. Lo convertimos a null para
        // conservar el mismo contrato que tenía la versión con JPA: el
        // controlador sigue comprobando "if (tempTeam == null)".
        return teamRepository.findById(theId).orElse(null);
    }

    // Ojo: aquí ya no hay @Transactional.
    //
    // MongoDB en modo standalone (un contenedor suelto, sin replica set) no
    // soporta transacciones multi-documento. Y no hacen falta: cada operación
    // toca un solo documento, y MongoDB garantiza atomicidad por documento.
    @Override
    public Team save(Team theTeam) {
        return teamRepository.save(theTeam);
    }

    @Override
    public void deleteById(String theId) {
        teamRepository.deleteById(theId);
    }
}
