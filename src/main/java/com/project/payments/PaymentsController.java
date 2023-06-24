package com.project.payments;


import com.project.credits.Credits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PaymentsController {

    @Autowired
    PaymentsService paymentsService;

    @GetMapping("users/payments/all")
    public String showAllPayments(Model model) {
        List<Payments> paymentsList = paymentsService.listAll();
        model.addAttribute("allPayments", paymentsList);
        return "payments_all";
    }

    @GetMapping("users/payments/new")
    public String showPaymentsForm(Model model) {
        model.addAttribute("payment", new Payments());
        model.addAttribute("pageTitle", "Add Payment");
        return "payments_form";
    }

    @PostMapping("users/payments/save")
    public String addNewPayment(Payments payment, RedirectAttributes ra) {
        Credits credit = payment.getCredit();
        if (credit.getSumaCredit() - payment.getSumaPlatita() >= 0) {
            paymentsService.save(payment);
            credit.setSumaCredit(credit.getSumaCredit() - payment.getSumaPlatita());
            ra.addFlashAttribute("message", "The payment has been saved successfully");
        }
        else {
            ra.addFlashAttribute("message", "The payment could not be processed");
        }
        return "redirect:/users/payments/all";
    }
}
