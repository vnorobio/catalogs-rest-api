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

import com.clinic.payroll.catalogsrestapi.model.entity.ZoneEntity;
import com.clinic.payroll.catalogsrestapi.repository.ZoneRepository;

@SpringBootTest
public class ZoneServiceTest {

	@InjectMocks
	private ZoneService service = new ZoneServiceImpl();

	@Mock
	private ZoneRepository repository;

	@DisplayName("ZoneServiceTest - Test findAll method")
	@Test
	void findAllTest() {

		// given
		List<ZoneEntity> expectedEntities = new ArrayList<ZoneEntity> ();

		expectedEntities.add(new ZoneEntity(1L, "Primera"));
		expectedEntities.add(new ZoneEntity(2L, "Segunda"));
		expectedEntities.add(new ZoneEntity(3L, "Tercera"));

		doReturn(expectedEntities).when(repository).findAll();

		// when
		List<ZoneEntity> actualEntities = service.findAll();

		// then
		assertThat(actualEntities).isEqualTo(expectedEntities);

	}

	
	@DisplayName("ZoneServiceTest - Test findById method")
	@Test
	void findByIdTest() {
		// given
		
		final Long id = 2L;
		ZoneEntity entity = new ZoneEntity(2L, "Segunda");
		final Optional<ZoneEntity> expectedEntity = Optional.of(entity);

		doReturn(Optional.of(entity)).when(repository).findById(id);
		
		// when
		final Optional<ZoneEntity> actualdEntity = service.findById(id);

		// then
		assertThat(actualdEntity).isEqualTo(expectedEntity);

	}
	
	@DisplayName("ZoneServiceTest - Test update method")
	@Test
	void updateTest() {
		// given
		ZoneEntity entity = new ZoneEntity(2L, "Segunda");

		doReturn(entity).when(repository).save(entity);
		
		// when
		final ZoneEntity actualdEntity = service.saveOrUpdate(entity);

		// then
		
		assertThat(actualdEntity).isNotNull();
		verify(repository).save(entity);

	}	
	

	@DisplayName("ZoneServiceTest - Test delete method")
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
