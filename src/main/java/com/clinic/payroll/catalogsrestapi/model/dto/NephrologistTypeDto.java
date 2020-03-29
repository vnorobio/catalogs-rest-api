package com.clinic.payroll.catalogsrestapi.model.dto;

public final class NephrologistTypeDto {
	
	private final Long id;
	private final String description;
	
	public NephrologistTypeDto(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
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
		NephrologistTypeDto other = (NephrologistTypeDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NephrologistTypeDto [id=" + id + ", description=" + description + "]";
	}
	
	

}
