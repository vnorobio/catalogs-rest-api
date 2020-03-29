package com.clinic.payroll.catalogsrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.payroll.catalogsrestapi.model.entity.ClinicTypeEntity;

@Repository
public interface ClinicTypeRepository extends JpaRepository<ClinicTypeEntity, Long> {

}
