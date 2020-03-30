package com.clinic.payroll.catalogsrestapi.cotroller;


import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.payroll.catalogsrestapi.model.converter.DtoToEntity;
import com.clinic.payroll.catalogsrestapi.model.converter.EntityToDto;
import com.clinic.payroll.catalogsrestapi.model.dto.MessageResponseDto;
import com.clinic.payroll.catalogsrestapi.model.dto.UserDto;
import com.clinic.payroll.catalogsrestapi.model.entity.UserEntity;
import com.clinic.payroll.catalogsrestapi.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
@Validated
public class AuthController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private EntityToDto<UserEntity, UserDto> entityConverter;

	@Autowired
	private DtoToEntity<UserDto, UserEntity> dtoConverter;

	private ModelMapper modelMapper = new ModelMapper();

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserDto userDto) {
		
		UserEntity paramEntity = dtoConverter.dtoToEntity(userDto, modelMapper);
		paramEntity.setPassword(encoder.encode(paramEntity.getPassword()));
		
		if (userRepository.findByLogin(paramEntity.getLogin()).isPresent()) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponseDto("Error: Login is already taken!"));
		}

		if (userRepository.existsByEmail(paramEntity.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponseDto( "Error: Email is already in use!"));
		}

		userRepository.save(paramEntity);
		
		return ResponseEntity.ok(new MessageResponseDto("User registered successfully!"));
	}
}
