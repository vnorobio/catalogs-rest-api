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

import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistTypeEntity;
import com.clinic.payroll.catalogsrestapi.repository.NephrologistTypeRepository;

@SpringBootTest
public class NephrologistTypeServiceTest {

	@InjectMocks
	private NephrologistTypeService service = new NephrologistTypeServiceImpl();

	@Mock
	private NephrologistTypeRepository repository;

	@DisplayName("NephrologistTypeServiceTest - Test findAll method")
	@Test
	void findAllTest() {

		// given
		List<NephrologistTypeEntity> expectedEntities = new ArrayList<NephrologistTypeEntity> ();

		expectedEntities.add(new NephrologistTypeEntity(1L, "Primera"));
		expectedEntities.add(new NephrologistTypeEntity(2L, "Segunda"));
		expectedEntities.add(new NephrologistTypeEntity(3L, "Tercera"));

		doReturn(expectedEntities).when(repository).findAll();

		// when
		List<NephrologistTypeEntity> actualEntities = service.findAll();

		// then
		assertThat(actualEntities).isEqualTo(expectedEntities);

	}

	
	@DisplayName("NephrologistTypeServiceTest - Test findById method")
	@Test
	void findByIdTest() {
		// given
		
		final Long id = 2L;
		NephrologistTypeEntity entity = new NephrologistTypeEntity(2L, "Segunda");
		final Optional<NephrologistTypeEntity> expectedEntity = Optional.of(entity);

		doReturn(Optional.of(entity)).when(repository).findById(id);
		
		// when
		final Optional<NephrologistTypeEntity> actualdEntity = service.findById(id);

		// then
		assertThat(actualdEntity).isEqualTo(expectedEntity);

	}
	
	@DisplayName("NephrologistTypeServiceTest - Test update method")
	@Test
	void updateTest() {
		// given
		NephrologistTypeEntity entity = new NephrologistTypeEntity(2L, "Segunda");

		doReturn(entity).when(repository).save(entity);
		
		// when
		final NephrologistTypeEntity actualdEntity = service.saveOrUpdate(entity);

		// then
		
		assertThat(actualdEntity).isNotNull();
		verify(repository).save(entity);

	}	
	

	@DisplayName("NephrologistTypeServiceTest - Test delete method")
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
