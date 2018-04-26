package com.nomi.controllers;

import com.nomi.dto.UserDto;
import com.nomi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

    private final UserService userService;

    @RequestMapping(value = "/{userId}",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        method = RequestMethod.GET)
    public ResponseEntity<UserDto> getData(@PathVariable("userId") Long userId) {

        UserDto userDto = userService.getUser(userId);

        return new ResponseEntity<>(userDto, HttpStatus.OK);


    }


    @Autowired
    public DataController(UserService userService) {
        this.userService = userService;
    }

}
