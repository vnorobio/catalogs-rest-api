package com.clinic.payroll.catalogsrestapi.model.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.clinic.payroll.catalogsrestapi.model.dto.ClinicTypeDto;
import com.clinic.payroll.catalogsrestapi.model.entity.ClinicTypeEntity;

@Component
public class ClinicTypeConverter implements DtoToEntity<ClinicTypeDto, ClinicTypeEntity> , EntityToDto<ClinicTypeEntity, ClinicTypeDto>{

	@Override
	public ClinicTypeEntity dtoToEntity(ClinicTypeDto dto, ModelMapper modelMapper) {

		return modelMapper.map(dto, ClinicTypeEntity.class);
	}

	@Override
	public ClinicTypeDto entityToDto(ClinicTypeEntity entity, ModelMapper modelMapper) {

		return modelMapper.map(entity, ClinicTypeDto.class);
	}
	
}
