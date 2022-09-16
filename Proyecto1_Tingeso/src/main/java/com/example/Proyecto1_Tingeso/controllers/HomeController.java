package com.example.Proyecto1_Tingeso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Proyecto1_Tingeso.services.UploadService;

@Controller
public class HomeController {

    @Autowired
    private UploadService upload;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/justificativo")
    public String justificaciones() {
        return "justificativo";
    }

    @GetMapping("/subirArchivo")
    public String home() {
        return "home";
    }

    @PostMapping("/cargar")
    public String carga( @RequestParam("archivos") MultipartFile file, RedirectAttributes ms) {
        upload.save(file);
        ms.addFlashAttribute("mensaje", "Archivo guardado correctamente!!");
        return "redirect:/";
    }

}