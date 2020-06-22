package com.example.ss.ss.controller;

import com.example.ss.ss.model.Info;
import com.example.ss.ss.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@Controller
public class InfoController {
    @Autowired
    private InfoRepository infoRepository;

    public InfoController(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    @GetMapping("/info")
    public String showInfo(Model model) {
        List<Info> byStatus = infoRepository.findByStatus(true);
        model.addAttribute("infos", byStatus);
        return "info";
    }


    @GetMapping("/updateinfo")
    public String modifyInfo(Model model) {
        model.addAttribute("infos", infoRepository.findAll());
        model.addAttribute("info", new Info());
        return "updateinfo";
    }


    @PostMapping("/updateinfo")
    public String modifyInfoById(@ModelAttribute @Valid Info info, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateinfo";
        } else
            infoRepository.save(info);
        return "redirect:/updateinfo";
    }


    @PostMapping("/deleteinfo")
    private String deleteinfo(@RequestParam String id) {
        long num = Long.parseLong(id);
        infoRepository.deleteById(num);
        return "redirect:/updateinfo";
    }
}