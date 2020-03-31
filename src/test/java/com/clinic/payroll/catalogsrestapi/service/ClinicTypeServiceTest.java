package com.clinic.payroll.catalogsrestapi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.clinic.payroll.catalogsrestapi.model.entity.ClinicTypeEntity;
import com.clinic.payroll.catalogsrestapi.repository.ClinicTypeRepository;

@SpringBootTest
public class ClinicTypeServiceTest {

	@InjectMocks
	private ClinicTypeService service = new ClinicTypeServiceImpl();

	@Mock
	private ClinicTypeRepository repository;

	@DisplayName("ClinicTypeServiceTest - Test findAll method")
	@Test
	void findAllTest() {

		// given
		List<ClinicTypeEntity> expectedEntities = new ArrayList<ClinicTypeEntity> ();

		expectedEntities.add(new ClinicTypeEntity(1L, "Primera"));
		expectedEntities.add(new ClinicTypeEntity(2L, "Segunda"));
		expectedEntities.add(new ClinicTypeEntity(3L, "Tercera"));

		doReturn(expectedEntities).when(repository).findAll();

		// when
		List<ClinicTypeEntity> actualEntities = service.findAll();

		// then
		assertThat(actualEntities).isEqualTo(expectedEntities);

	}

	
	@DisplayName("ClinicTypeServiceTest - Test findById method")
	@Test
	void findByIdTest() {
		// given
		
		final Long id = 2L;
		ClinicTypeEntity entity = new ClinicTypeEntity(2L, "Segunda");
		final Optional<ClinicTypeEntity> expectedEntity = Optional.of(entity);

		doReturn(Optional.of(entity)).when(repository).findById(id);
		
		// when
		final Optional<ClinicTypeEntity> actualdEntity = service.findById(id);

		// then
		assertThat(actualdEntity).isEqualTo(expectedEntity);

	}
	
	@DisplayName("ClinicTypeServiceTest - Test update method")
	@Test
	void updateTest() {
		// given
		ClinicTypeEntity entity = new ClinicTypeEntity(2L, "Segunda");

		doReturn(entity).when(repository).save(entity);
		
		// when
		final ClinicTypeEntity actualdEntity = service.saveOrUpdate(entity);

		// then
		
		assertThat(actualdEntity).isNotNull();
		verify(repository).save(entity);

	}	
	

	@DisplayName("ClinicTypeServiceTest - Test delete method")
	@Test
	void deleteTest() {
		// given
	
		final Long id = 1L;
		
		// when
		repository.deleteById(id);
		
		repository.deleteById(id);

		// then
		verify(repository, times(2)).deleteById(id);

	}
	
}

