package com.nomi.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserDto {

    private String user;
    private Integer total;
    private Set<UserCourseDto> courses ;


}
