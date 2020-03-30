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
import com.clinic.payroll.catalogsrestapi.model.dto.NephrologistTypeDto;
import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistTypeEntity;
import com.clinic.payroll.catalogsrestapi.service.NephrologistTypeService;

@RestController
@RequestMapping("/api/v1/catalogs/")
public class NephrologistTypeController {

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private NephrologistTypeService service;

	@Autowired
	private EntityToDto<NephrologistTypeEntity, NephrologistTypeDto> entityConverter;

	@Autowired
	private DtoToEntity<NephrologistTypeDto, NephrologistTypeEntity> dtoConverter;

	@GetMapping("nephrologist-types")
	public List<NephrologistTypeDto> findAll() {
		return service.findAll().stream().map(entity -> entityConverter.entityToDto(entity, modelMapper))
				.collect(Collectors.toList());
	}

	@GetMapping("nephrologist-types/{id}")
	public NephrologistTypeDto findById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

		NephrologistTypeEntity entity = service.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		return entityConverter.entityToDto(entity, modelMapper);
	}

	@PostMapping("nephrologist-types")
	public NephrologistTypeDto createNephrologistType(@RequestBody NephrologistTypeDto dto) {

		NephrologistTypeEntity paramEntity = dtoConverter.dtoToEntity(dto, modelMapper);

		return entityConverter.entityToDto(service.saveOrUpdate(paramEntity), modelMapper);
	}

	@PutMapping("nephrologist-types/{id}")
	public NephrologistTypeDto update(@PathVariable(value = "id") Long id, @Valid @RequestBody NephrologistTypeDto dto) throws ResourceNotFoundException {

		NephrologistTypeEntity entity = dtoConverter.dtoToEntity(dto, modelMapper);
		
		NephrologistTypeEntity paramEntity = service.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		paramEntity.setDescription(entity.getDescription());

		return entityConverter.entityToDto(service.saveOrUpdate(paramEntity), modelMapper);

	}

	@DeleteMapping("nephrologist-types/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		
		NephrologistTypeEntity paramEntity = service.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		service.delete(paramEntity.getNephrologistTypeId());
		
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		
		response.put("deleted", Boolean.TRUE);
		
		return response;
		
	}

}
