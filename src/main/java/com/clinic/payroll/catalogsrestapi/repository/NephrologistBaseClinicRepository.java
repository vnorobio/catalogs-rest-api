package com.clinic.payroll.catalogsrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistBaseClinicEntity;

@Repository
public interface NephrologistBaseClinicRepository extends JpaRepository<NephrologistBaseClinicEntity, Long> {

}
