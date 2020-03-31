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

public class ZoneEntityTest {

	private static Validator validator;
	
	private static ZoneEntity validZoneEntity;

	@BeforeAll
	public static void setupValidatorInstance() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
		validZoneEntity = new ZoneEntity(1L, "valid zone");
	}

	@DisplayName("ZoneEntityTest - Not null description test")
	@Test
	public void whenNullDescription_thenOneConstraintViolation() {
		ZoneEntity nullDescriptionZone = new ZoneEntity();

		nullDescriptionZone.setZoneId(1L);
		nullDescriptionZone.setDescription(null);

		Set<ConstraintViolation<ZoneEntity>> violations = validator.validate(nullDescriptionZone);

		assertThat(violations.size()).isEqualTo(1);
	}

	@DisplayName("ZoneEntityTest - hashCode method test")
	@Test
	public void hashCodeMethodTest() {

		assertThat(Objects.nonNull(validZoneEntity.hashCode()));

	}

	@DisplayName("ZoneEntityTest - toString method test")
	@Test
	public void toStringMethodTest() {

		assertThat(Objects.nonNull(validZoneEntity.toString()));

	}

	@DisplayName("ZoneEntityTest - equals method test")
	@Test
	public void equalsMethodTest() {
		ZoneEntity equalZone = new ZoneEntity();
		equalZone.setZoneId(validZoneEntity.getZoneId());
		equalZone.setDescription(validZoneEntity.getDescription());

		ZoneEntity nonEqualZone = new ZoneEntity(2L, "valid zone");

		assertTrue(validZoneEntity.equals(equalZone));
		assertFalse(validZoneEntity.equals(nonEqualZone));

	}

}

