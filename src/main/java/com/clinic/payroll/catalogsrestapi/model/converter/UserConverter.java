package com.clinic.payroll.catalogsrestapi.model.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.clinic.payroll.catalogsrestapi.model.dto.UserDto;
import com.clinic.payroll.catalogsrestapi.model.entity.UserEntity;

@Component
public class UserConverter implements DtoToEntity<UserDto, UserEntity> , EntityToDto<UserEntity, UserDto>{

	@Override
	public UserEntity dtoToEntity(UserDto dto, ModelMapper modelMapper) {

		return modelMapper.map(dto, UserEntity.class);
	}

	@Override
	public UserDto entityToDto(UserEntity entity, ModelMapper modelMapper) {

		return modelMapper.map(entity, UserDto.class);
	}
	
}
