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

public class UserEntityTest {

	private static Validator validator;

	private static UserEntity validUserEntity;
	

	@BeforeAll
	public static void setupValidatorInstance() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
		validUserEntity = new UserEntity(1L, "login", "password", "name", "email@server.com");
	}

	@DisplayName("UserEntityTest - Not null Login test")
	@Test
	public void whenNullLogin_thenOneConstraintViolation() {
		UserEntity nullDescriptionUser = new UserEntity();
		nullDescriptionUser.setUserId(validUserEntity.getUserId());
		nullDescriptionUser.setLogin(null);;
		nullDescriptionUser.setPassword(validUserEntity.getPassword());
		nullDescriptionUser.setName(validUserEntity.getName());
		nullDescriptionUser.setEmail(validUserEntity.getEmail());

		Set<ConstraintViolation<UserEntity>> violations = validator.validate(nullDescriptionUser);

		assertThat(violations.size()).isEqualTo(1);
	}

	@DisplayName("UserEntityTest - Not null Password test")
	@Test
	public void whenNullPassword_thenOneConstraintViolation() {
		UserEntity User = new UserEntity(1L, "login", null, "name", "email@server.com");

		Set<ConstraintViolation<UserEntity>> violations = validator.validate(User);

		assertThat(violations.size()).isEqualTo(1);
	}
	
	@DisplayName("UserEntityTest - Not null Name type test")
	@Test
	public void whenNullName_thenOneConstraintViolation() {
		UserEntity User = new UserEntity(1L, "login", "password", null, "email@server.com");

		Set<ConstraintViolation<UserEntity>> violations = validator.validate(User);

		assertThat(violations.size()).isEqualTo(1);
	}	
	
	@DisplayName("UserEntityTest - Not null Email type test")
	@Test
	public void whenNullEmail_thenOneConstraintViolation() {
		UserEntity User = new UserEntity(1L, "login", "password", "name", null);

		Set<ConstraintViolation<UserEntity>> violations = validator.validate(User);

		assertThat(violations.size()).isEqualTo(1);
	}	

	@DisplayName("UserEntityTest - hashCode method test")
	@Test
	public void hashCodeMethodTest() {

		assertThat(Objects.nonNull(validUserEntity.hashCode()));

	}

	@DisplayName("UserEntityTest - toString method test")
	@Test
	public void toStringMethodTest() {

		assertThat(Objects.nonNull(validUserEntity.toString()));

	}

	@DisplayName("UserEntityTest - equals method test")
	@Test
	public void equalsMethodTest() {
		UserEntity equalUser = new UserEntity();
		equalUser.setUserId(validUserEntity.getUserId());
		equalUser.setLogin(validUserEntity.getLogin());;
		equalUser.setPassword(validUserEntity.getPassword());
		equalUser.setName(validUserEntity.getName());
		equalUser.setEmail(validUserEntity.getEmail());
		
		assertTrue(validUserEntity.equals(equalUser));
		
		equalUser = new UserEntity(2L, "login", "password", "name", "email@server.comX");
		
		assertTrue(validUserEntity.equals(equalUser));
		
		equalUser = new UserEntity(2L, "loginX", "password", "name", "email@server.com");
		
		assertTrue(validUserEntity.equals(equalUser));		

		UserEntity nonEqualUser = new UserEntity(2L, "loginX", "password", "name", "email@server.comX");
		
		assertFalse(validUserEntity.equals(nonEqualUser));

	}

}
