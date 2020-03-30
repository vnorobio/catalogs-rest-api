package com.clinic.payroll.catalogsrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.payroll.catalogsrestapi.model.entity.ZoneEntity;
import com.clinic.payroll.catalogsrestapi.repository.ZoneRepository;

@Service
public class ZoneServiceImpl implements ZoneService {
	
	@Autowired
	ZoneRepository repository;

	@Override
	public List<ZoneEntity> findAll() {

		return repository.findAll();
	}

	@Override
	public Optional<ZoneEntity> findById(Long id){
		
		return repository.findById(id);
	}

	@Override
	public ZoneEntity saveOrUpdate(ZoneEntity entity) {

		return repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		
		repository.deleteById(id);
	}

}
