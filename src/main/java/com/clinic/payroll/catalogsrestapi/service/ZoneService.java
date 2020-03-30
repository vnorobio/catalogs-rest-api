package com.clinic.payroll.catalogsrestapi.service;

import java.util.List;
import java.util.Optional;

import com.clinic.payroll.catalogsrestapi.model.entity.ZoneEntity;

public interface ZoneService {

	public List<ZoneEntity> findAll();

	public Optional<ZoneEntity> findById(Long id);

	public ZoneEntity saveOrUpdate(ZoneEntity entity);

	public void delete(Long id);

}
