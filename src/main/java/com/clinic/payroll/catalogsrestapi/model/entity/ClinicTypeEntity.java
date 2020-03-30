package com.clinic.payroll.catalogsrestapi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;

@Entity
@Table(name = "clinic_type")
public class ClinicTypeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clinic_type_id")
	private Long clinicTypeId;
	
	@NotNull
	@Column
	private String description;
	
	public ClinicTypeEntity() {
		super();
	}	
	
	public ClinicTypeEntity(Long clinicTypeId, String description) {
		super();
		this.clinicTypeId = clinicTypeId;
		this.description = description;
	}

	public Long getClinicTypeId() {
		return clinicTypeId;
	}

	public void setClinicTypeId(Long clinicTypeId) {
		this.clinicTypeId = clinicTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clinicTypeId == null) ? 0 : clinicTypeId.hashCode());
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
		ClinicTypeEntity other = (ClinicTypeEntity) obj;
		if (clinicTypeId == null) {
			if (other.clinicTypeId != null)
				return false;
		} else if (!clinicTypeId.equals(other.clinicTypeId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClinicTypeEntity [id=" + clinicTypeId + ", description=" + description + "]";
	}
	
	

}
