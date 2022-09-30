package com.example.Proyecto1_Tingeso.controllers;

import com.example.Proyecto1_Tingeso.entities.EmpleadoEntity;
import com.example.Proyecto1_Tingeso.entities.SueldoEntity;
import com.example.Proyecto1_Tingeso.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @Autowired
    AutorizacionService autorizacionService;

    @GetMapping("/calcularSueldo")
    public String calcularSueldo(){
        sueldoService.eliminarTodosSueldos();
       ArrayList<EmpleadoEntity> empleados= empleadoService.obtenerEmpleados();
        for(EmpleadoEntity empleado : empleados){
            int anioServicio =  LocalDateTime.now().getYear()-Integer.valueOf(empleado.getFecha_ingreso().toString().split("-")[0]) ;
            double sueldoFijo = rrhhService.obtenerSueldoFijo(empleado.getCategoria());
            double bonificacionTiempoServicio= rrhhService.bonificacionTiempoServicio(anioServicio) * sueldoFijo;
            double descuentoAtrasos= (rrhhService.descuentosAtrasos(empleado.getRut()))* sueldoFijo;
            double bonificacionHorasExtra=0;
            if (autorizacionService.obtenerAutorizacionRut(empleado.getRut())!=null){
                bonificacionHorasExtra= rrhhService.bonificacionHorasExtras(empleado.getCategoria(), ingreso_salidaService.cantidadHorasExtraPorRut(empleado.getRut()));
            }
            double descuentoInasistencia= rrhhService.descuentoInasistencias(empleado.getRut()) * sueldoFijo;
            double sueldoBruto= sueldoFijo + (bonificacionHorasExtra+bonificacionTiempoServicio)-(descuentoAtrasos+descuentoInasistencia);
            double descuentoCotizacionPrevisional= rrhhService.descuentoCotizacionPrevisional(sueldoBruto);
            double descuentoCotizacionSalud= rrhhService.descuentoCotizacionSalud(sueldoBruto);
            double sueldoFinal= sueldoFijo+(bonificacionHorasExtra+bonificacionTiempoServicio)-(descuentoAtrasos+descuentoInasistencia+descuentoCotizacionPrevisional+descuentoCotizacionSalud);
            SueldoEntity sueldo= new SueldoEntity(null, empleado.getRut(),anioServicio,sueldoFijo,bonificacionTiempoServicio,bonificacionHorasExtra,descuentoAtrasos+descuentoInasistencia,sueldoBruto,
                    descuentoCotizacionPrevisional ,descuentoCotizacionSalud,sueldoFinal);

            sueldoService.guardarSueldo(sueldo);
        }
        return "redirect:/sueldos";
    }

    @GetMapping("/sueldos")
    public String listarSueldos(Model model) {
        ArrayList<SueldoEntity> sueldos = sueldoService.obtenerSueldos();
        model.addAttribute("sueldos", sueldos);
        return "sueldos";
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
