package com.example.Proyecto1_Tingeso.controllers;
import com.example.Proyecto1_Tingeso.services.Ingreso_salidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping 
public class Ingreso_salidaController {
    @Autowired
    Ingreso_salidaService ingreso_salidaService;

    @GetMapping("/leerArchivo")
    public String leerArchivo(){
        ingreso_salidaService.eliminarTodoIngresoSalida();
        ingreso_salidaService.LeerArchivo();
        return "redirect:/inasistenciasAutomatico";
    }

}
