package com.nomi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomi.dto.UserDto;
import com.nomi.model.User;
import com.nomi.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;

	public UserDto getUser(Long userId) {

		Optional<User> user = userRepository.findById(1l);


		UserDto userDto = new UserDto();
		userDto.setTotal(12);
		userDto.setUser(2);
		
		//TODO: add mapping to DTO
		return userDto;
	}

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	
	

}
