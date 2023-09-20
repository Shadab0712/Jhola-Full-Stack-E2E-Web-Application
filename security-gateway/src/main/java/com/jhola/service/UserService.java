package com.jhola.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhola.dto.UserDTO;
import com.jhola.model.User;
import com.jhola.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public boolean registerUser(UserDTO userDTO) {
		User userEntity = modelMapper.map(userDTO, User.class);
		repository.save(userEntity);
		return true;
	}

}
