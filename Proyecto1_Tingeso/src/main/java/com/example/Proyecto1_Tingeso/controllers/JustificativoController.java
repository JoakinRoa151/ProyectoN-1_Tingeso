package com.example.Proyecto1_Tingeso.controllers;

import com.example.Proyecto1_Tingeso.entities.JustificativoEntity;
import com.example.Proyecto1_Tingeso.services.JustificativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class JustificativoController {
    @Autowired
    private JustificativoService service;
    @GetMapping("/nuevoJustificativo")
    public String agregar(Model model){
        model.addAttribute("justificativo",new JustificativoEntity());

        return "justificativo";
    }

    @GetMapping("/nuevoJustificativo")
    public String guardarJustificativo(@Valid JustificativoEntity j, Model model){
        service.save(j);
        return "redirect:/";

    }
}
