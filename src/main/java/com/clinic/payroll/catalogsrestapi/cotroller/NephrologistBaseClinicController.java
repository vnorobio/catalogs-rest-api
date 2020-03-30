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
import com.clinic.payroll.catalogsrestapi.model.dto.NephrologistBaseClinicDto;
import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistBaseClinicEntity;
import com.clinic.payroll.catalogsrestapi.service.NephrologistBaseClinicService;

@RestController
@RequestMapping("/api/v1/catalogs/")
public class NephrologistBaseClinicController {

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private NephrologistBaseClinicService service;

	@Autowired
	private EntityToDto<NephrologistBaseClinicEntity, NephrologistBaseClinicDto> entityConverter;

	@Autowired
	private DtoToEntity<NephrologistBaseClinicDto, NephrologistBaseClinicEntity> dtoConverter;

	// GET List all zones
	@GetMapping("nephrologist-base-clinics")
	public List<NephrologistBaseClinicDto> findAll() {
		return service.findAll().stream().map(entity -> entityConverter.entityToDto(entity, modelMapper))
				.collect(Collectors.toList());
	}

	@GetMapping("nephrologist-base-clinics/{id}")
	public NephrologistBaseClinicDto findById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

		NephrologistBaseClinicEntity entity = service.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		return entityConverter.entityToDto(entity, modelMapper);
	}

	@PostMapping("nephrologist-base-clinics")
	public NephrologistBaseClinicDto createNephrologistBaseClinic(@RequestBody NephrologistBaseClinicDto dto) {

		NephrologistBaseClinicEntity paramEntity = dtoConverter.dtoToEntity(dto, modelMapper);

		return entityConverter.entityToDto(service.saveOrUpdate(paramEntity), modelMapper);
	}

	@PutMapping("nephrologist-base-clinics/{id}")
	public NephrologistBaseClinicDto update(@PathVariable(value = "id") Long id, @Valid @RequestBody NephrologistBaseClinicDto dto) throws ResourceNotFoundException {

		NephrologistBaseClinicEntity entity = dtoConverter.dtoToEntity(dto, modelMapper);
		
		NephrologistBaseClinicEntity paramEntity = service.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		paramEntity.setNephrologist(entity.getNephrologist());
		paramEntity.setClinic(entity.getClinic());
		paramEntity.setSalary(entity.getSalary());
		paramEntity.setDedicationHours(entity.getDedicationHours());

		return entityConverter.entityToDto(service.saveOrUpdate(paramEntity), modelMapper);

	}

	@DeleteMapping("nephrologist-base-clinics/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		
		NephrologistBaseClinicEntity paramEntity = service.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found resource for id :: " + id));

		service.delete(paramEntity.getBaseClinicId());
		
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		
		response.put("deleted", Boolean.TRUE);
		
		return response;
		
	}

}
