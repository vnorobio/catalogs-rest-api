package com.clinic.payroll.catalogsrestapi.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;

@Entity
@Table(name = "nephrologis")
public class NephrologistEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column
	private String name;
	
	@OneToOne
	@JoinColumn(name = "nephrologist_type", referencedColumnName = "id")
	private NephrologistTypeEntity nephrologistType;
	
	@Column
	private String email;
	
	@Column
	private Boolean active;
	
	@OneToMany(mappedBy = "nephrologist")
	private Set<NephrologistBaseClinicEntity> baseClinics = new HashSet<>();
	
	private NephrologistEntity(Long id, String name, NephrologistTypeEntity nephrologistType, String email, Boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.nephrologistType = nephrologistType;
		this.email = email;
		this.active = active;
	}

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
		NephrologistEntity other = (NephrologistEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NephrologistEntity [id=" + id + ", name=" + name + ", nephrologistType=" + nephrologistType + ", email="
				+ email + ", active=" + active + "]";
	}
	
	

}
