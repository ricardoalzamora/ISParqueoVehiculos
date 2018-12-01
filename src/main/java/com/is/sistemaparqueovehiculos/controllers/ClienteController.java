package com.is.sistemaparqueovehiculos.controllers;

import com.is.sistemaparqueovehiculos.models.service.RegistroService;
import com.is.sistemaparqueovehiculos.models.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping(value = "/Cliente")
public class ClienteController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RegistroService registroService;

    @RequestMapping(value = "mostrarRegistros")
    public String mostrarInfracciones(Model model, Principal principal){
        model.addAttribute("registros", registroService.obtenerRegistrosPorDocumento(Long.parseLong(principal.getName())));
        model.addAttribute("usuario", usuarioService.obtenerPorId(Long.parseLong(principal.getName())));
        return "cliente/mostrarRegistros";
    }
}
