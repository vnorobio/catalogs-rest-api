package com.clinic.payroll.catalogsrestapi.model.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.clinic.payroll.catalogsrestapi.model.dto.NephrologistBaseClinicDto;
import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistBaseClinicEntity;

@Component
public class NephrologistBaseClinicConverter implements DtoToEntity<NephrologistBaseClinicDto, NephrologistBaseClinicEntity> , EntityToDto<NephrologistBaseClinicEntity, NephrologistBaseClinicDto>{

	@Override
	public NephrologistBaseClinicEntity dtoToEntity(NephrologistBaseClinicDto dto, ModelMapper modelMapper) {

		return modelMapper.map(dto, NephrologistBaseClinicEntity.class);
	}

	@Override
	public NephrologistBaseClinicDto entityToDto(NephrologistBaseClinicEntity entity, ModelMapper modelMapper) {

		return modelMapper.map(entity, NephrologistBaseClinicDto.class);
	}
	
}
