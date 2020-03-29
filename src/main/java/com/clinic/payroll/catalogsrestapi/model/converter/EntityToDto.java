package com.clinic.payroll.catalogsrestapi.model.converter;

import org.modelmapper.ModelMapper;

@FunctionalInterface
public interface EntityToDto<K,V>{
	
	public V entityToDto(K entity, ModelMapper modelMapper);  
}
