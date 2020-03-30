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
import com.clinic.payroll.catalogsrestapi.model.dto.ClinicTypeDto;
import com.clinic.payroll.catalogsrestapi.model.entity.ClinicTypeEntity;
import com.clinic.payroll.catalogsrestapi.service.ClinicTypeService;

@RestController
@RequestMapping("/api/v1/catalogs/")
public class ClinicTypeController {

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private ClinicTypeService service;

	@Autowired
	private EntityToDto<ClinicTypeEntity, ClinicTypeDto> entityConverter;

	@Autowired
	private DtoToEntity<ClinicTypeDto, ClinicTypeEntity> dtoConverter;

	// GET List all zones
	@GetMapping("clinic-types")
	public List<ClinicTypeDto> findAll() {
		return service.findAll().stream().map(entity -> entityConverter.entityToDto(entity, modelMapper))
				.collect(Collectors.toList());
	}

	@GetMapping("clinic-types/{id}")
	public ClinicTypeDto findById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

		ClinicTypeEntity entity = service.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		return entityConverter.entityToDto(entity, modelMapper);
	}

	@PostMapping("clinic-types")
	public ClinicTypeDto createClinicType(@RequestBody ClinicTypeDto dto) {

		ClinicTypeEntity paramEntity = dtoConverter.dtoToEntity(dto, modelMapper);

		return entityConverter.entityToDto(service.saveOrUpdate(paramEntity), modelMapper);
	}

	@PutMapping("clinic-types/{id}")
	public ClinicTypeDto update(@PathVariable(value = "id") Long id, @Valid @RequestBody ClinicTypeDto dto) throws ResourceNotFoundException {

		ClinicTypeEntity entity = dtoConverter.dtoToEntity(dto, modelMapper);
		
		ClinicTypeEntity paramEntity = service.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		paramEntity.setDescription(entity.getDescription());

		return entityConverter.entityToDto(service.saveOrUpdate(paramEntity), modelMapper);

	}

	@DeleteMapping("clinic-types/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		
		ClinicTypeEntity paramEntity = service.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		service.delete(paramEntity.getClinicTypeId());
		
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		
		response.put("deleted", Boolean.TRUE);
		
		return response;
		
	}

}
