package com.dosu04.srms.controllers.lecturer;

import com.dosu04.srms.models.Result;
import com.dosu04.srms.services.ResultService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class LecturerResultController {

    private final ResultService resultService;

    public LecturerResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping("/lecturer/upload-result")
    public String uploadResult(@ModelAttribute("result") Result result) {
        resultService.save(result); // Save the result to the database
        return "redirect:/lecturer"; // Redirect to the dashboard after processing
    }

}
