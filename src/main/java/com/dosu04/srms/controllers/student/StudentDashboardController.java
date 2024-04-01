package com.dosu04.srms.controllers.student;

import com.dosu04.srms.models.User;
import jakarta.persistence.Column;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentDashboardController {

    @GetMapping("/")
    public String showDashboard(Model model, Authentication authentication) {
        try {
            User user = (User) authentication.getPrincipal();

            String fullName = user.getSurname() + " " + user.getName() + " " + user.getOtherName();

            model.addAttribute("fullName", fullName);
            model.addAttribute("username", user.getUsername());

            return "student/dashboard";
        } catch (Exception e) {
            return "error";
        }
    }

}
