package com.nomi.rest;

import com.nomi.adapter.DataServiceAdapter;
import com.nomi.dto.StudentDto;
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
@RequestMapping("/user")
public class StudentsController {

    private final DataServiceAdapter dataServiceAdapter;


    @ApiOperation(value = "Get user with courses")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Student's data found"),
        @ApiResponse(code = 404, message = "No data found in Data service"),
        @ApiResponse(code = 500, message = "Could not access Data service"),
        @ApiResponse(code = 503, message = "Data service is unavailable.")
    })
    @RequestMapping(value = "/{user-id}",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        method = RequestMethod.GET)
    public ResponseEntity<StudentDto> getData(@PathVariable(value = "user-id") String userIdentifier) {

       return dataServiceAdapter.getStudent(userIdentifier);
    }


    @Autowired
    public StudentsController(DataServiceAdapter dataServiceAdapter) {
        this.dataServiceAdapter = dataServiceAdapter;
    }
}
