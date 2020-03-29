package com.clinic.payroll.catalogsrestapi.model.converter;

import org.modelmapper.ModelMapper;

@FunctionalInterface
public interface DtoToEntity<K,V>{
	
	public V dtoToEntity(K dto, ModelMapper modelMapper);  
}
