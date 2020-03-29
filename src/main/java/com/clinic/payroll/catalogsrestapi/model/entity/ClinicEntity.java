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
@Table(name = "clinic")
public class ClinicEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column
	private String name;
	
	@Column
	private String administrator;
	
	@Column
	private String email;
	
	@Column
	private String director;
	
    @OneToOne
    @JoinColumn(name = "city", referencedColumnName = "id")
	private CityEntity city;
    
	@Column
	private int capacity;
	
	@OneToOne
	@JoinColumn(name = "clinic_type", referencedColumnName = "id")
	private ClinicTypeEntity clinicType;
	
	@OneToMany(mappedBy = "clinic")
	private Set<NephrologistBaseClinicEntity> baseClinics = new HashSet<>();	
	
	private ClinicEntity(Long id, String name, String administrator, String email, String director, CityEntity city,
			int capacity, ClinicTypeEntity clinicType) {
		super();
		this.id = id;
		this.name = name;
		this.administrator = administrator;
		this.email = email;
		this.director = director;
		this.city = city;
		this.capacity = capacity;
		this.clinicType = clinicType;
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
		ClinicEntity other = (ClinicEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClinicEntity [id=" + id + ", name=" + name + ", administrator=" + administrator + ", email=" + email
				+ ", director=" + director + ", city=" + city + ", capacity=" + capacity + ", clinicType=" + clinicType
				+ "]";
	}
	
	

}
