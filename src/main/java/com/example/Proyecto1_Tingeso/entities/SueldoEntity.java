package com.example.Proyecto1_Tingeso.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sueldo")
@Data
@NoArgsConstructor
public class SueldoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String rut_sueldo;
    private Integer anios_servicio;
    private Double sueldo_fijo;
    private Double monto_bonificacion_servicios;
    private Double monto_horas_extras;
    private Double monto_descuentos;
    private Double sueldo_bruto;
    private Double cotizacion_previsional;
    private Double cotizacion_salud;
    private Double monto_sueldo_final;

    public SueldoEntity(Long id, String rut_sueldo, Integer anios_servicio, Double sueldo_fijo, Double monto_bonificacion_servicios, Double monto_horas_extras, Double monto_descuentos, Double sueldo_bruto, Double cotizacion_previsional, Double cotizacion_salud, Double monto_sueldo_final) {
        this.id = id;
        this.rut_sueldo = rut_sueldo;
        this.anios_servicio = anios_servicio;
        this.sueldo_fijo = sueldo_fijo;
        this.monto_bonificacion_servicios = monto_bonificacion_servicios;
        this.monto_horas_extras = monto_horas_extras;
        this.monto_descuentos = monto_descuentos;
        this.sueldo_bruto = sueldo_bruto;
        this.cotizacion_previsional = cotizacion_previsional;
        this.cotizacion_salud = cotizacion_salud;
        this.monto_sueldo_final = monto_sueldo_final;
    }
}