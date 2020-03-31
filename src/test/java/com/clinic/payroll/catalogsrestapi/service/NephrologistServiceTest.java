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

import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistEntity;
import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistTypeEntity;
import com.clinic.payroll.catalogsrestapi.repository.NephrologistRepository;

@SpringBootTest
public class NephrologistServiceTest {

	@InjectMocks
	private NephrologistService service = new NephrologistServiceImpl();

	@Mock
	private NephrologistRepository repository;
	
	@Mock
	private NephrologistTypeEntity nephrologistType;

	@DisplayName("NephrologistServiceTest - Test findAll method")
	@Test
	void findAllTest() {

		// given
		List<NephrologistEntity> expectedEntities = new ArrayList<NephrologistEntity> ();

		expectedEntities.add(new NephrologistEntity(1L, "Primera", nephrologistType,"email@server.com",Boolean.TRUE));
		expectedEntities.add(new NephrologistEntity(2L, "Segunda", nephrologistType,"email@server.com",Boolean.TRUE));
		expectedEntities.add(new NephrologistEntity(3L, "Tercera", nephrologistType,"email@server.com",Boolean.TRUE));

		doReturn(expectedEntities).when(repository).findAll();

		// when
		List<NephrologistEntity> actualEntities = service.findAll();

		// then
		assertThat(actualEntities).isEqualTo(expectedEntities);

	}

	
	@DisplayName("NephrologistServiceTest - Test findById method")
	@Test
	void findByIdTest() {
		// given
		
		final Long id = 2L;
		NephrologistEntity entity = new NephrologistEntity(2L, "Segunda", nephrologistType,"email@server.com",Boolean.TRUE);
		final Optional<NephrologistEntity> expectedEntity = Optional.of(entity);

		doReturn(Optional.of(entity)).when(repository).findById(id);
		
		// when
		final Optional<NephrologistEntity> actualdEntity = service.findById(id);

		// then
		assertThat(actualdEntity).isEqualTo(expectedEntity);

	}
	
	@DisplayName("NephrologistServiceTest - Test update method")
	@Test
	void updateTest() {
		// given
		NephrologistEntity entity = new NephrologistEntity(2L, "Segunda", nephrologistType,"email@server.com",Boolean.TRUE);

		doReturn(entity).when(repository).save(entity);
		
		// when
		final NephrologistEntity actualdEntity = service.saveOrUpdate(entity);

		// then
		
		assertThat(actualdEntity).isNotNull();
		verify(repository).save(entity);

	}	
	

	@DisplayName("NephrologistServiceTest - Test delete method")
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

