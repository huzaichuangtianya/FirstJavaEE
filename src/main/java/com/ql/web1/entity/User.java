package com.ql.web1.entity;

import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int id;
	
	
	public User(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}


	public User() {
	}


	public User(int id,String name) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
