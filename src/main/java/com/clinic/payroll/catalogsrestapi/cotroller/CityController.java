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
import com.clinic.payroll.catalogsrestapi.model.dto.CityDto;
import com.clinic.payroll.catalogsrestapi.model.entity.CityEntity;
import com.clinic.payroll.catalogsrestapi.service.CityService;

@RestController
@RequestMapping("/api/v1/catalogs/")
public class CityController {

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private CityService service;

	@Autowired
	private EntityToDto<CityEntity, CityDto> entityConverter;

	@Autowired
	private DtoToEntity<CityDto, CityEntity> dtoConverter;

	// GET List all zones
	@GetMapping("cities")
	public List<CityDto> findAll() {
		return service.findAll().stream().map(entity -> entityConverter.entityToDto(entity, modelMapper))
				.collect(Collectors.toList());
	}

	@GetMapping("cities/{id}")
	public CityDto findById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

		CityEntity entity = service.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		return entityConverter.entityToDto(entity, modelMapper);
	}

	@PostMapping("cities")
	public CityDto createCity(@RequestBody CityDto dto) {

		CityEntity paramEntity = dtoConverter.dtoToEntity(dto, modelMapper);

		return entityConverter.entityToDto(service.saveOrUpdate(paramEntity), modelMapper);
	}

	@PutMapping("cities/{id}")
	public CityDto update(@PathVariable(value = "id") Long id, @Valid @RequestBody CityDto dto) throws ResourceNotFoundException {

		CityEntity entity = dtoConverter.dtoToEntity(dto, modelMapper);
		
		CityEntity paramEntity = service.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		paramEntity.setDescription(entity.getDescription());

		return entityConverter.entityToDto(service.saveOrUpdate(paramEntity), modelMapper);

	}

	@DeleteMapping("cities/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		
		CityEntity paramEntity = service.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		service.delete(paramEntity.getCityId());
		
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		
		response.put("deleted", Boolean.TRUE);
		
		return response;
		
	}

}
