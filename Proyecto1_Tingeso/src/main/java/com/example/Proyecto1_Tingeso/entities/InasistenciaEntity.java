package com.example.Proyecto1_Tingeso.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "inasistencia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InasistenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String rut_inasistencia;
    private Date fecha;
    private Boolean justificativo;
}