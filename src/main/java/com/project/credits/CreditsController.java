package com.project.credits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CreditsController {

    @Autowired
    private CreditsRepository creditsRepository;

    @GetMapping("/users/credits/all")
    public String showAllCreditsList(Model model) {
        List<Credits> creditsList = creditsRepository.listAll();
        model.addAttribute("creditsList", creditsList);
        return "credits";
    }

    @GetMapping("/users/credits/{id}")
    public String showCreditsList(@PathVariable("id") Integer id, Model model) {
        List<Credits> creditsList = creditsRepository.findCreditsByUser_Id(id);
        model.addAttribute("creditsList", creditsList);
        model.addAttribute("message", "View user's credits");
        return "credits_user";
    }

    @GetMapping("/credits/new")
    public String showAddCreditForm(Model model) {
        model.addAttribute("credit", new Credits());
        model.addAttribute("pageTitle", "Add Credit");
        return "credits_form";
    }

    @PostMapping("/users/credits/save")
    public String addNewCredit(Credits credit, RedirectAttributes ra) {
        creditsRepository.save(credit);
        ra.addFlashAttribute("message", "The credit has been saved successfully");
        return "redirect:/users/credits/all";
    }
}
