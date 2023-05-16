package com.project.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    @GetMapping("users/transactions/{id}")
    public String showTransactionsList(@PathVariable("id") Integer id, Model model) {
        List<Transaction> transactionList = transactionService.findByUserId(id);
        model.addAttribute("transactionList", transactionList);
        return "transactions";
    }

    @GetMapping("users/transactions/all")
    public String showAllTransactionsList(Model model) {
        List<Transaction> transactionList = transactionService.listAll();
        model.addAttribute("allTransactions", transactionList);
        return "transactions_all";
    }

    @GetMapping("users/transactions/new")
    public String showAddTransactionForm(Model model) {
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("pageTitle", "Add Transaction");
        return "transactions_form";
    }

    @PostMapping("users/transactions/save")
    public String addNewTransaction(Transaction transaction, RedirectAttributes ra) {
        transactionService.save(transaction);
        ra.addFlashAttribute("message", "The transaction has been saved successfully");
        return "redirect:/users/transactions/all";
    }

    @GetMapping("users/transactions/details/{id}")
    public String editTransactionDetails(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Transaction transaction = transactionService.get(id);
            model.addAttribute("transaction", transaction);
            model.addAttribute("pageTitle", "Details for transaction " + transaction.getId());
            return "transactions_form";
        } catch (TransactionNotFoundException e) {
            ra.addFlashAttribute("message", "Transaction not found");
            return "redirect:/transactions{id}";
        }
    }
}
