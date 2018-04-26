package com.nomi.service;

import java.util.Optional;
import java.util.Set;

import com.nomi.model.UserCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomi.dto.UserDto;
import com.nomi.model.User;
import com.nomi.repository.UserRepository;

import javax.transaction.Transactional;

@Service
public class UserService {
	
	private final UserRepository userRepository;

	@Transactional
	public UserDto getUser(Long userId) {

		User user = userRepository.findById(2l).get();
		Set<UserCourse> userCourses =  user.getCourses();

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
