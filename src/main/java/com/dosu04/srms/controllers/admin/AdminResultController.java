package com.dosu04.srms.controllers.admin;

import com.dosu04.srms.models.Result;
import com.dosu04.srms.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminResultController {

    private final ResultService resultService;

    @Autowired
    public AdminResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/admin/results")
    public String viewAllResults(Model model) {
        model.addAttribute("results", resultService.getAllResults());
        return "admin/results";
    }


    @PostMapping("/admin/results/update/{id}")
    public String updateResult(@PathVariable Long id, @ModelAttribute("result") Result updatedResult, Model model) {
        Result existingResult = resultService.findResultById(id).orElse(null);

        if (existingResult != null) {
            // Update score and grade
            existingResult.setScore(updatedResult.getScore());
            existingResult.setGrade(updatedResult.getGrade());

            // Save the updated result
            resultService.save(existingResult);

            model.addAttribute("successMessage", "Result updated successfully.");
        } else {
            model.addAttribute("errorMessage", "Result not found.");
        }

        return "redirect:/admin/results"; // Redirect to the results page
    }

//    @PostMapping("/update/{id}")
//    public String updateResult(@PathVariable Long id, @RequestParam int score, @RequestParam String grade) {
//        Result result = resultService.findResultById(id).orElse(null);
//        if (result != null) {
//            result.setScore(score);
//            result.setGrade(grade);
//            resultService.save(result);
//            return "redirect:/admin/results"; // Redirect to the result list page
//        } else {
//            // Handle case where result with given ID is not found
//            return "error"; // You can return an error page or handle it differently
//        }
//    }



}
