package com.clinic.payroll.catalogsrestapi.service;

import java.util.List;
import java.util.Optional;

import com.clinic.payroll.catalogsrestapi.model.entity.ClinicTypeEntity;

public interface ClinicTypeService {

	public List<ClinicTypeEntity> findAll();

	public Optional<ClinicTypeEntity> findById(Long id);

	public ClinicTypeEntity saveOrUpdate(ClinicTypeEntity entity);

	public void delete(Long id);

}
