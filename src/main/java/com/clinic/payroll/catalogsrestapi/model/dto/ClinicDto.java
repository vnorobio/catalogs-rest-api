package com.clinic.payroll.catalogsrestapi.model.dto;

public class ClinicDto {
	
	private Long id;
	private String name;
	private String administrator;
	private String email;
	private String director;
	private CityDto city;
	private int capacity;
	private ClinicTypeDto clinicType;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdministrator() {
		return administrator;
	}
	public void setAdministrator(String administrator) {
		this.administrator = administrator;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public CityDto getCity() {
		return city;
	}
	public void setCity(CityDto city) {
		this.city = city;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public ClinicTypeDto getClinicType() {
		return clinicType;
	}
	public void setClinicType(ClinicTypeDto clinicType) {
		this.clinicType = clinicType;
	}
	
}
