package com.example.Proyecto1_Tingeso.controllers;
import com.example.Proyecto1_Tingeso.services.Ingreso_salidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping 
public class Ingreso_salidaController {
    /*@Autowired
    ReadService service;*/
    @Autowired
    Ingreso_salidaService service;

    @GetMapping("/leerArchivo")
    public String leerArchivo(){
        service.LeerArchivo();
        return "redirect:/";
    }

}
