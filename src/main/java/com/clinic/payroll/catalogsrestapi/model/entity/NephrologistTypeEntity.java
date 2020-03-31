package com.clinic.payroll.catalogsrestapi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;

@Entity
@Table(name = "nephrologist_type")
public class NephrologistTypeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nephrologist_type_id")
	private Long nephrologistTypeId;
	
	@NotNull(message = "Description may not be null")
	@Column
	private String description;
	
	public NephrologistTypeEntity() {
		super();
	}
	
	public NephrologistTypeEntity(Long nephrologistTypeId, String description) {
		super();
		this.nephrologistTypeId = nephrologistTypeId;
		this.description = description;
	}

	public Long getNephrologistTypeId() {
		return nephrologistTypeId;
	}

	public void setNephrologistTypeId(Long id) {
		this.nephrologistTypeId = id;
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
		result = prime * result + ((nephrologistTypeId == null) ? 0 : nephrologistTypeId.hashCode());
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
		NephrologistTypeEntity other = (NephrologistTypeEntity) obj;
		if (nephrologistTypeId == null) {
			if (other.nephrologistTypeId != null)
				return false;
		} else if (!nephrologistTypeId.equals(other.nephrologistTypeId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NephrologistTypeEntity [id=" + nephrologistTypeId + ", description=" + description + "]";
	}
	
	

}
