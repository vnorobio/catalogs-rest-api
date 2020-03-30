package com.clinic.payroll.catalogsrestapi.service;

import java.util.List;
import java.util.Optional;

import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistBaseClinicEntity;

public interface NephrologistBaseClinicService {

	public List<NephrologistBaseClinicEntity> findAll();

	public Optional<NephrologistBaseClinicEntity> findById(Long id);

	public NephrologistBaseClinicEntity saveOrUpdate(NephrologistBaseClinicEntity entity);

	public void delete(Long id);

}
