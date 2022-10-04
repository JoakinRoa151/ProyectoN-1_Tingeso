package com.example.Proyecto1_Tingeso.controllers;

import com.example.Proyecto1_Tingeso.entities.AutorizacionEntity;
import com.example.Proyecto1_Tingeso.entities.InasistenciaEntity;
import com.example.Proyecto1_Tingeso.repositories.AutorizacionRepository;
import com.example.Proyecto1_Tingeso.services.AutorizacionService;
import com.example.Proyecto1_Tingeso.services.Ingreso_salidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@RequestMapping
@Controller
public class AutorizacionController {
    @Autowired
    AutorizacionService autorizacionService;

    @Autowired
    Ingreso_salidaService ingreso_salidaService;

    @GetMapping("/nuevaAutorizacion")
    public String agregar(Model model) {
        ArrayList<String> rutEmpleadosHorasExtra=ingreso_salidaService.buscarEmpleadosHorasExtra();
        model.addAttribute("autorizacion", new AutorizacionEntity());
        model.addAttribute("rutEmpleados", rutEmpleadosHorasExtra);
        return "ingresarAutorizacion";
    }

    @PostMapping("/guardarAutorizacion")
    public String guardarEmpleado(AutorizacionEntity autorizacion) {
        if(autorizacionService.obtenerAutorizacionRut(autorizacion.getRut_autorizacion())==null){
            autorizacionService.guardarAutorizacion(autorizacion);
            return "redirect:/listarAutorizaciones";
        }
        else {
            return "redirect:/listarAutorizaciones";
        }
    }

    @GetMapping("/listarAutorizaciones")
    public String listarAutorizaciones(Model model) {
        ArrayList<AutorizacionEntity> autorizaciones = autorizacionService.obtenerAutorizaciones();
        model.addAttribute("autorizaciones", autorizaciones);
        return "autorizaciones";
    }
    @GetMapping("/eliminarAutorizacion/{id}")
    public String eliminarAutorizacion(@PathVariable Long id){
        autorizacionService.eliminarAutorizacion( id);
        return "redirect:/listarAutorizaciones";
    }

}
