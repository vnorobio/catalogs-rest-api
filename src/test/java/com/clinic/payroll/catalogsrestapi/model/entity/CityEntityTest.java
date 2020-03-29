package com.clinic.payroll.catalogsrestapi.model.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class CityEntityTest {
	
	private static Validator validator;

	@BeforeAll
	public static void setupValidatorInstance() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@DisplayName("CityEntityTest - Not null description test")
	@Test
	public void whenNullDescription_thenOneConstraintViolation() {
		ZoneEntity zone = new ZoneEntity(1L, "zona de prueba");
		CityEntity city = new CityEntity(1L, null, zone);
		Set<ConstraintViolation<CityEntity>> violations = validator.validate(city);

		assertThat(violations.size()).isEqualTo(3);
	}
	
	@DisplayName("CityEntityTest - Not null zone test")
	@Test
	public void whenNullZone_thenOneConstraintViolation() {
		ZoneEntity zone = null;
		CityEntity city = new CityEntity(1L, "Ciudad", zone);
		Set<ConstraintViolation<CityEntity>> violations = validator.validate(city);

		assertThat(violations.size()).isEqualTo(3);
	}	

}
