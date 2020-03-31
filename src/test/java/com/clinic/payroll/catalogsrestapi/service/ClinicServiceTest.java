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
import com.clinic.payroll.catalogsrestapi.model.entity.ClinicEntity;
import com.clinic.payroll.catalogsrestapi.model.entity.ClinicTypeEntity;
import com.clinic.payroll.catalogsrestapi.repository.ClinicRepository;

@SpringBootTest
public class ClinicServiceTest {

	@InjectMocks
	private ClinicService service = new ClinicServiceImpl();

	@Mock
	private ClinicRepository repository;
	
	@Mock
	private CityEntity city;
	
	@Mock
	private ClinicTypeEntity clinicType;
	
	@DisplayName("ClinicServiceTest - Test findAll method")
	@Test
	void findAllTest() {

		// given
		List<ClinicEntity> expectedEntities = new ArrayList<ClinicEntity> ();
		
		expectedEntities.add(new ClinicEntity(1L, "Primera","Admin","email@server.com","Director", this.city,20,this.clinicType));
		expectedEntities.add(new ClinicEntity(2L, "Segunda","Admin","email@server.com","Director", this.city,20,this.clinicType));
		expectedEntities.add(new ClinicEntity(3L, "Tercera","Admin","email@server.com","Director", this.city,20,this.clinicType));

		doReturn(expectedEntities).when(repository).findAll();

		// when
		List<ClinicEntity> actualEntities = service.findAll();

		// then
		assertThat(actualEntities).isEqualTo(expectedEntities);

	}

	
	@DisplayName("ClinicServiceTest - Test findById method")
	@Test
	void findByIdTest() {
		// given
		
		final Long id = 2L;
		ClinicEntity entity = new ClinicEntity(2L, "Segunda","Admin","email@server.com","Director", this.city,20,this.clinicType);
		final Optional<ClinicEntity> expectedEntity = Optional.of(entity);

		doReturn(Optional.of(entity)).when(repository).findById(id);
		
		// when
		final Optional<ClinicEntity> actualdEntity = service.findById(id);

		// then
		assertThat(actualdEntity).isEqualTo(expectedEntity);

	}
	
	@DisplayName("ClinicServiceTest - Test update method")
	@Test
	void updateTest() {
		// given
		ClinicEntity entity = new ClinicEntity(2L, "Segunda","Admin","email@server.com","Director", this.city,20,this.clinicType);

		doReturn(entity).when(repository).save(entity);
		
		// when
		final ClinicEntity actualdEntity = service.saveOrUpdate(entity);

		// then
		
		assertThat(actualdEntity).isNotNull();
		verify(repository).save(entity);

	}	
	

	@DisplayName("ClinicServiceTest - Test delete method")
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
