package com.is.sistemaparqueovehiculos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String inicio(Model model){
        model.addAttribute("titulo", "Inicio");
        return "index";
    }
}
