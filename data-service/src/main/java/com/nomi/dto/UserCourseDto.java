package com.nomi.dto;

import com.nomi.model.Grade;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCourseDto {
    private String name;
    private Grade grade;

}
