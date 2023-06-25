package com.project;

import com.project.credits.Credits;
import com.project.credits.CreditsRepository;
import com.project.transactions.Transaction;
import com.project.transactions.TransactionRepository;
import com.project.user.User;
import com.project.user.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class DashboardController {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    private final CreditsRepository creditsRepository;


    public DashboardController(UserRepository userRepository, TransactionRepository transactionRepository, CreditsRepository creditsRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
        this.creditsRepository = creditsRepository;
    }

    @GetMapping("/dashboard/all")
    public String showBankStats(Model model) {
        List<User> users = (List<User>) userRepository.findAll();
        List<Transaction> transactions = transactionRepository.findFirst10ByOrderByDateDesc();
        List<Credits> credits = creditsRepository.listAll();
        model.addAttribute("users", users);
        model.addAttribute("transactions", transactions);
        model.addAttribute("credits", credits);

        return "dashboard";
    }


    @GetMapping("/dashboard/{id}")
    public String showUserStats(@PathVariable("id") Integer id, Model model) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Transaction> transactions = transactionRepository.findByUserId(id);
            List<Credits> credits = creditsRepository.findCreditsByUser_Id(id);

            model.addAttribute("user", user);
            model.addAttribute("transactions", transactions);
            model.addAttribute("credits", credits);

            return "user_stats";
        } else {
            return "user_not_found";
        }
    }
}
