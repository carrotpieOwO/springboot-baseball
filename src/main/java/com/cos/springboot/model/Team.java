package com.cos.springboot.model;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class Team {
	
	private int id;
	private String name;
	private Date foundation;
	
	@Builder
	public Team(String name, Date foundation) {
		super();
		this.name = name;
		this.foundation = foundation;
	}
	
	

}
