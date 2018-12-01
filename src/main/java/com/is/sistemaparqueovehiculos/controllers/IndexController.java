package com.is.sistemaparqueovehiculos.controllers;

import com.is.sistemaparqueovehiculos.models.entity.Usuario;
import com.is.sistemaparqueovehiculos.models.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class IndexController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/")
    public String inicio(Model model, Principal principal, HttpSession session){
        model.addAttribute("titulo", "Inicio");
        Usuario usuario = null;
        try {
            usuario = usuarioService.obtenerPorId(Long.parseLong(principal.getName()));
            model.addAttribute("usuario", usuario);
            if(usuario.getTipoUsuario().getNombre().equals("VIGILANTE")){
                return "redirect:/Vigilante/";
            }
        }catch (Exception e){}
        return "index";
    }

    @RequestMapping(value = "/*")
    public String redirrecionar(){
        return "redirect:/";
    }
}
