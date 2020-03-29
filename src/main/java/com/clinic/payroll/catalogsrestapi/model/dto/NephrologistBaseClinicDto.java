package com.clinic.payroll.catalogsrestapi.model.dto;

public final class NephrologistBaseClinicDto {
	
	private final Long id;
	private final NephrologistDto nephrologist;
	private final ClinicDto clinic;
	private final Double salary;
	private final Double dedicationHours;
	
	private NephrologistBaseClinicDto(Long id, NephrologistDto nephrologist, ClinicDto clinic, Double salary,
			Double dedicationHours) {
		super();
		this.id = id;
		this.nephrologist = nephrologist;
		this.clinic = clinic;
		this.salary = salary;
		this.dedicationHours = dedicationHours;
	}

	public Long getId() {
		return id;
	}

	public NephrologistDto getNephrologist() {
		return nephrologist;
	}

	public ClinicDto getClinic() {
		return clinic;
	}

	public Double getSalary() {
		return salary;
	}

	public Double getDedicationHours() {
		return dedicationHours;
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
		NephrologistBaseClinicDto other = (NephrologistBaseClinicDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NephrologistBaseClinicDto [id=" + id + ", nephrologist=" + nephrologist + ", clinic=" + clinic
				+ ", salary=" + salary + ", dedicationHours=" + dedicationHours + "]";
	}
	
	

}
