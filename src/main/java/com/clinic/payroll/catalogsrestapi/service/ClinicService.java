package com.clinic.payroll.catalogsrestapi.service;

import java.util.List;
import java.util.Optional;

import com.clinic.payroll.catalogsrestapi.model.entity.ClinicEntity;

public interface ClinicService {

	public List<ClinicEntity> findAll();

	public Optional<ClinicEntity> findById(Long id);

	public ClinicEntity saveOrUpdate(ClinicEntity entity);

	public void delete(Long id);

}
