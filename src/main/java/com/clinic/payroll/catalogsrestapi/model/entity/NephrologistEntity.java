package com.clinic.payroll.catalogsrestapi.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;

@Entity
@Table(name = "nephrologist")
public class NephrologistEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nephrologist_id")
	private Long nephrologistId;
	
	@NotNull
	@Column
	private String name;

	@NotNull(message = "Zone may not be null")
    @ManyToOne
    @JoinColumn(name = "nephrologist_type", referencedColumnName = "nephrologist_type_id", insertable = false, updatable = false)
	private NephrologistTypeEntity nephrologistType;
	
	@Column
	private String email;
	
	@Column
	private Boolean active;
	
	@OneToMany(targetEntity = NephrologistBaseClinicEntity.class)
	private Set<NephrologistBaseClinicEntity> baseClinics = new HashSet<>();
	
	private NephrologistEntity() {
		super();
	}
	
	private NephrologistEntity(Long nephrologistId, String name, NephrologistTypeEntity nephrologistType, String email, Boolean active) {
		super();
		this.nephrologistId = nephrologistId;
		this.name = name;
		this.nephrologistType = nephrologistType;
		this.email = email;
		this.active = active;
	}

	public Long getNephrologistId() {
		return nephrologistId;
	}

	public void setNephrologistId(Long id) {
		this.nephrologistId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NephrologistTypeEntity getNephrologistType() {
		return nephrologistType;
	}

	public void setNephrologistType(NephrologistTypeEntity nephrologistType) {
		this.nephrologistType = nephrologistType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nephrologistId == null) ? 0 : nephrologistId.hashCode());
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
		NephrologistEntity other = (NephrologistEntity) obj;
		if (nephrologistId == null) {
			if (other.nephrologistId != null)
				return false;
		} else if (!nephrologistId.equals(other.nephrologistId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NephrologistEntity [id=" + nephrologistId + ", name=" + name + ", nephrologistType=" + nephrologistType + ", email="
				+ email + ", active=" + active + "]";
	}
	
	

}
