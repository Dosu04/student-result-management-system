package com.dosu04.srms.controllers.lecturer;

import com.dosu04.srms.models.Course;
import com.dosu04.srms.models.Result;
import com.dosu04.srms.models.User;
import com.dosu04.srms.services.CourseService;
import com.dosu04.srms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LecturerCourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;


    @GetMapping("/lecturer")
    public String lecturerDashboard(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Fetch courses assigned to the lecturer with the given username
        List<Course> courses = courseService.getCoursesByLecturerUsername(username);

        List<User> students = userService.getUsersByRole("student");
        model.addAttribute("students", students);
        model.addAttribute("result", new Result());
        model.addAttribute("courses", courses);
        return "lecturer/dashboard";
    }



}
