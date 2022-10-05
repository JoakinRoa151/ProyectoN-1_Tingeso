package com.example.Proyecto1_Tingeso.services;
import com.example.Proyecto1_Tingeso.repositories.InasistenciaRepository;
import com.example.Proyecto1_Tingeso.repositories.Ingreso_salidaRepository;
import com.example.Proyecto1_Tingeso.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Proyecto1_Tingeso.entities.InasistenciaEntity;



import java.util.ArrayList;

@Service
public class RRHHService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    Ingreso_salidaRepository ingreso_salidaRepository;

    @Autowired
    InasistenciaRepository inasistenciaRepository;

    @Autowired
    AutorizacionService autorizacionService;

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
    public double bonificacionHorasExtras(String categoria, double cantidadHorasExtra){
        double cantidadHorasExtras = Math.round(cantidadHorasExtra * 100.0) / 100.0;
        if (categoria.equals("A")) {
            return (cantidadHorasExtras*25000);
        }
        if (categoria.equals("B")) {
            return (cantidadHorasExtras*20000);
        }
        else{
            return (cantidadHorasExtras*10000);
        }
    }

    public double descuentoCotizacionPrevisional(Double sueldoParcial){
        return (sueldoParcial*0.1) ;
    }

    public double descuentoCotizacionSalud(Double sueldoParcial){
        return (sueldoParcial*0.08);
    }

    public double descuentosAtrasos(String rut){
        int atrasoTipo1= ingreso_salidaRepository.buscarAtrasosPorRutTipo1(rut);
        int atrasoTipo2= ingreso_salidaRepository.buscarAtrasosPorRutTipo2(rut);
        int atrasoTipo3= ingreso_salidaRepository.buscarAtrasosPorRutTipo3(rut);
        double descuentoTotal=0;
        if(atrasoTipo1>0){
            descuentoTotal=0.01*atrasoTipo1;
        }
        if(atrasoTipo2>0){
            descuentoTotal=0.03*atrasoTipo2+ descuentoTotal;
        }

        if(atrasoTipo3>0){
            descuentoTotal=0.06*atrasoTipo3+ descuentoTotal;
        }
        return (descuentoTotal);

    }

    public double descuentoInasistencias(String rut){
        ArrayList<InasistenciaEntity> inasistenciasEmpleado= inasistenciaRepository.buscarInasistenciasPorRut(rut);
        double descuento= 0;
        for(InasistenciaEntity inasistenciaEmpleado : inasistenciasEmpleado){
            if(inasistenciaEmpleado.getJustificativo()==false){
                descuento=descuento+0.15;
            }
        }
        if (descuento==0){
            return 0;
        }
        if(descuento>=1){
            return 1;
        }

        return descuento;
    }
    public double bonificacionTiempoServicio(int aniosServicio){
        if(aniosServicio>=25){
            return 0.17;
        }
        if(aniosServicio>=20){
            return 0.14;
        }
        if(aniosServicio>=15){
            return 0.11;
        }
        if(aniosServicio>=10){
            return 0.08;
        }

        if(aniosServicio>=5){
            return 0.05;
        }else {
            return 0;
        }
    }



}
