package com.clinic.payroll.catalogsrestapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.payroll.catalogsrestapi.model.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	public Optional<UserEntity> findByLogin(String login);
	
	public Boolean existsByLogin(String login);

	public Boolean existsByEmail(String email);

}
