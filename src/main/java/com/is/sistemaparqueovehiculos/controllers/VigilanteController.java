package com.is.sistemaparqueovehiculos.controllers;

import com.is.sistemaparqueovehiculos.models.entity.Registro;
import com.is.sistemaparqueovehiculos.models.entity.Usuario;
import com.is.sistemaparqueovehiculos.models.entity.Vehiculo;
import com.is.sistemaparqueovehiculos.models.entity.Zona;
import com.is.sistemaparqueovehiculos.models.service.*;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping(value = "/Vigilante")
public class VigilanteController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RegistroService registroService;

    @Autowired
    private ZonaService zonaService;

    @Autowired
    private EstadoVehiculoService estadoVehiculoService;

    @Autowired
    private VehiculoService vehiculoService;

    @RequestMapping(value = {"/", "/*"})
    String inicio(Model model, Principal principal){
        Registro registro = new Registro();
        model.addAttribute("zonas", zonaService.obtener());
        model.addAttribute("registro", registro);
        model.addAttribute("usuario", usuarioService.obtenerPorId(Long.parseLong(principal.getName())));
        return "/vigilante/inicio";
    }

    @RequestMapping(value = "/mostrarUsuarios")
    String mostrarUsuarios(Model model, Principal principal){
        model.addAttribute("usuarios", usuarioService.obtener());
        model.addAttribute("titulo", "Lista de usuarios");
        model.addAttribute("usuario", usuarioService.obtenerPorId(Long.parseLong(principal.getName())));
        return "vigilante/mostrarUsuarios";
    }

    @RequestMapping(value = "/crearUsuario")
    public  String crear(Map<String, Object> model){
        Usuario usuario = new Usuario();
        model.put("usuario", usuario);
        model.put("titulo", "Formulario de Cliente");
        return "vigilante/crearUsuario";
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

    @GetMapping(value = "/mostrarRegistros")
    public String mostrarRegistros(Model model, Principal principal){
        model.addAttribute("registros", registroService.obtener());
        model.addAttribute("titulo", "Registros");
        model.addAttribute("usuario", usuarioService.obtenerPorId(Long.parseLong(principal.getName())));
        return "vigilante/mostrarRegistros";
    }

    @PostMapping(value = "/mostrarRegistros")
    public  String editar(@RequestParam("placa") String placa, Map<String, Object> model, Principal principal){
        if(!placa.isEmpty()){
            model.put("registros", registroService.obtenerPorPlaca(placa));
        }else{
            return "redirect:/Vigilante/mostrarRegistros";
        }
        model.put("titulo", "Buscar Registro");
        model.put("usuario", usuarioService.obtenerPorId(Long.parseLong(principal.getName())));
        return "vigilante/mostrarRegistros";
    }

    @PostMapping(value = "/darSalida")
    public String darSalida(@RequestParam("id") Long id, Model model, Principal principal){
        Registro registro = registroService.obtenerPorId(id);
        registro.setFechaSalida(new Date());
        Zona zona = zonaService.obtenerPorId(1L);
        zona.setCapacidadUtilizada(zona.getCapacidadUtilizada() - 1);
        zonaService.guardar(zona);
        registroService.guardar(registro);
        model.addAttribute("usuario", usuarioService.obtenerPorId(Long.parseLong(principal.getName())));
        return "redirect:/Vigilante/registroSalida";
    }

    @RequestMapping(value = "/registrarEntrada")
    public String registrarEntrada(Registro registro, Model model, Principal principal){
        Vehiculo vehiculo = new Vehiculo(registro.getVehiculo().getPlaca(), estadoVehiculoService.obtenerPorId(1L));
        Usuario cliente = usuarioService.obtenerPorId(registro.getCliente().getDocumento());
        Usuario vigilante = usuarioService.obtenerPorId(Long.parseLong(principal.getName()));
        Zona zona = zonaService.obtenerPorId(1L);
        zona.setId(1L);
        zona.setCapacidadUtilizada(zona.getCapacidadUtilizada() + 1);
        zonaService.guardar(zona);
        vehiculoService.guardar(vehiculo);
        registro.setVehiculo(vehiculo);
        registro.setCliente(cliente);
        registro.setVigilante(vigilante);
        registro.setZonaAsignada(zona);
        registroService.guardar(registro);
        return "redirect:/Vigilante";
    }

    @RequestMapping(value = "/registroSalida")
    public String salida(Model model, Principal principal){
        model.addAttribute("registros", registroService.obtener());
        model.addAttribute("titulo", "Salida");
        model.addAttribute("usuario", usuarioService.obtenerPorId(Long.parseLong(principal.getName())));
        return "vigilante/registroSalida";
    }

    @RequestMapping(value = "/perfil")
    public String perfil(Model model, Principal principal){
        model.addAttribute("usuario", usuarioService.obtenerPorId(Long.parseLong(principal.getName())));
        return "vigilante/perfilVigilante";
    }

    @RequestMapping(value = "/zonas")
    public String zonas(Model model, Principal principal){
        model.addAttribute("zonas", zonaService.obtener());
        model.addAttribute("usuario", usuarioService.obtenerPorId(Long.parseLong(principal.getName())));
        return "vigilante/zonas";
    }

}
