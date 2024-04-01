package com.dosu04.srms.controllers.student;

import com.dosu04.srms.models.Dispute;
import com.dosu04.srms.services.DisputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/disputes")
public class StudentDisputeController {

    private final DisputeService disputeService;

    @Autowired
    public StudentDisputeController(DisputeService disputeService) {
        this.disputeService = disputeService;
    }

//    @GetMapping("")
//    public String getAllDisputes(Model model) {
//        model.addAttribute("disputes", disputeService.getAllDisputes());
//        return "disputes";
//    }

//    @GetMapping("/{id}")
//    public String getDisputeById(@PathVariable Long id, Model model) {
//        disputeService.getDisputeById(id).ifPresent(dispute -> model.addAttribute("dispute", dispute));
//        return "dispute";
//    }

    @PostMapping("/create-dispute")
    public String createDispute(@ModelAttribute Dispute dispute) {
        disputeService.saveDispute(dispute);
        return "redirect:/disputes";
    }


//    @PostMapping("/delete/{id}")
//    public String deleteDispute(@PathVariable Long id) {
//        disputeService.deleteDispute(id);
//        return "redirect:/admin/disputes";
//    }


}
