package com.example.Proyecto1_Tingeso.controllers;

import com.example.Proyecto1_Tingeso.entities.EmpleadoEntity;
import com.example.Proyecto1_Tingeso.entities.SueldoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.Proyecto1_Tingeso.services.EmpleadoService;
import com.example.Proyecto1_Tingeso.services.JustificativoService;
import com.example.Proyecto1_Tingeso.services.RRHHService;

import java.util.ArrayList;

@Controller
@RequestMapping
public class SueldoController {
    @Autowired
    EmpleadoService empleadoService;
    /*public SueldoEntity calcularSueldo(){
       ArrayList<EmpleadoEntity> empleados= empleadoService.obtenerEmpleados();


    }*/
}
