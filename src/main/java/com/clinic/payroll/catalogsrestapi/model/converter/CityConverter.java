package com.clinic.payroll.catalogsrestapi.model.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.clinic.payroll.catalogsrestapi.model.dto.CityDto;
import com.clinic.payroll.catalogsrestapi.model.entity.CityEntity;

@Component
public class CityConverter implements DtoToEntity<CityDto, CityEntity> , EntityToDto<CityEntity, CityDto>{

	@Override
	public CityEntity dtoToEntity(CityDto dto, ModelMapper modelMapper) {

		return modelMapper.map(dto, CityEntity.class);
	}

	@Override
	public CityDto entityToDto(CityEntity entity, ModelMapper modelMapper) {

		return modelMapper.map(entity, CityDto.class);
	}
	
}
