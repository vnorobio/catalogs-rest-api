package com.clinic.payroll.catalogsrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistBaseClinicEntity;
import com.clinic.payroll.catalogsrestapi.repository.NephrologistBaseClinicRepository;

@Service
public class NephrologistBaseClinicServiceImpl implements NephrologistBaseClinicService {
	
	@Autowired
	NephrologistBaseClinicRepository repository;

	@Override
	public List<NephrologistBaseClinicEntity> findAll() {

		return repository.findAll();
	}

	@Override
	public Optional<NephrologistBaseClinicEntity> findById(Long id){
		
		return repository.findById(id);
	}

	@Override
	public NephrologistBaseClinicEntity saveOrUpdate(NephrologistBaseClinicEntity entity) {

		return repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
