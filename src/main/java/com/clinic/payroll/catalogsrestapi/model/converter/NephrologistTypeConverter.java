package com.clinic.payroll.catalogsrestapi.model.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.clinic.payroll.catalogsrestapi.model.dto.NephrologistTypeDto;
import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistTypeEntity;

@Component
public class NephrologistTypeConverter implements DtoToEntity<NephrologistTypeDto, NephrologistTypeEntity> , EntityToDto<NephrologistTypeEntity, NephrologistTypeDto>{

	@Override
	public NephrologistTypeEntity dtoToEntity(NephrologistTypeDto dto, ModelMapper modelMapper) {

		return modelMapper.map(dto, NephrologistTypeEntity.class);
	}

	@Override
	public NephrologistTypeDto entityToDto(NephrologistTypeEntity entity, ModelMapper modelMapper) {

		return modelMapper.map(entity, NephrologistTypeDto.class);
	}
	
}
