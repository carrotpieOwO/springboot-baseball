package com.cos.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.springboot.model.Detail;
import com.cos.springboot.model.Player;
import com.cos.springboot.model.Team;
import com.cos.springboot.repository.BBRepository;

@Controller
public class HomeController {

	@Autowired
	private BBRepository bbRepository;

	@GetMapping("/bb")
	public String mems(Model model) {
		List<Team> teams = bbRepository.findAll();
		
		model.addAttribute("teams",teams);
		return "bb/list";
	}
	
	@GetMapping("/bb/{type}") 
	public @ResponseBody List<Player> names (@PathVariable int type, Model model) {
		List<Player> players = bbRepository.findByTeam(type);
		model.addAttribute("players",players);
		return players;
	}
	
//	@GetMapping("/bb/detail/{id}") 
//	public @ResponseBody String detail (@PathVariable int id) {
//		Detail detail = bbRepository.findByName(id);
//		System.out.println(detail);
//	//	model.addAttribute("detail",detail);
//		return "ok";
//	}
	
	@GetMapping("/bb/detail/{type}") 
	public @ResponseBody Detail player (@PathVariable int type, Model model) {
		
		Detail detail = bbRepository.findByName(type);
		
		/*
		 * String name = detail.getPlayer().getName(); int height =
		 * detail.getPlayer().getHeight(); int salary = detail.getPlayer().getSalary();
		 * String teamName = detail.getTeam().getName();
		 * 
		 * ResponseDetailDto responseDetailDto = new ResponseDetailDto();
		 * responseDetailDto.setName(name); responseDetailDto.setHeight(height);
		 * responseDetailDto.setSalary(salary); responseDetailDto.setTeamName(teamName);
		 */
		
		model.addAttribute("detail",detail);

		return detail;

}
}