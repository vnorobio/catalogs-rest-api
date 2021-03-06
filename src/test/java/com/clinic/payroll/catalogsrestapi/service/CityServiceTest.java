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

import com.clinic.payroll.catalogsrestapi.model.entity.CityEntity;
import com.clinic.payroll.catalogsrestapi.model.entity.ZoneEntity;
import com.clinic.payroll.catalogsrestapi.repository.CityRepository;

@SpringBootTest
public class CityServiceTest {

	@InjectMocks
	private CityService service = new CityServiceImpl();

	@Mock
	private CityRepository repository;
	
	@Mock
	private ZoneEntity zone;

	@DisplayName("CityServiceTest - Test findAll method")
	@Test
	void findAllTest() {

		// given
		List<CityEntity> expectedEntities = new ArrayList<CityEntity> ();

		expectedEntities.add(new CityEntity(1L, "Primera", zone));
		expectedEntities.add(new CityEntity(2L, "Segunda", zone));
		expectedEntities.add(new CityEntity(3L, "Tercera", zone));

		doReturn(expectedEntities).when(repository).findAll();

		// when
		List<CityEntity> actualEntities = service.findAll();

		// then
		assertThat(actualEntities).isEqualTo(expectedEntities);

	}

	
	@DisplayName("CityServiceTest - Test findById method")
	@Test
	void findByIdTest() {
		// given
		ZoneEntity zone = new ZoneEntity(1L, "Zona centro");
		final Long id = 2L;
		CityEntity entity = new CityEntity(2L, "Segunda", zone);
		final Optional<CityEntity> expectedEntity = Optional.of(entity);

		doReturn(Optional.of(entity)).when(repository).findById(id);
		
		// when
		final Optional<CityEntity> actualdEntity = service.findById(id);

		// then
		assertThat(actualdEntity).isEqualTo(expectedEntity);

	}
	
	@DisplayName("CityServiceTest - Test update method")
	@Test
	void updateTest() {
		// given
		ZoneEntity zone = new ZoneEntity(1L, "Zona centro");
		CityEntity entity = new CityEntity(2L, "Segunda", zone);

		doReturn(entity).when(repository).save(entity);
		
		// when
		final CityEntity actualdEntity = service.saveOrUpdate(entity);

		// then
		
		assertThat(actualdEntity).isNotNull();
		verify(repository).save(entity);

	}	
	

	@DisplayName("CityServiceTest - Test delete method")
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

