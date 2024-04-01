package com.dosu04.srms.controllers.student;

import com.dosu04.srms.models.Dispute;
import com.dosu04.srms.models.Result;
import com.dosu04.srms.services.ResultService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentResultController {

    private final ResultService resultService;


    public StudentResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/results")
    public String getUserResults(Model model) {
        // Get authenticated user's username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Retrieve results for the authenticated user
        List<Result> userResults = resultService.getResultsByUsername(username);

        model.addAttribute("dispute", new Dispute()); // Add an empty dispute object to the model
        model.addAttribute("results", userResults);

        return "student/results"; // Assuming your template file is located at "student/results.html"
    }
}
