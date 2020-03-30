package com.clinic.payroll.catalogsrestapi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;

@Entity
@Table(name = "city")
public class CityEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private Long cityId;
	
	@NotNull(message = "Description may not be null")
	@Column
	private String description;
	
	@NotNull(message = "Zone may not be null")
    @ManyToOne
    @JoinColumn(name = "zone", referencedColumnName = "zone_id", insertable = false, updatable = false)
	private ZoneEntity zone;
	
	public CityEntity() {
		super();
	}
	
	public CityEntity(Long cityId, String description, ZoneEntity zone) {
		super();
		this.cityId = cityId;
		this.description = description;
		this.zone = zone;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long id) {
		this.cityId = id;
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
		result = prime * result + ((cityId == null) ? 0 : cityId.hashCode());
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
		if (cityId == null) {
			if (other.cityId != null)
				return false;
		} else if (!cityId.equals(other.cityId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CityEntity [id=" + cityId + ", description=" + description + ", zone=" + zone + "]";
	}


}
