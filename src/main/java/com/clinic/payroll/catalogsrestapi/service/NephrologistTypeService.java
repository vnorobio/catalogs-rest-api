package com.clinic.payroll.catalogsrestapi.service;

import java.util.List;
import java.util.Optional;

import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistTypeEntity;

public interface NephrologistTypeService {

	public List<NephrologistTypeEntity> findAll();

	public Optional<NephrologistTypeEntity> findById(Long id);

	public NephrologistTypeEntity saveOrUpdate(NephrologistTypeEntity entity);

	public void delete(Long id);

}
