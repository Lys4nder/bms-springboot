package com.project.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AccountsController {
    @Autowired
    private AccountsService accountsService;

    @GetMapping("/accounts/all")
    public String showAccountsList(Model model) {
        List<Accounts> accountsList = accountsService.listAll();
        model.addAttribute("accountsList", accountsList);
        return "accounts";
    }

    @GetMapping("/accounts/new")
    public String showAccountsForm(Model model) {
        model.addAttribute("account", new Accounts());
        model.addAttribute("pageTitle", "Add new user");
        return "accounts_form";
    }

    @PostMapping("/accounts/save")
    public String saveAccount(Accounts account, RedirectAttributes ra) {
        accountsService.save(account);
        ra.addFlashAttribute("message", "The account has been saved successfully");
        return "redirect:/accounts";
    }
}
