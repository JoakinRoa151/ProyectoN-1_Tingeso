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
@AllArgsConstructor
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

}