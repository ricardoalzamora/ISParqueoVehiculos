package com.is.sistemaparqueovehiculos.controllers;

import com.is.sistemaparqueovehiculos.models.entity.Usuario;
import com.is.sistemaparqueovehiculos.models.service.RegistroService;
import com.is.sistemaparqueovehiculos.models.service.UsuarioService;
import netscape.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping(value = "/Vigilante")
public class VigilanteController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RegistroService registroService;

    @RequestMapping("/mostrarUsuarios")
    String mostrarUsuarios(Model model, Principal principal){
        model.addAttribute("usuarios", usuarioService.obtener());
        model.addAttribute("titulo", "Lista de usuarios");
        model.addAttribute("nombreusuario", SecurityContextHolder.getContext().getAuthentication().getName());
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
        return  "redirect:Vigilante/mostrarUsuarios";
    }

    @RequestMapping(value = "/mostrarRegistros")
    public String mostrarRegistros(Model model){
        model.addAttribute("registros", registroService.obtenerRegistrosPorDocumento(123L));
        model.addAttribute("controlador", "/Cliente");
        return "usuario/ClienteIndex";
    }

}
