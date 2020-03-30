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
import com.clinic.payroll.catalogsrestapi.model.dto.NephrologistDto;
import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistEntity;
import com.clinic.payroll.catalogsrestapi.service.NephrologistService;

@RestController
@RequestMapping("/api/v1/catalogs/")
public class NephrologistController {

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private NephrologistService nephrologistService;

	@Autowired
	private EntityToDto<NephrologistEntity, NephrologistDto> entityConverter;

	@Autowired
	private DtoToEntity<NephrologistDto, NephrologistEntity> dtoConverter;

	@GetMapping("nephrologists")
	public List<NephrologistDto> findAll() {
		return nephrologistService.findAll().stream().map(entity -> entityConverter.entityToDto(entity, modelMapper))
				.collect(Collectors.toList());
	}

	@GetMapping("nephrologists/{id}")
	public NephrologistDto findById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

		NephrologistEntity entity = nephrologistService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		return entityConverter.entityToDto(entity, modelMapper);
	}

	@PostMapping("nephrologists")
	public NephrologistDto createNephrologist(@RequestBody NephrologistDto dto) {

		NephrologistEntity paramEntity = dtoConverter.dtoToEntity(dto, modelMapper);

		return entityConverter.entityToDto(nephrologistService.saveOrUpdate(paramEntity), modelMapper);
	}

	@PutMapping("nephrologists/{id}")
	public NephrologistDto update(@PathVariable(value = "id") Long id, @Valid @RequestBody NephrologistDto dto) throws ResourceNotFoundException {

		NephrologistEntity entity = dtoConverter.dtoToEntity(dto, modelMapper);
		
		NephrologistEntity paramEntity = nephrologistService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		paramEntity.setName(entity.getName());
		paramEntity.setNephrologistType(entity.getNephrologistType());
		paramEntity.setEmail(entity.getEmail());
		paramEntity.setActive(entity.getActive());

		return entityConverter.entityToDto(nephrologistService.saveOrUpdate(paramEntity), modelMapper);

	}

	@DeleteMapping("nephrologists/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		
		NephrologistEntity paramEntity = nephrologistService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		nephrologistService.delete(paramEntity.getNephrologistId());
		
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		
		response.put("deleted", Boolean.TRUE);
		
		return response;
		
	}

}
