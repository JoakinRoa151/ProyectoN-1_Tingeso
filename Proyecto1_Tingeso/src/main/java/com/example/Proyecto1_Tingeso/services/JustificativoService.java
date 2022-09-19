package com.example.Proyecto1_Tingeso.services;

import com.example.Proyecto1_Tingeso.entities.JustificativoEntity;
import com.example.Proyecto1_Tingeso.repositories.JustificativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
@Service
public class JustificativoService {
    @Autowired
    JustificativoRepository justificativoRepository;

    public JustificativoEntity guardarJustificativo(JustificativoEntity justificativo){
        return justificativoRepository.save(justificativo);
    }


}