package com.clinic.payroll.catalogsrestapi.model.dto;

public class ZoneDto {
	
	private Long ZoneId;
	
	private String description;

	public Long getZoneId() {
		return ZoneId;
	}

	public void setZoneId(Long zoneId) {
		ZoneId = zoneId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
