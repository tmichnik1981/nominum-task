package com.nomi.rest;

import com.nomi.dto.UserDto;
import com.nomi.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Get user with courses")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "User was found"),
        @ApiResponse(code = 403, message = "Not authenticated"),
        @ApiResponse(code = 404, message = "User does not exist"),
    })
    @RequestMapping(value = "/{user-id}",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        method = RequestMethod.GET)
    public ResponseEntity<UserDto> getData(@PathVariable(value = "user-id",required = true) String userIdentifier) {

        UserDto userDto = userService.getUser(userIdentifier);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }


    @Autowired
    public DataController(UserService userService) {
        this.userService = userService;
    }

}
