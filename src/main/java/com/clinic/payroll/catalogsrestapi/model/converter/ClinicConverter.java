package com.clinic.payroll.catalogsrestapi.model.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.clinic.payroll.catalogsrestapi.model.dto.ClinicDto;
import com.clinic.payroll.catalogsrestapi.model.entity.ClinicEntity;

@Component
public class ClinicConverter implements DtoToEntity<ClinicDto, ClinicEntity> , EntityToDto<ClinicEntity, ClinicDto>{

	@Override
	public ClinicEntity dtoToEntity(ClinicDto dto, ModelMapper modelMapper) {

		return modelMapper.map(dto, ClinicEntity.class);
	}

	@Override
	public ClinicDto entityToDto(ClinicEntity entity, ModelMapper modelMapper) {

		return modelMapper.map(entity, ClinicDto.class);
	}
	
}
