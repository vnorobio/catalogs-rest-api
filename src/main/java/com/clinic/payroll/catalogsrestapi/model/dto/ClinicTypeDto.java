package com.clinic.payroll.catalogsrestapi.model.dto;

public class ClinicTypeDto {
	
	private Long clinicTypId;
	
	private String description;

	public Long getClinicTypId() {
		return clinicTypId;
	}

	public void setClinicTypId(Long clinicTypId) {
		this.clinicTypId = clinicTypId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
