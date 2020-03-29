package com.clinic.payroll.catalogsrestapi.model.dto;

public class NephrologistDto {
	
	private Long id;
	
	private String name;
	
	private NephrologistTypeDto nephrologistType;
	
	private String email;
	
	private Boolean active;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public NephrologistTypeDto getNephrologistType() {
		return nephrologistType;
	}

	public String getEmail() {
		return email;
	}

	public Boolean getActive() {
		return active;
	}

}
