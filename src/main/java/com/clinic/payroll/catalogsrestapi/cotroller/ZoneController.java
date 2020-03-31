package com.clinic.payroll.catalogsrestapi.cotroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.payroll.catalogsrestapi.exception.ResourceNotFoundException;
import com.clinic.payroll.catalogsrestapi.model.converter.DtoToEntity;
import com.clinic.payroll.catalogsrestapi.model.converter.EntityToDto;
import com.clinic.payroll.catalogsrestapi.model.dto.ZoneDto;
import com.clinic.payroll.catalogsrestapi.model.entity.ZoneEntity;
import com.clinic.payroll.catalogsrestapi.service.ZoneService;

@RestController
@RequestMapping("/api/v1/catalogs/")
public class ZoneController {

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private ZoneService zoneService;

	@Autowired
	private EntityToDto<ZoneEntity, ZoneDto> entityConverter;

	@Autowired
	private DtoToEntity<ZoneDto, ZoneEntity> dtoConverter;

	@GetMapping("zones")
	@ResponseStatus(code = HttpStatus.OK)
	public List<ZoneDto> findAll() {
		return zoneService.findAll().stream().map(entity -> entityConverter.entityToDto(entity, modelMapper))
				.collect(Collectors.toList());
	}

	@GetMapping("zones/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ZoneDto findById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

		ZoneEntity entity = zoneService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		return entityConverter.entityToDto(entity, modelMapper);
	}

	@PostMapping("zones")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ZoneDto createZone(@RequestBody ZoneDto dto) {

		ZoneEntity paramEntity = dtoConverter.dtoToEntity(dto, modelMapper);

		return entityConverter.entityToDto(zoneService.saveOrUpdate(paramEntity), modelMapper);
	}

	@PutMapping("zones/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ZoneDto update(@PathVariable(value = "id") Long id, @Valid @RequestBody ZoneDto dto) throws ResourceNotFoundException {

		ZoneEntity entity = dtoConverter.dtoToEntity(dto, modelMapper);
		
		ZoneEntity paramEntity = zoneService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		paramEntity.setDescription(entity.getDescription());

		return entityConverter.entityToDto(zoneService.saveOrUpdate(paramEntity), modelMapper);

	}

	@DeleteMapping("zones/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		
		ZoneEntity paramEntity = zoneService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		zoneService.delete(paramEntity.getZoneId());
		
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		
		response.put("deleted", Boolean.TRUE);
		
		return response;
		
	}

}
