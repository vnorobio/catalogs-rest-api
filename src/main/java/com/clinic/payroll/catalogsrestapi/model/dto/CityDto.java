package com.clinic.payroll.catalogsrestapi.model.dto;

public final class CityDto {
	
	private final Long id;
	private final String description;
	private final ZoneDto zone;
	
	public CityDto(Long id, String description, ZoneDto zone) {
		super();
		this.id = id;
		this.description = description;
		this.zone = zone;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public ZoneDto getZone() {
		return zone;
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
		CityDto other = (CityDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CityDto [id=" + id + ", description=" + description + ", zone=" + zone + "]";
	}


}
