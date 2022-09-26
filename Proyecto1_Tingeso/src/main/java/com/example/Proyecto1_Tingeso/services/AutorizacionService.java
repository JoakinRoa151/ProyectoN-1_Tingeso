package com.example.Proyecto1_Tingeso.services;

import com.example.Proyecto1_Tingeso.entities.AutorizacionEntity;
import com.example.Proyecto1_Tingeso.repositories.AutorizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AutorizacionService {
    @Autowired
    AutorizacionRepository autorizacionRepository;

    public AutorizacionEntity guardarAutorizacion(AutorizacionEntity autorizacion) {
        return autorizacionRepository.save(autorizacion);

    }
}