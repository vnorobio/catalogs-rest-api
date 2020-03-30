package com.clinic.payroll.catalogsrestapi.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clinic.payroll.catalogsrestapi.model.entity.UserEntity;
import com.clinic.payroll.catalogsrestapi.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByLogin(login)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + login));

		return UserDetailsImpl.build(user);
	}

}
