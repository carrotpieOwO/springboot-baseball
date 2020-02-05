package com.cos.springboot.model;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Player {

	private int id;
	private String name;
	private int height;
	private int salary;
	private int teamId;

	@Builder
	public Player(String name, int height, int salary, int teamId) {
		super();
		this.name = name;
		this.height = height;
		this.salary = salary;
		this.teamId = teamId;
	}

}
