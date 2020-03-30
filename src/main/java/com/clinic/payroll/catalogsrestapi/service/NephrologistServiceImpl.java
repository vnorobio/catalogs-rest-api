package com.clinic.payroll.catalogsrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistEntity;
import com.clinic.payroll.catalogsrestapi.repository.NephrologistRepository;

@Service
public class NephrologistServiceImpl implements NephrologistService {
	
	@Autowired
	NephrologistRepository repository;

	@Override
	public List<NephrologistEntity> findAll() {

		return repository.findAll();
	}

	@Override
	public Optional<NephrologistEntity> findById(Long id){
		
		return repository.findById(id);
	}

	@Override
	public NephrologistEntity saveOrUpdate(NephrologistEntity entity) {

		return repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		
		repository.deleteById(id);
	}

}
