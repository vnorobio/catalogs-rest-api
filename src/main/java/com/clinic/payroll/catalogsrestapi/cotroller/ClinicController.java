package com.clinic.payroll.catalogsrestapi.cotroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.payroll.catalogsrestapi.exception.ResourceNotFoundException;
import com.clinic.payroll.catalogsrestapi.model.converter.DtoToEntity;
import com.clinic.payroll.catalogsrestapi.model.converter.EntityToDto;
import com.clinic.payroll.catalogsrestapi.model.dto.ClinicDto;
import com.clinic.payroll.catalogsrestapi.model.entity.ClinicEntity;
import com.clinic.payroll.catalogsrestapi.service.ClinicService;

@RestController
@RequestMapping("/api/v1/catalogs/")
public class ClinicController {

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private ClinicService service;

	@Autowired
	private EntityToDto<ClinicEntity, ClinicDto> entityConverter;

	@Autowired
	private DtoToEntity<ClinicDto, ClinicEntity> dtoConverter;

	// GET List all zones
	@GetMapping("clinics")
	public List<ClinicDto> findAll() {
		return service.findAll().stream().map(entity -> entityConverter.entityToDto(entity, modelMapper))
				.collect(Collectors.toList());
	}

	@GetMapping("clinics/{id}")
	public ClinicDto findById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

		ClinicEntity entity = service.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		return entityConverter.entityToDto(entity, modelMapper);
	}

	@PostMapping("clinics")
	public ClinicDto createClinic(@RequestBody ClinicDto dto) {

		ClinicEntity paramEntity = dtoConverter.dtoToEntity(dto, modelMapper);

		return entityConverter.entityToDto(service.saveOrUpdate(paramEntity), modelMapper);
	}

	@PutMapping("clinics/{id}")
	public ClinicDto update(@PathVariable(value = "id") Long id, @Valid @RequestBody ClinicDto dto) throws ResourceNotFoundException {

		ClinicEntity entity = dtoConverter.dtoToEntity(dto, modelMapper);
		
		ClinicEntity paramEntity = service.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		paramEntity.setName(entity.getName());
		paramEntity.setAdministrator(entity.getAdministrator());
		paramEntity.setEmail(entity.getEmail());
		paramEntity.setDirector(entity.getDirector());
		paramEntity.setCity(entity.getCity());
		paramEntity.setCapacity(entity.getCapacity());
		paramEntity.setClinicType(entity.getClinicType());
		
		return entityConverter.entityToDto(service.saveOrUpdate(paramEntity), modelMapper);

	}

	@DeleteMapping("clinics/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		
		ClinicEntity paramEntity = service.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		service.delete(paramEntity.getClinicId());
		
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		
		response.put("deleted", Boolean.TRUE);
		
		return response;
		
	}

}
