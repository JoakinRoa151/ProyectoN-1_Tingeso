package com.example.Proyecto1_Tingeso.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.Proyecto1_Tingeso.services.ReadService;

public class ReadController {
    @Autowired
    private ReadService lectura;

    @GetMapping("/vista")
    public String read_test() {
        ;
        return "index";
    }

}
