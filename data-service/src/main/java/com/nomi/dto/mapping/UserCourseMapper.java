package com.nomi.dto.mapping;

import com.nomi.dto.UserCourseDto;
import com.nomi.model.UserCourse;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserCourseMapper {


    public UserCourseDto toUserCourseDto(UserCourse userCourse) {
        return UserCourseDto.builder()
            .grade(userCourse.getGrade())
            .name(userCourse.getCourse().getName())
            .build();
    }


    public Set<UserCourseDto> toUserCourseDtos(Set<UserCourse> userCourses) {

        return userCourses.stream().map(this::toUserCourseDto).collect(Collectors.toSet());


    }
}
