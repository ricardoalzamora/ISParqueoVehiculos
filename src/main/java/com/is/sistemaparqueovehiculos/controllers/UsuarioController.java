package com.is.sistemaparqueovehiculos.controllers;

import com.is.sistemaparqueovehiculos.models.entity.Usuario;
import com.is.sistemaparqueovehiculos.models.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping("/mostrarUsuarios")
    String mostrarUsuarios(Model model){
        model.addAttribute("usuarios", usuarioService.obtener());
        return "mostrarUsuarios";
    }

    @RequestMapping(value = "/crearUsuario")
    public  String crear(Map<String, Object> model){
        Usuario usuario = new Usuario();
        model.put("usuario", usuario);
        model.put("titulo", "Formulario de Cliente");
        return "crearUsuario";
    }

    @RequestMapping(value = "/crearUsuario", method = RequestMethod.POST)
    public String guardar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status){
        model.addAttribute("titulo", "Formulario de Cliente");
        if(result.hasErrors()){
            return "form";
        }
        usuarioService.crear(usuario);
        status.setComplete();
        return  "redirect:mostrarUsuarios";
    }

}
