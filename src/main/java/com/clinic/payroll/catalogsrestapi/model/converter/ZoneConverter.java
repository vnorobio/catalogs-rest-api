package com.clinic.payroll.catalogsrestapi.model.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.clinic.payroll.catalogsrestapi.model.dto.ZoneDto;
import com.clinic.payroll.catalogsrestapi.model.entity.ZoneEntity;

@Component
public class ZoneConverter implements DtoToEntity<ZoneDto, ZoneEntity> , EntityToDto<ZoneEntity, ZoneDto>{

	@Override
	public ZoneEntity dtoToEntity(ZoneDto dto, ModelMapper modelMapper) {

		return modelMapper.map(dto, ZoneEntity.class);
	}

	@Override
	public ZoneDto entityToDto(ZoneEntity entity, ModelMapper modelMapper) {

		return modelMapper.map(entity, ZoneDto.class);
	}
	
}
