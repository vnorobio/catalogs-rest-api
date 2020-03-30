package com.clinic.payroll.catalogsrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.payroll.catalogsrestapi.model.entity.CityEntity;
import com.clinic.payroll.catalogsrestapi.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	CityRepository repository;

	@Override
	public List<CityEntity> findAll() {

		return repository.findAll();
	}

	@Override
	public Optional<CityEntity> findById(Long id){
		
		return repository.findById(id);
	}

	@Override
	public CityEntity saveOrUpdate(CityEntity entity) {

		return repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
