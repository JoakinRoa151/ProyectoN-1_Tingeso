package com.example.Proyecto1_Tingeso.controllers;

import com.example.Proyecto1_Tingeso.entities.EmpleadoEntity;
import com.example.Proyecto1_Tingeso.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/listarEmpleados")
    public String listar(Model model) {
        ArrayList<EmpleadoEntity> empleados = empleadoService.obtenerEmpleados();
        model.addAttribute("empleados", empleados);
        return "empleados";
    }

    @GetMapping("/nuevoEmpleado")
    public String agregar(Model model) {
        model.addAttribute("empleado", new EmpleadoEntity());

        return "ingresarEmpleado";
    }

    @PostMapping("/guardarEmpleado")
    public String guardarEmpleado(EmpleadoEntity empleado) {
        if(empleadoService.obtenerPorRut(empleado.getRut())==null){
            empleadoService.guardarEmpleado(empleado);
            return "redirect:/listarEmpleados";
        }
        return "redirect:/listarEmpleados";
    }

    @GetMapping("/eliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable Long id){
        empleadoService.eliminarEmpleado( id);
        return "redirect:/listarEmpleados";
    }
}