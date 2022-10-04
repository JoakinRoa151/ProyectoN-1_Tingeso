package com.example.Proyecto1_Tingeso.controllers;



import com.example.Proyecto1_Tingeso.entities.InasistenciaEntity;
import com.example.Proyecto1_Tingeso.entities.SueldoEntity;
import com.example.Proyecto1_Tingeso.services.InasistenciaService;
import com.example.Proyecto1_Tingeso.services.Ingreso_salidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping
public class InasistenciaController {
    @Autowired
    InasistenciaService inasistenciaService;
    @Autowired
    Ingreso_salidaService ingreso_salidaService;
    @GetMapping("/nuevaInasistencia")
    public String agregar(Model model){
        model.addAttribute("inasistencia",new InasistenciaEntity());

        return "ingresarInasistencia";
    }

    @PostMapping("/guardarInasistencia")
    public String guardarInasistencia( InasistenciaEntity inasistencia){
        inasistenciaService.guardarInasistencia(inasistencia);
        return "redirect:/listarInasistencias";

    }

    @GetMapping("/inasistenciasAutomatico")
    public String guardarInasistenciasAutomatico(){
        inasistenciaService.guardarInasistenciaAutomatico(ingreso_salidaService.buscarInasistencias());
        return "redirect:/";
    }

    @GetMapping("/justificarInasistencia/{id}")
    public String justificarInasistencia(@PathVariable Long id){
        inasistenciaService.justificarInasistencia(true, id);
        return "redirect:/listarInasistencias";
    }

    @GetMapping("/inJustificarInasistencia/{id}")
    public String inJustificarInasistencia(@PathVariable Long id){
        inasistenciaService.justificarInasistencia(false, id);
        return "redirect:/listarInasistencias";
    }

    @GetMapping("/listarInasistencias")
    public String listarInasistencias(Model model) {
        ArrayList<InasistenciaEntity> inasistencias = inasistenciaService.obtenerInasistencias();
        model.addAttribute("inasistencias", inasistencias);
        return "inasistencias";
    }
}
