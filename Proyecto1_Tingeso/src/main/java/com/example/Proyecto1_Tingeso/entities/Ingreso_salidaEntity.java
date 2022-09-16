package com.example.Proyecto1_Tingeso.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ingreso_salida")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingreso_salidaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String dia;
    private String mes;
    private String anio;
    private String hora_ingreso;
    private String hora_salida;
    private String rut_ing_sal;
}
