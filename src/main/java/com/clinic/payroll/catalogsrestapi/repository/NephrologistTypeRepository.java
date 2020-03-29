package com.clinic.payroll.catalogsrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistTypeEntity;

@Repository
public interface NephrologistTypeRepository extends JpaRepository<NephrologistTypeEntity, Long> {

}
