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

public class CityEntityTest {

	private static Validator validator;

	private static ZoneEntity validZoneEntity;

	private static CityEntity validCityEntity;

	@BeforeAll
	public static void setupValidatorInstance() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
		validZoneEntity = new ZoneEntity(1L, "valid zone");
		validCityEntity = new CityEntity(1L, "valid city", validZoneEntity);
	}

	@DisplayName("CityEntityTest - Not null description test")
	@Test
	public void whenNullDescription_thenOneConstraintViolation() {
		ZoneEntity zone = new ZoneEntity(1L, "zona de prueba");
		CityEntity nullDescriptionCity = new CityEntity();

		nullDescriptionCity.setCityId(1L);
		nullDescriptionCity.setDescription(null);
		nullDescriptionCity.setZone(zone);

		Set<ConstraintViolation<CityEntity>> violations = validator.validate(nullDescriptionCity);

		assertThat(violations.size()).isEqualTo(1);
	}

	@DisplayName("CityEntityTest - Not null zone test")
	@Test
	public void whenNullZone_thenOneConstraintViolation() {
		ZoneEntity nullZone = null;
		CityEntity city = new CityEntity(1L, "Ciudad", nullZone);

		Set<ConstraintViolation<CityEntity>> violations = validator.validate(city);

		assertThat(violations.size()).isEqualTo(1);
	}

	@DisplayName("CityEntityTest - hashCode method test")
	@Test
	public void hashCodeMethodTest() {

		assertThat(Objects.nonNull(validCityEntity.hashCode()));

	}

	@DisplayName("CityEntityTest - toString method test")
	@Test
	public void toStringMethodTest() {

		assertThat(Objects.nonNull(validCityEntity.toString()));

	}

	@DisplayName("CityEntityTest - equals method test")
	@Test
	public void equalsMethodTest() {
		CityEntity equalCity = new CityEntity();
		equalCity.setCityId(validCityEntity.getCityId());
		equalCity.setDescription(validCityEntity.getDescription());
		equalCity.setZone(validCityEntity.getZone());

		CityEntity nonEqualCity = new CityEntity(2L, "valid city", validZoneEntity);

		assertTrue(validCityEntity.equals(equalCity));
		assertFalse(validCityEntity.equals(nonEqualCity));

	}

}
