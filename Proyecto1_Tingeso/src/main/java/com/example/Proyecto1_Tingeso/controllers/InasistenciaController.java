package com.example.Proyecto1_Tingeso.controllers;



import com.example.Proyecto1_Tingeso.entities.InasistenciaEntity;
import com.example.Proyecto1_Tingeso.services.InasistenciaService;
import com.example.Proyecto1_Tingeso.services.Ingreso_salidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

        return "inasistencia";
    }

    @PostMapping("/guardarInasistencia")
    public String guardarInasistencia( InasistenciaEntity inasistencia){
        inasistenciaService.guardarInasistencia(inasistencia);
        return "redirect:/";

    }

    @GetMapping("/inasistenciasAutomatico")
    public String guardarInasistenciasAutomatico(){
        inasistenciaService.guardarInasistenciaAutomatico(ingreso_salidaService.buscarInasistencias());
        return "redirect:/";
    }
}
