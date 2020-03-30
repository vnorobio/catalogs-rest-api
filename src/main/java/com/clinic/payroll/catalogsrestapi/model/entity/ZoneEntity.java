package com.clinic.payroll.catalogsrestapi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "zone")
public class ZoneEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "zone_id")
	private Long zoneId;
	
	@NotNull
	@Column
	private String description;
	/*
	@OneToMany(targetEntity = ClinicEntity.class)
	private Set<ClinicEntity> baseClinics = new HashSet<>();	*/
	
	public ZoneEntity(Long zoneId, String description) {
		super();
		this.zoneId = zoneId;
		this.description = description;
	}

	public ZoneEntity() {
		super();
	}

	public Long getZoneId() {
		return zoneId;
	}

	public void setZoneId(Long zoneId) {
		this.zoneId = zoneId;
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
		result = prime * result + ((zoneId == null) ? 0 : zoneId.hashCode());
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
		ZoneEntity other = (ZoneEntity) obj;
		if (zoneId == null) {
			if (other.zoneId != null)
				return false;
		} else if (!zoneId.equals(other.zoneId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ZoneEntity [id=" + zoneId + ", description=" + description + "]";
	}
	
	

}
