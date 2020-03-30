package com.clinic.payroll.catalogsrestapi.service;

import java.util.List;
import java.util.Optional;

import com.clinic.payroll.catalogsrestapi.model.entity.CityEntity;

public interface CityService {

	public List<CityEntity> findAll();

	public Optional<CityEntity> findById(Long id);

	public CityEntity saveOrUpdate(CityEntity entity);

	public void delete(Long id);

}
