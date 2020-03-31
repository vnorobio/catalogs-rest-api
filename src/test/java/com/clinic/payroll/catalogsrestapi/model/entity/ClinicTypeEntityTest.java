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

public class ClinicTypeEntityTest {

	private static Validator validator;
	
	private static ClinicTypeEntity validClinicTypeEntity;

	@BeforeAll
	public static void setupValidatorInstance() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
		validClinicTypeEntity = new ClinicTypeEntity(1L, "valid clinic type");
	}

	@DisplayName("ClinicTypeEntityTest - Not null description test")
	@Test
	public void whenNullDescription_thenOneConstraintViolation() {
		ClinicTypeEntity nullDescriptionClinicType = new ClinicTypeEntity();

		nullDescriptionClinicType.setClinicTypeId(1L);
		nullDescriptionClinicType.setDescription(null);

		Set<ConstraintViolation<ClinicTypeEntity>> violations = validator.validate(nullDescriptionClinicType);

		assertThat(violations.size()).isEqualTo(1);
	}

	@DisplayName("ClinicTypeEntityTest - hashCode method test")
	@Test
	public void hashCodeMethodTest() {

		assertThat(Objects.nonNull(validClinicTypeEntity.hashCode()));

	}

	@DisplayName("ClinicTypeEntityTest - toString method test")
	@Test
	public void toStringMethodTest() {

		assertThat(Objects.nonNull(validClinicTypeEntity.toString()));

	}

	@DisplayName("ClinicTypeEntityTest - equals method test")
	@Test
	public void equalsMethodTest() {
		ClinicTypeEntity equalClinicType = new ClinicTypeEntity();
		equalClinicType.setClinicTypeId(validClinicTypeEntity.getClinicTypeId());
		equalClinicType.setDescription(validClinicTypeEntity.getDescription());

		ClinicTypeEntity nonEqualClinicType = new ClinicTypeEntity(2L, "valid clinic type");

		assertTrue(validClinicTypeEntity.equals(equalClinicType));
		assertFalse(validClinicTypeEntity.equals(nonEqualClinicType));

	}

}


