package com.clinic.payroll.catalogsrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistTypeEntity;
import com.clinic.payroll.catalogsrestapi.repository.NephrologistTypeRepository;

@Service
public class NephrologistTypeServiceImpl implements NephrologistTypeService {
	
	@Autowired
	NephrologistTypeRepository repository;

	@Override
	public List<NephrologistTypeEntity> findAll() {

		return repository.findAll();
	}

	@Override
	public Optional<NephrologistTypeEntity> findById(Long id){
		
		return repository.findById(id);
	}

	@Override
	public NephrologistTypeEntity saveOrUpdate(NephrologistTypeEntity entity) {

		return repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
