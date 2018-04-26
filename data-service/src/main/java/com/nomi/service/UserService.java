package com.nomi.service;

import com.nomi.dto.UserDto;
import com.nomi.dto.mapping.UserMapper;
import com.nomi.exception.ResourceNotFoundException;
import com.nomi.model.User;
import com.nomi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserDto getUser(String userId) {

        Optional<User> userOptional = userRepository.findByIndentifier(userId);

        userOptional.orElseThrow( () ->  new ResourceNotFoundException());

        return userMapper.toUserDto(userOptional.get());

    }

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


}
