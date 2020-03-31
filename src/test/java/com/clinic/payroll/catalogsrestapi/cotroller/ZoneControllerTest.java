package com.clinic.payroll.catalogsrestapi.cotroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.clinic.payroll.catalogsrestapi.model.entity.ZoneEntity;
import com.clinic.payroll.catalogsrestapi.repository.CityRepository;
import com.clinic.payroll.catalogsrestapi.repository.ClinicRepository;
import com.clinic.payroll.catalogsrestapi.repository.ClinicTypeRepository;
import com.clinic.payroll.catalogsrestapi.repository.NephrologistBaseClinicRepository;
import com.clinic.payroll.catalogsrestapi.repository.NephrologistRepository;
import com.clinic.payroll.catalogsrestapi.repository.NephrologistTypeRepository;
import com.clinic.payroll.catalogsrestapi.repository.UserRepository;
import com.clinic.payroll.catalogsrestapi.service.ZoneService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = ZoneController.class)
@ContextConfiguration
public class ZoneControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ZoneService service;

	@MockBean
	private UserRepository user;

	@MockBean
	private CityRepository cityRepository;

	@MockBean
	private ClinicRepository clinicRepository;

	@MockBean
	private ClinicTypeRepository clinicTypeRepository;

	@MockBean
	private NephrologistRepository nephrologistRepository;

	@MockBean
	private NephrologistTypeRepository nephrologisTtRepository;

	@MockBean
	private NephrologistBaseClinicRepository nephrologistBaseClinicRepository;
	
	private String entityJson = "{\"zoneId\": 1 ,\"description\":\"Phantom Zone\"}";
	
	private String arrayEntityJson = "[{\"zoneId\": 1 ,\"description\":\"Phantom Zone\"}]";
	
	private ZoneEntity mockZone = new ZoneEntity(1L, "Phantom Zone");

	@Test
	@WithMockUser
	public void givenZones_whenGetZones_thenReturnJsonArray() throws Exception {

		List<ZoneEntity> allZones = Arrays.asList(mockZone);

		doReturn(allZones).when(service).findAll();

		mockMvc.perform(get("/api/v1/catalogs/zones")).andExpect(status().isOk()).andExpect(content()
				.json(arrayEntityJson));

	}

	@Test
	@WithMockUser
	public void givenZone_whenPostZone_thenCreated() throws Exception {

		doReturn(mockZone).when(service).saveOrUpdate(mockZone);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/catalogs/zones")
				.accept(MediaType.APPLICATION_JSON).content(entityJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

	}


	@Configuration
	@ComponentScan("com.clinic.payroll.catalogsrestapi")
	public static class SpringConfig {

	}

}
