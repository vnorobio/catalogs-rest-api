package com.clinic.payroll.catalogsrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.payroll.catalogsrestapi.model.entity.NephrologistEntity;

@Repository
public interface NephrologistRepository extends JpaRepository<NephrologistEntity, Long> {

}
