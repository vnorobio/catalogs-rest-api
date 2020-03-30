package com.clinic.payroll.catalogsrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.payroll.catalogsrestapi.model.entity.ClinicTypeEntity;
import com.clinic.payroll.catalogsrestapi.repository.ClinicTypeRepository;

@Service
public class ClinicTypeServiceImpl implements ClinicTypeService {
	
	@Autowired
	ClinicTypeRepository repository;

	@Override
	public List<ClinicTypeEntity> findAll() {

		return repository.findAll();
	}

	@Override
	public Optional<ClinicTypeEntity> findById(Long id){
		
		return repository.findById(id);
	}

	@Override
	public ClinicTypeEntity saveOrUpdate(ClinicTypeEntity entity) {

		return repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
