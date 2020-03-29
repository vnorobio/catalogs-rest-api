package com.clinic.payroll.catalogsrestapi.model.dto;

public class NephrologistBaseClinicDto {
	
	private Long id;
	
	private NephrologistDto nephrologist;
	
	private ClinicDto clinic;
	
	private Double salary;
	
	private Double dedicationHours;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NephrologistDto getNephrologist() {
		return nephrologist;
	}

	public void setNephrologist(NephrologistDto nephrologist) {
		this.nephrologist = nephrologist;
	}

	public ClinicDto getClinic() {
		return clinic;
	}

	public void setClinic(ClinicDto clinic) {
		this.clinic = clinic;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getDedicationHours() {
		return dedicationHours;
	}

	public void setDedicationHours(Double dedicationHours) {
		this.dedicationHours = dedicationHours;
	}
	
}
