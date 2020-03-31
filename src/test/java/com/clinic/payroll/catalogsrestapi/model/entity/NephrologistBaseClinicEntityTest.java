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

public class NephrologistBaseClinicEntityTest {

	private static Validator validator;

	private static ClinicEntity validClinicEntity;
	
	private static NephrologistEntity validNephrologistEntity;

	private static NephrologistBaseClinicEntity validNephrologistBaseClinicEntity;
	

	@BeforeAll
	public static void setupValidatorInstance() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
		validNephrologistEntity = new NephrologistEntity();
		validClinicEntity = new ClinicEntity();
		validNephrologistBaseClinicEntity = new NephrologistBaseClinicEntity(1L, validNephrologistEntity, validClinicEntity, Double.parseDouble("30000"), Double.parseDouble("20"));
	}

	@DisplayName("NephrologistBaseClinicEntityTest - Not null Nephrologist test")
	@Test
	public void whenNullNephrologist_thenOneConstraintViolation() {
		NephrologistBaseClinicEntity nullDescriptionNephrologistBaseClinic = new NephrologistBaseClinicEntity();
		
		nullDescriptionNephrologistBaseClinic.setBaseClinicId(validNephrologistBaseClinicEntity.getBaseClinicId());
		nullDescriptionNephrologistBaseClinic.setNephrologist(null);
		nullDescriptionNephrologistBaseClinic.setClinic(validNephrologistBaseClinicEntity.getClinic());
		nullDescriptionNephrologistBaseClinic.setSalary(validNephrologistBaseClinicEntity.getSalary());
		nullDescriptionNephrologistBaseClinic.setDedicationHours(validNephrologistBaseClinicEntity.getDedicationHours());

		Set<ConstraintViolation<NephrologistBaseClinicEntity>> violations = validator.validate(nullDescriptionNephrologistBaseClinic);

		assertThat(violations.size()).isEqualTo(1);
	}

	@DisplayName("NephrologistBaseClinicEntityTest - Not null Clinic test")
	@Test
	public void whenNullClinic_thenOneConstraintViolation() {
		NephrologistBaseClinicEntity baseClinicEntit = new NephrologistBaseClinicEntity(1L, validNephrologistEntity, null, Double.parseDouble("30000"), Double.parseDouble("20"));

		Set<ConstraintViolation<NephrologistBaseClinicEntity>> violations = validator.validate(baseClinicEntit);

		assertThat(violations.size()).isEqualTo(1);
	}
	
	@DisplayName("NephrologistBaseClinicEntityTest - Not null Sallary type test")
	@Test
	public void whenNullSalary_thenOneConstraintViolation() {
		NephrologistBaseClinicEntity baseClinicEntit = new NephrologistBaseClinicEntity(1L, validNephrologistEntity, validClinicEntity, null, Double.parseDouble("20"));

		Set<ConstraintViolation<NephrologistBaseClinicEntity>> violations = validator.validate(baseClinicEntit);

		assertThat(violations.size()).isEqualTo(1);
	}	
	
	@DisplayName("NephrologistBaseClinicEntityTest - Not null Sallary type test")
	@Test
	public void whenNullDedicationHours_thenOneConstraintViolation() {
		NephrologistBaseClinicEntity baseClinicEntit = new NephrologistBaseClinicEntity(1L, validNephrologistEntity, validClinicEntity, Double.parseDouble("30000"), null);

		Set<ConstraintViolation<NephrologistBaseClinicEntity>> violations = validator.validate(baseClinicEntit);

		assertThat(violations.size()).isEqualTo(1);
	}	

	@DisplayName("NephrologistBaseClinicEntityTest - hashCode method test")
	@Test
	public void hashCodeMethodTest() {

		assertThat(Objects.nonNull(validNephrologistBaseClinicEntity.hashCode()));

	}

	@DisplayName("NephrologistBaseClinicEntityTest - toString method test")
	@Test
	public void toStringMethodTest() {

		assertThat(Objects.nonNull(validNephrologistBaseClinicEntity.toString()));

	}

	@DisplayName("NephrologistBaseClinicEntityTest - equals method test")
	@Test
	public void equalsMethodTest() {
		NephrologistBaseClinicEntity equalNephrologistBaseClinic = new NephrologistBaseClinicEntity();
		equalNephrologistBaseClinic.setBaseClinicId(validNephrologistBaseClinicEntity.getBaseClinicId());
		equalNephrologistBaseClinic.setNephrologist(validNephrologistBaseClinicEntity.getNephrologist());
		equalNephrologistBaseClinic.setClinic(validNephrologistBaseClinicEntity.getClinic());
		equalNephrologistBaseClinic.setSalary(validNephrologistBaseClinicEntity.getSalary());
		equalNephrologistBaseClinic.setDedicationHours(validNephrologistBaseClinicEntity.getDedicationHours());

		NephrologistBaseClinicEntity nonEqualNephrologistBaseClinic = new NephrologistBaseClinicEntity(2L, validNephrologistEntity, validClinicEntity, Double.parseDouble("30000"), Double.parseDouble("20"));

		assertTrue(validNephrologistBaseClinicEntity.equals(equalNephrologistBaseClinic));
		assertFalse(validNephrologistBaseClinicEntity.equals(nonEqualNephrologistBaseClinic));

	}

}
