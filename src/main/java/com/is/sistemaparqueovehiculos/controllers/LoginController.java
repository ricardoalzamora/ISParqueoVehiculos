package com.is.sistemaparqueovehiculos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error, Model model, Principal principal){
        if(principal != null){
            return "redirect:/";
        }
        if(error != null){
            model.addAttribute("error", "Error en Documento o Contraseña de usuario.");
        }
        return "login";
    }

    @RequestMapping("/logout")
    public String logut(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
