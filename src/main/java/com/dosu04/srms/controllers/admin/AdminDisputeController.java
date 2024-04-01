package com.dosu04.srms.controllers.admin;

import com.dosu04.srms.services.DisputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/disputes")
public class AdminDisputeController {

    private final DisputeService disputeService;

    @Autowired
    public AdminDisputeController(DisputeService disputeService) {
        this.disputeService = disputeService;
    }

    @GetMapping("")
    public String getAllDisputes(Model model) {
        model.addAttribute("disputes", disputeService.getAllDisputes());
        return "admin/disputes";
    }

//    @GetMapping("/{id}")
//    public String getDisputeById(@PathVariable Long id, Model model) {
//        disputeService.getDisputeById(id).ifPresent(dispute -> model.addAttribute("dispute", dispute));
//        return "dispute";
//    }

//    @PostMapping("/create")
//    public String createDispute(@ModelAttribute Dispute dispute) {
//        disputeService.saveDispute(dispute);
//        return "redirect:/admin/disputes";
//    }


    @PostMapping("/delete/{id}")
    public String deleteDispute(@PathVariable Long id) {
        disputeService.deleteDispute(id);
        return "redirect:/admin/disputes";
    }


}