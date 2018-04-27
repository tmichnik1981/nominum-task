package com.nomi.rest;

import com.nomi.adapter.AuthenticationServiceAdapter;
import com.nomi.dto.CredentialsDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    private final AuthenticationServiceAdapter authenticationServiceAdapter;

    @ApiOperation(value = "Sign-in")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful login"),
        @ApiResponse(code = 401, message = "User did not pass the authentication"),
        @ApiResponse(code = 500, message = "Could not access Authentication Service"),
        @ApiResponse(code = 503, message = "Authentication service is unavailable")
    })

    @RequestMapping(value = "/login",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        method = RequestMethod.POST)
    public ResponseEntity<Void> auth(@RequestBody @Valid final CredentialsDto credentialsDto) {

      /*  Adds X-CSRF-TOKEN header to response with generated CSRF token in case of successful
        authentication.*/

        authenticationServiceAdapter.authenticate(credentialsDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @ApiOperation(value = "Sign-out")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful logout")
    })

    @RequestMapping(value = "/logout",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        method = RequestMethod.POST)
    public ResponseEntity<Void> auth() {

        /*Closes session in case if CSRF token matches*/

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public AuthenticationController(AuthenticationServiceAdapter authenticationServiceAdapter) {
        this.authenticationServiceAdapter = authenticationServiceAdapter;
    }
}
