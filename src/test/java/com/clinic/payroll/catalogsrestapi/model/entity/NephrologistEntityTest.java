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

public class NephrologistEntityTest {

	private static Validator validator;
	
	private static NephrologistEntity validNephrologistEntity;
	
	private static NephrologistTypeEntity validNephrologistTypeEntity;

	@BeforeAll
	public static void setupValidatorInstance() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
		validNephrologistTypeEntity = new NephrologistTypeEntity();
		validNephrologistEntity = new NephrologistEntity(1L, "valid Nephrologist", validNephrologistTypeEntity, "email@server.com", Boolean.TRUE);
	}

	@DisplayName("NephrologistEntityTest - Not null name test")
	@Test
	public void whenNullDescription_thenOneConstraintViolation() {
		NephrologistEntity nullDescriptionNephrologist = new NephrologistEntity();
		
		nullDescriptionNephrologist.setNephrologistId(validNephrologistEntity.getNephrologistId());
		nullDescriptionNephrologist.setName(null);
		nullDescriptionNephrologist.setNephrologistType(validNephrologistEntity.getNephrologistType());
		nullDescriptionNephrologist.setEmail(validNephrologistEntity.getEmail());
		nullDescriptionNephrologist.setActive(validNephrologistEntity.getActive());

		Set<ConstraintViolation<NephrologistEntity>> violations = validator.validate(nullDescriptionNephrologist);

		assertThat(violations.size()).isEqualTo(1);
	}

	
	@DisplayName("NephrologistEntityTest - Not null clinic type test")
	@Test
	public void whenNullCapacity_thenOneConstraintViolation() {
		NephrologistEntity nephrologist = new NephrologistEntity(1L, "valid Nephrologist", null, "email@server.com", Boolean.TRUE);

		Set<ConstraintViolation<NephrologistEntity>> violations = validator.validate(nephrologist);

		assertThat(violations.size()).isEqualTo(1);
	}	

	@DisplayName("NephrologistEntityTest - hashCode method test")
	@Test
	public void hashCodeMethodTest() {

		assertThat(Objects.nonNull(validNephrologistEntity.hashCode()));

	}

	@DisplayName("NephrologistEntityTest - toString method test")
	@Test
	public void toStringMethodTest() {

		assertThat(Objects.nonNull(validNephrologistEntity.toString()));

	}

	@DisplayName("NephrologistEntityTest - equals method test")
	@Test
	public void equalsMethodTest() {
		NephrologistEntity equalNephrologist = new NephrologistEntity();
		equalNephrologist.setNephrologistId(validNephrologistEntity.getNephrologistId());
		equalNephrologist.setName(validNephrologistEntity.getName());
		equalNephrologist.setNephrologistType(validNephrologistEntity.getNephrologistType());
		equalNephrologist.setEmail(validNephrologistEntity.getEmail());
		equalNephrologist.setActive(validNephrologistEntity.getActive());
		
		NephrologistEntity nonEqualNephrologist = new NephrologistEntity(2L, "valid Nephrologist", validNephrologistTypeEntity, "email@server.com", Boolean.TRUE);

		assertTrue(validNephrologistEntity.equals(equalNephrologist));
		assertFalse(validNephrologistEntity.equals(nonEqualNephrologist));

	}

}

