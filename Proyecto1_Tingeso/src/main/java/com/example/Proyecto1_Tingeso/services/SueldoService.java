package com.example.Proyecto1_Tingeso.services;

import com.example.Proyecto1_Tingeso.entities.SueldoEntity;
import com.example.Proyecto1_Tingeso.repositories.SueldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SueldoService {
    @Autowired
    SueldoRepository sueldoRepository;

    public SueldoEntity guardarSueldo(SueldoEntity sueldo) {
        return sueldoRepository.save(sueldo);

    }
}