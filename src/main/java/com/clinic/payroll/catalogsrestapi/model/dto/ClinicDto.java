package com.clinic.payroll.catalogsrestapi.model.dto;

public final class ClinicDto {
	
	private final Long id;
	private final String name;
	private final String administrator;
	private final String email;
	private final String director;
	private final CityDto city;
	private final int capacity;
	private final ClinicTypeDto clinicType;
	
	private ClinicDto(Long id, String name, String administrator, String email, String director, CityDto city,
			int capacity, ClinicTypeDto clinicType) {
		super();
		this.id = id;
		this.name = name;
		this.administrator = administrator;
		this.email = email;
		this.director = director;
		this.city = city;
		this.capacity = capacity;
		this.clinicType = clinicType;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAdministrator() {
		return administrator;
	}

	public String getEmail() {
		return email;
	}

	public String getDirector() {
		return director;
	}

	public CityDto getCity() {
		return city;
	}

	public int getCapacity() {
		return capacity;
	}

	public ClinicTypeDto getClinicType() {
		return clinicType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClinicDto other = (ClinicDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClinicDto [id=" + id + ", name=" + name + ", administrator=" + administrator + ", email=" + email
				+ ", director=" + director + ", city=" + city + ", capacity=" + capacity + ", clinicType=" + clinicType
				+ "]";
	}
	
	

}
