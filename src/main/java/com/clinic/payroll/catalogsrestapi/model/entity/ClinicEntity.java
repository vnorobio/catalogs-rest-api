package com.clinic.payroll.catalogsrestapi.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "clinic")
public class ClinicEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clinic_id")
	private Long clinicId;
	
	@NotNull
	@Column
	private String name;
	
	@Column
	private String administrator;
	
	@Column
	private String email;
	
	@Column
	private String director;
	
	@NotNull(message = "Zone may not be null")
    @ManyToOne
    @JoinColumn(name = "city", referencedColumnName = "city_id", insertable = false, updatable = false)
	private CityEntity city;
    
	@Column
	private int capacity;
	
	@NotNull(message = "Zone may not be null")
    @ManyToOne
    @JoinColumn(name = "clinic_type", referencedColumnName = "clinic_type_id", insertable = false, updatable = false)
	private ClinicTypeEntity clinicType;
	
	@OneToMany(targetEntity = NephrologistBaseClinicEntity.class)
	private Set<NephrologistBaseClinicEntity> baseClinics = new HashSet<>();	
	
	public ClinicEntity() {
		super();

	}	
	
	public ClinicEntity(Long clinicId, String name, String administrator, String email, String director, CityEntity city,
			int capacity, ClinicTypeEntity clinicType) {
		super();
		this.clinicId = clinicId;
		this.name = name;
		this.administrator = administrator;
		this.email = email;
		this.director = director;
		this.city = city;
		this.capacity = capacity;
		this.clinicType = clinicType;
	}

	public Long getClinicId() {
		return clinicId;
	}

	public void setClinicId(Long id) {
		this.clinicId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdministrator() {
		return administrator;
	}

	public void setAdministrator(String administrator) {
		this.administrator = administrator;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public CityEntity getCity() {
		return city;
	}

	public void setCity(CityEntity city) {
		this.city = city;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public ClinicTypeEntity getClinicType() {
		return clinicType;
	}

	public void setClinicType(ClinicTypeEntity clinicType) {
		this.clinicType = clinicType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clinicId == null) ? 0 : clinicId.hashCode());
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
		ClinicEntity other = (ClinicEntity) obj;
		if (clinicId == null) {
			if (other.clinicId != null)
				return false;
		} else if (!clinicId.equals(other.clinicId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClinicEntity [id=" + clinicId + ", name=" + name + ", administrator=" + administrator + ", email=" + email
				+ ", director=" + director + ", city=" + city + ", capacity=" + capacity + ", clinicType=" + clinicType
				+ "]";
	}
	
	

}
