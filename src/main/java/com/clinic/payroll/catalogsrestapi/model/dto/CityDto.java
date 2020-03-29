package com.clinic.payroll.catalogsrestapi.model.dto;

public class CityDto {
	
	private Long id;
	
	private String description;
	
	private ZoneDto zone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ZoneDto getZone() {
		return zone;
	}

	public void setZone(ZoneDto zone) {
		this.zone = zone;
	}
	
}
