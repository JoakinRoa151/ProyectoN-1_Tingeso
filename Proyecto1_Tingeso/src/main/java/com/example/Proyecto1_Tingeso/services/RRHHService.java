package com.example.Proyecto1_Tingeso.services;

import com.example.Proyecto1_Tingeso.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Proyecto1_Tingeso.entities.EmpleadoEntity;
import com.example.Proyecto1_Tingeso.entities.SueldoEntity;
import com.example.Proyecto1_Tingeso.entities.InasistenciaEntity;

import java.util.ArrayList;

@Service
public class RRHHService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    public double obtenerSueldoFijo(String categoria) {
        if (categoria.equals("A")) {
            return 1700000;
        }
        if (categoria.equals("B")) {
            return 1200000;
        }
        else{
            return 800000;
        }
    }
    public double bonificacionHorasExtras(String categoria){
        if (categoria.equals("A")) {
            return 25000;
        }
        if (categoria.equals("B")) {
            return 20000;
        }
        else{
            return 10000;
        }
    }

    public double descuentosCotizacion(Double sueldoParcial){
        return ((sueldoParcial*0.1)+ (sueldoParcial*0.8));
    }

    public double bonificacionTiempoServicio(int anios){
        if(anios>=25){
            return 1.17;
        }
        if(anios>=20){
            return 1.14;
        }
        if(anios>=15){
            return 1.11;
        }
        if(anios>=10){
            return 1.08;
        }
        if(anios>=5){
            return 1.05;
        }else {
            return 1;
        }
    }


}
