package com.example.Proyecto1_Tingeso.controllers;

import com.example.Proyecto1_Tingeso.entities.EmpleadoEntity;
import com.example.Proyecto1_Tingeso.entities.SueldoEntity;
import com.example.Proyecto1_Tingeso.services.Ingreso_salidaService;
import com.example.Proyecto1_Tingeso.services.SueldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.Proyecto1_Tingeso.services.EmpleadoService;
import com.example.Proyecto1_Tingeso.services.RRHHService;

import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

@Controller
@RequestMapping
public class SueldoController {
    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    Ingreso_salidaService ingreso_salidaService;
    @Autowired
    RRHHService rrhhService;

    @Autowired
    SueldoService sueldoService;

    @GetMapping("/sueldo")
    public String calcularSueldo(){
       ArrayList<EmpleadoEntity> empleados= empleadoService.obtenerEmpleados();
        for(EmpleadoEntity empleado : empleados){
            int anioServicio =  LocalDateTime.now().getYear()-Integer.valueOf(empleado.getFecha_ingreso().toString().split("-")[0]) ;
            double sueldoFijo = rrhhService.obtenerSueldoFijo(empleado.getCategoria());
            double descuentoCotizacionPrevisional= rrhhService.descuentoCotizacionPrevisional(sueldoFijo);
            double descuentoCotizacionSalud= rrhhService.descuentoCotizacionSalud(sueldoFijo);
            double bonificacionTiempoServicio= rrhhService.bonificacionTiempoServicio(anioServicio) * sueldoFijo;
            double descuentoAtrasos= (rrhhService.descuentosAtrasos(empleado.getRut()))* sueldoFijo;
            double bonificacionHorasExtra= rrhhService.bonificacionHorasExtras(empleado.getCategoria(), ingreso_salidaService.cantidadHorasExtraPorRut(empleado.getRut()));
            double descuentoInasistencia= rrhhService.descuentoInasistencias(empleado.getRut()) * sueldoFijo;
            double sueldoBruto= sueldoFijo + (bonificacionHorasExtra+bonificacionTiempoServicio)-(descuentoAtrasos+descuentoInasistencia);
            double sueldoLiquido= sueldoFijo+(bonificacionHorasExtra+bonificacionTiempoServicio)-(descuentoAtrasos+descuentoInasistencia+descuentoCotizacionPrevisional+descuentoCotizacionSalud);
            SueldoEntity sueldo= new SueldoEntity(null, empleado.getRut(),anioServicio,sueldoFijo,bonificacionTiempoServicio,bonificacionHorasExtra,descuentoAtrasos+descuentoInasistencia,sueldoBruto,
                    descuentoCotizacionSalud,descuentoCotizacionPrevisional,sueldoLiquido);

            sueldoService.guardarSueldo(sueldo);
        }
        return "redirect:/";
    }
    @GetMapping("/prueba")
    public String prueba(){
        //Integer A= ingreso_salidaService.buscarInasistencias1("20.457.671-9");
        //double A= ingreso_salidaService.cantidadHorasExtraPorRut("27.752.982-4");

        /*ArrayList<Ingreso_salidaEntity> A=ingreso_salidaService.horasExtraPorRut("20.457.671-9");
        for(Ingreso_salidaEntity i : A){
            System.out.println(i.getHora());
        }*/
      //  System.out.println(A);
        rrhhService.descuentoInasistencias("20.457.671-9");
        rrhhService.descuentosAtrasos("20.457.671-9");
        return "redirect:/";
    }
}
