package com.clinic.payroll.catalogsrestapi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;

@Entity
@Table(name = "nephrologist_base_clinic")
public class NephrologistBaseClinicEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "base_clinic_id")
	private Long baseClinicId;
	
	@NotNull
    @ManyToOne
    @JoinColumn(name = "nephrologist", referencedColumnName = "nephrologist_id", insertable = false, updatable = false)
    NephrologistEntity nephrologist;
    
	@NotNull
    @ManyToOne
    @JoinColumn(name = "clinic", referencedColumnName = "clinic_id", insertable = false, updatable = false)
    ClinicEntity clinic;
    
	@NotNull
	@Column
	private Double salary;
	
	@NotNull
	@Column(name = "dedication_hours")
	private Double dedicationHours;

	private NephrologistBaseClinicEntity() {
		super();
	}
	
	private NephrologistBaseClinicEntity(Long baseClinicId, NephrologistEntity nephrologist, ClinicEntity clinic, Double salary,
			Double dedicationHours) {
		super();
		this.baseClinicId = baseClinicId;
		this.nephrologist = nephrologist;
		this.clinic = clinic;
		this.salary = salary;
		this.dedicationHours = dedicationHours;
	}

	public Long getBaseClinicId() {
		return baseClinicId;
	}

	public void setBaseClinicId(Long id) {
		this.baseClinicId = id;
	}

	public NephrologistEntity getNephrologist() {
		return nephrologist;
	}

	public void setNephrologist(NephrologistEntity nephrologist) {
		this.nephrologist = nephrologist;
	}

	public ClinicEntity getClinic() {
		return clinic;
	}

	public void setClinic(ClinicEntity clinic) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseClinicId == null) ? 0 : baseClinicId.hashCode());
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
		NephrologistBaseClinicEntity other = (NephrologistBaseClinicEntity) obj;
		if (baseClinicId == null) {
			if (other.baseClinicId != null)
				return false;
		} else if (!baseClinicId.equals(other.baseClinicId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NephrologistBaseClinicEntity [id=" + baseClinicId + ", nephrologist=" + nephrologist + ", clinic=" + clinic
				+ ", salary=" + salary + ", dedicationHours=" + dedicationHours + "]";
	}
	
	

}
