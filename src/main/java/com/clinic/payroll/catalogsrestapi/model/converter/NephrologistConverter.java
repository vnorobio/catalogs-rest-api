package com.clinic.payroll.catalogsrestapi.model.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.clinic.payroll.catalogsrestapi.model.dto.NephrologistDto;
import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistEntity;

@Component
public class NephrologistConverter implements DtoToEntity<NephrologistDto, NephrologistEntity> , EntityToDto<NephrologistEntity, NephrologistDto>{

	@Override
	public NephrologistEntity dtoToEntity(NephrologistDto dto, ModelMapper modelMapper) {

		return modelMapper.map(dto, NephrologistEntity.class);
	}

	@Override
	public NephrologistDto entityToDto(NephrologistEntity entity, ModelMapper modelMapper) {

		return modelMapper.map(entity, NephrologistDto.class);
	}
	
}
