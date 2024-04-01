package com.dosu04.srms.services;

import com.dosu04.srms.models.Course;
import com.dosu04.srms.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCoursesByLecturerUsername(String username) {
        return courseRepository.findByLecturerUsername(username);
    }
}
