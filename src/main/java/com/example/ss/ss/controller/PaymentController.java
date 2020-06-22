package com.example.ss.ss.controller;

import com.example.ss.ss.model.Payment;
import com.example.ss.ss.repository.PaymentRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.validation.Valid;
import java.util.List;


@Controller
public class PaymentController {

    private PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @GetMapping("/payment")
    public String showPayment(Model model, Authentication authentication) {
        List<Payment> byEmail = paymentRepository.findByEmail(authentication.getName());
        model.addAttribute("payments", byEmail);
        return "payment";
    }

    @GetMapping("/addpayment")
    public String add(Model model) {
        model.addAttribute("payment", new Payment());
        return "addpayment";
    }

    @PostMapping("/addpayment")
    public String addPayment(Payment payment) {
        if (payment.getContent().isEmpty()) {
            return "addpayment";
        } else {
            paymentRepository.save(payment);
            return "addpayment";
        }
    }

    @GetMapping("/modifypayment")
    public String mapping(Model model) {
        model.addAttribute("payments", paymentRepository.findAll());
        model.addAttribute("payment", new Payment());
        return "modifypayment";
    }

    @PostMapping("/modifypayment")
    public String modifypayment(@ModelAttribute @Valid Payment payment, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "modifypayment";
        } else
            paymentRepository.save(payment);
        return "redirect:/modifypayment";
    }

    @PostMapping("/deletepayment")
    private String deletePayment(@RequestParam String id) {
        long num = Long.parseLong(id);
        paymentRepository.deleteById(num);
        return "redirect:/modifypayment";
    }

}










