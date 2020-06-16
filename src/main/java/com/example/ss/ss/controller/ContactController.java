package com.example.ss.ss.controller;

import com.example.ss.ss.model.Contact;
import com.example.ss.ss.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping("/contact")
    public String showContact(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
        return "contact";
    }

    @GetMapping("/updatecontact")
    public String updateContact(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
        model.addAttribute("contact", new Contact());
        return "updatecontact";
    }


    @PostMapping("/updatecontact")
    public String modifyContactById(@ModelAttribute @Valid Contact contact, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updatecontact";
        } else
            contactRepository.save(contact);
        return "redirect:/updatecontact";
    }


    @PostMapping("/deletecontact")
    private String deleteContact(@RequestParam String id) {
        long num = Long.parseLong(id);
        contactRepository.deleteById(num);
        return "redirect:/updatecontact";
    }


}
