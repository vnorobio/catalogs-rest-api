package com.clinic.payroll.catalogsrestapi.model.dto;

public final class NephrologistDto {
	
	private final Long id;
	private final String name;
	private final NephrologistTypeDto nephrologistType;
	private final String email;
	private final Boolean active;
	
	private NephrologistDto(Long id, String name, NephrologistTypeDto nephrologistType, String email, Boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.nephrologistType = nephrologistType;
		this.email = email;
		this.active = active;
	}

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
