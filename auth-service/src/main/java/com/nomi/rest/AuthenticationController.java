package com.nomi.rest;

import com.nomi.dto.CredentialsDto;
import com.nomi.service.AuthenticationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @ApiOperation(value = "Authenticate users")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "User authenticated"),
        @ApiResponse(code = 401, message = "User did not pass the authentication"),
        @ApiResponse(code = 403, message = "Forbidden to access Authentication Service"),
    })
    @RequestMapping(value = "/auth",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        method = RequestMethod.POST)
    public ResponseEntity<Void> auth(@RequestBody @Valid final CredentialsDto credentialsDto) {

        authenticationService.authenticate(credentialsDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
}
