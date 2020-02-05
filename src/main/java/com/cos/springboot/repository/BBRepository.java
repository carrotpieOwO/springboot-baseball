package com.cos.springboot.repository;

import java.util.List;

import com.cos.springboot.model.Detail;
import com.cos.springboot.model.Player;
import com.cos.springboot.model.Team;

public interface BBRepository {

	List<Team> findAll();
	List<Player> findByTeam(int type);
	Detail findByName(int id);
	
}
