package com.dosu04.srms.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {
    @RequestMapping("")
    public String viewDashboard() {
        return "admin/dashboard";
    }
}
