package com.clinic.payroll.catalogsrestapi.service;

import java.util.List;
import java.util.Optional;

import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistEntity;

public interface NephrologistService {

	public List<NephrologistEntity> findAll();

	public Optional<NephrologistEntity> findById(Long id);

	public NephrologistEntity saveOrUpdate(NephrologistEntity entity);

	public void delete(Long id);

}
