package com.is.sistemaparqueovehiculos.controllers;

import com.is.sistemaparqueovehiculos.models.dao.IRegistroDao;
import com.is.sistemaparqueovehiculos.models.dao.IUsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping(value = "/Cliente")
public class ClienteController {

    @Autowired
    @Qualifier("usuariodao")
    private IUsuarioDao usuarioDao;

    @Autowired
    @Qualifier("registrodao")
    private IRegistroDao registroDao;

    @RequestMapping(value = "mostrarRegistros")
    public String mostrarInfracciones(Model model, Principal principal){
        model.addAttribute("registros", registroDao.findAllByClienteDocumento(Long.parseLong(principal.getName())));
        return "cliente/mostrarRegistros";
    }
}
