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

import com.clinic.payroll.catalogsrestapi.model.entity.ClinicEntity;
import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistBaseClinicEntity;
import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistEntity;
import com.clinic.payroll.catalogsrestapi.repository.NephrologistBaseClinicRepository;

@SpringBootTest
public class NephrologistBaseClinicServiceTest {

	@InjectMocks
	private NephrologistBaseClinicService service = new NephrologistBaseClinicServiceImpl();

	@Mock
	private NephrologistBaseClinicRepository repository;
	
	@Mock
	private NephrologistEntity nephrologist;
	
	@Mock
	private ClinicEntity clinic;

	@DisplayName("NephrologistBaseClinicServiceTest - Test findAll method")
	@Test
	void findAllTest() {

		// given
		List<NephrologistBaseClinicEntity> expectedEntities = new ArrayList<NephrologistBaseClinicEntity> ();

		expectedEntities.add(new NephrologistBaseClinicEntity(1L, nephrologist, clinic, Double.parseDouble("3500"),Double.parseDouble("4")));
		expectedEntities.add(new NephrologistBaseClinicEntity(2L, nephrologist, clinic, Double.parseDouble("3500"),Double.parseDouble("4")));
		expectedEntities.add(new NephrologistBaseClinicEntity(3L, nephrologist, clinic, Double.parseDouble("3500"),Double.parseDouble("4")));

		doReturn(expectedEntities).when(repository).findAll();

		// when
		List<NephrologistBaseClinicEntity> actualEntities = service.findAll();

		// then
		assertThat(actualEntities).isEqualTo(expectedEntities);

	}

	
	@DisplayName("NephrologistBaseClinicServiceTest - Test findById method")
	@Test
	void findByIdTest() {
		// given
		
		final Long id = 2L;
		NephrologistBaseClinicEntity entity = new NephrologistBaseClinicEntity(1L, nephrologist, clinic, Double.parseDouble("3500"), Double.parseDouble("4"));
		final Optional<NephrologistBaseClinicEntity> expectedEntity = Optional.of(entity);

		doReturn(Optional.of(entity)).when(repository).findById(id);
		
		// when
		final Optional<NephrologistBaseClinicEntity> actualdEntity = service.findById(id);

		// then
		assertThat(actualdEntity).isEqualTo(expectedEntity);

	}
	
	@DisplayName("NephrologistBaseClinicServiceTest - Test update method")
	@Test
	void updateTest() {
		// given
		NephrologistBaseClinicEntity entity = new NephrologistBaseClinicEntity(1L, nephrologist, clinic, Double.parseDouble("3500"), Double.parseDouble("4"));

		doReturn(entity).when(repository).save(entity);
		
		// when
		final NephrologistBaseClinicEntity actualdEntity = service.saveOrUpdate(entity);

		// then
		
		assertThat(actualdEntity).isNotNull();
		verify(repository).save(entity);

	}	
	

	@DisplayName("NephrologistBaseClinicServiceTest - Test delete method")
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

