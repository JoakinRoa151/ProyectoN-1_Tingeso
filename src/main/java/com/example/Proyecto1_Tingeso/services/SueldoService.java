package com.example.Proyecto1_Tingeso.services;

import com.example.Proyecto1_Tingeso.entities.SueldoEntity;
import com.example.Proyecto1_Tingeso.repositories.SueldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SueldoService {
    @Autowired
    SueldoRepository sueldoRepository;

    public SueldoEntity guardarSueldo(SueldoEntity sueldo) {
        return sueldoRepository.save(sueldo);

    }

    public ArrayList<SueldoEntity> obtenerSueldos(){
        return (ArrayList<SueldoEntity>) sueldoRepository.findAll();
    }

    public void eliminarTodosSueldos(){
        sueldoRepository.deleteAll();
        return;
    }
}