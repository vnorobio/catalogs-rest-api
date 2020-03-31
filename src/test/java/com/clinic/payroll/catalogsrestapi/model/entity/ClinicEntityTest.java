package com.clinic.payroll.catalogsrestapi.model.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClinicEntityTest {

	private static Validator validator;

	private static CityEntity validCityEntity;
	
	private static ZoneEntity validZoneEntity;

	private static ClinicEntity validClinicEntity;
	
	private static ClinicTypeEntity validClinicTypeEntity;

	@BeforeAll
	public static void setupValidatorInstance() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
		validZoneEntity = new ZoneEntity();
		validClinicTypeEntity = new ClinicTypeEntity();
		validCityEntity = new CityEntity(1L, "valid City",validZoneEntity);
		validClinicEntity = new ClinicEntity(1L, "valid Clinic", "Administrator", "email@server.com", "Director", validCityEntity, 20,validClinicTypeEntity);
	}

	@DisplayName("ClinicEntityTest - Not null name test")
	@Test
	public void whenNullDescription_thenOneConstraintViolation() {
		CityEntity city = new CityEntity(1L, "Test City", validZoneEntity);
		ClinicEntity nullDescriptionClinic = new ClinicEntity();
		
		nullDescriptionClinic.setClinicId(validClinicEntity.getClinicId());
		nullDescriptionClinic.setName(null);
		nullDescriptionClinic.setAdministrator(validClinicEntity.getAdministrator());
		nullDescriptionClinic.setEmail(validClinicEntity.getEmail());
		nullDescriptionClinic.setDirector(validClinicEntity.getDirector());
		nullDescriptionClinic.setCity(validClinicEntity.getCity());
		nullDescriptionClinic.setCapacity(validClinicEntity.getCapacity());
		nullDescriptionClinic.setClinicType(validClinicEntity.getClinicType());

		Set<ConstraintViolation<ClinicEntity>> violations = validator.validate(nullDescriptionClinic);

		assertThat(violations.size()).isEqualTo(1);
	}

	@DisplayName("ClinicEntityTest - Not null city test")
	@Test
	public void whenNullCity_thenOneConstraintViolation() {
		ClinicEntity city = new ClinicEntity(1L, "valid Clinic", "Administrator", "email@server.com", "Director", null, 20,validClinicTypeEntity);

		Set<ConstraintViolation<ClinicEntity>> violations = validator.validate(city);

		assertThat(violations.size()).isEqualTo(1);
	}
	
	@DisplayName("ClinicEntityTest - Not null clinic type test")
	@Test
	public void whenNullCapacity_thenOneConstraintViolation() {
		ClinicEntity city = new ClinicEntity(1L, "valid Clinic", "Administrator", "email@server.com", "Director", validCityEntity, 20, null);

		Set<ConstraintViolation<ClinicEntity>> violations = validator.validate(city);

		assertThat(violations.size()).isEqualTo(1);
	}	

	@DisplayName("ClinicEntityTest - hashCode method test")
	@Test
	public void hashCodeMethodTest() {

		assertThat(Objects.nonNull(validClinicEntity.hashCode()));

	}

	@DisplayName("ClinicEntityTest - toString method test")
	@Test
	public void toStringMethodTest() {

		assertThat(Objects.nonNull(validClinicEntity.toString()));

	}

	@DisplayName("ClinicEntityTest - equals method test")
	@Test
	public void equalsMethodTest() {
		ClinicEntity equalClinic = new ClinicEntity();
		equalClinic.setClinicId(validClinicEntity.getClinicId());
		equalClinic.setName(validClinicEntity.getName());
		equalClinic.setAdministrator(validClinicEntity.getAdministrator());
		equalClinic.setEmail(validClinicEntity.getEmail());
		equalClinic.setDirector(validClinicEntity.getDirector());
		equalClinic.setCity(validClinicEntity.getCity());
		equalClinic.setCapacity(validClinicEntity.getCapacity());
		equalClinic.setClinicType(validClinicEntity.getClinicType());

		ClinicEntity nonEqualClinic = new ClinicEntity(2L, "valid Clinic", "Administrator", "email@server.com", "Director", null, 20,validClinicTypeEntity);

		assertTrue(validClinicEntity.equals(equalClinic));
		assertFalse(validClinicEntity.equals(nonEqualClinic));

	}

}
