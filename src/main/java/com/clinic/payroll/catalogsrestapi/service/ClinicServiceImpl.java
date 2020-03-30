package com.clinic.payroll.catalogsrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.payroll.catalogsrestapi.model.entity.ClinicEntity;
import com.clinic.payroll.catalogsrestapi.repository.ClinicRepository;

@Service
public class ClinicServiceImpl implements ClinicService {
	
	@Autowired
	ClinicRepository repository;

	@Override
	public List<ClinicEntity> findAll() {

		return repository.findAll();
	}

	@Override
	public Optional<ClinicEntity> findById(Long id){
		
		return repository.findById(id);
	}

	@Override
	public ClinicEntity saveOrUpdate(ClinicEntity entity) {

		return repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
