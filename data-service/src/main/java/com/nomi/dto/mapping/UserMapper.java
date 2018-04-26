package com.nomi.dto.mapping;

import com.nomi.dto.UserDto;
import com.nomi.model.User;
import com.nomi.model.UserCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserMapper {

    private final UserCourseMapper  coursesMapper;

    public UserDto toUserDto(User user) {

        Set<UserCourse> userCourses = user.getCourses();

        return UserDto.builder()
            .user(user.getIndentifier())
            .total(userCourses.size())
            .courses(coursesMapper.toUserCourseDtos(userCourses))
            .build();

    }


    @Autowired
    public UserMapper(UserCourseMapper coursesMapper) {
        this.coursesMapper = coursesMapper;
    }



}
