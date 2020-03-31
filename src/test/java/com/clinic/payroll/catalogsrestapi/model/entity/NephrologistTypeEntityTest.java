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

public class NephrologistTypeEntityTest {

	private static Validator validator;
	
	private static NephrologistTypeEntity validNephrologistTypeEntity;

	@BeforeAll
	public static void setupValidatorInstance() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
		validNephrologistTypeEntity = new NephrologistTypeEntity(1L, "valid Nephrologist Type");
	}

	@DisplayName("NephrologistTypeEntityTest - Not null description test")
	@Test
	public void whenNullDescription_thenOneConstraintViolation() {
		NephrologistTypeEntity nullDescriptionNephrologistType = new NephrologistTypeEntity();

		nullDescriptionNephrologistType.setNephrologistTypeId(1L);
		nullDescriptionNephrologistType.setDescription(null);

		Set<ConstraintViolation<NephrologistTypeEntity>> violations = validator.validate(nullDescriptionNephrologistType);

		assertThat(violations.size()).isEqualTo(1);
	}

	@DisplayName("NephrologistTypeEntityTest - hashCode method test")
	@Test
	public void hashCodeMethodTest() {

		assertThat(Objects.nonNull(validNephrologistTypeEntity.hashCode()));

	}

	@DisplayName("NephrologistTypeEntityTest - toString method test")
	@Test
	public void toStringMethodTest() {

		assertThat(Objects.nonNull(validNephrologistTypeEntity.toString()));

	}

	@DisplayName("NephrologistTypeEntityTest - equals method test")
	@Test
	public void equalsMethodTest() {
		NephrologistTypeEntity equalNephrologistType = new NephrologistTypeEntity();
		equalNephrologistType.setNephrologistTypeId(validNephrologistTypeEntity.getNephrologistTypeId());
		equalNephrologistType.setDescription(validNephrologistTypeEntity.getDescription());

		NephrologistTypeEntity nonEqualNephrologistType = new NephrologistTypeEntity(2L, "valid Nephrologist Type");

		assertTrue(validNephrologistTypeEntity.equals(equalNephrologistType));
		assertFalse(validNephrologistTypeEntity.equals(nonEqualNephrologistType));

	}

}


