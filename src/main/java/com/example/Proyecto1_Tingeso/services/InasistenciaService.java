package com.example.Proyecto1_Tingeso.services;

import com.example.Proyecto1_Tingeso.entities.EmpleadoEntity;
import com.example.Proyecto1_Tingeso.entities.InasistenciaEntity;
import com.example.Proyecto1_Tingeso.entities.Ingreso_salidaEntity;
import com.example.Proyecto1_Tingeso.repositories.InasistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;
@Service
public class InasistenciaService {
    @Autowired
    InasistenciaRepository inasistenciaRepository;

    public InasistenciaEntity guardarInasistencia(InasistenciaEntity inasistencia) {
        return inasistenciaRepository.save(inasistencia);
    }

    public void guardarInasistenciaAutomatico(ArrayList<Ingreso_salidaEntity> inasistencias) {
        for (Ingreso_salidaEntity inasistencia : inasistencias) {
            String rut = inasistencia.getRut_ing_sal();
            Date fecha = inasistencia.getFecha();
            InasistenciaEntity nuevaInasistencia = new InasistenciaEntity(null, rut, fecha, false);
            inasistenciaRepository.save(nuevaInasistencia);
        }
    }

    public void justificarInasistencia(Boolean justificativo, Long id) {
        inasistenciaRepository.justificarInasistencia(justificativo, id);
        return;
    }

    public ArrayList<InasistenciaEntity> obtenerInasistencias() {
        return (ArrayList<InasistenciaEntity>) inasistenciaRepository.findAll();
    }



}