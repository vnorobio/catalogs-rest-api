package com.clinic.payroll.catalogsrestapi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;

@Entity
@Table(name = "city")
public class CityEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column
	private String description;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "zone", referencedColumnName = "id")
	private ZoneEntity zone;
	
	public CityEntity(Long id, String description, ZoneEntity zone) {
		super();
		this.id = id;
		this.description = description;
		this.zone = zone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ZoneEntity getZone() {
		return zone;
	}

	public void setZone(ZoneEntity zone) {
		this.zone = zone;
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
		CityEntity other = (CityEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CityEntity [id=" + id + ", description=" + description + ", zone=" + zone + "]";
	}


}
