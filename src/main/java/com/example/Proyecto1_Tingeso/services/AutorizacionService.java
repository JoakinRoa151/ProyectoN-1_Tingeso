package com.example.Proyecto1_Tingeso.services;

import com.example.Proyecto1_Tingeso.entities.AutorizacionEntity;
import com.example.Proyecto1_Tingeso.entities.InasistenciaEntity;
import com.example.Proyecto1_Tingeso.repositories.AutorizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AutorizacionService {
    @Autowired
    AutorizacionRepository autorizacionRepository;

    public AutorizacionEntity guardarAutorizacion(AutorizacionEntity autorizacion) {
        return autorizacionRepository.save(autorizacion);
    }
    public ArrayList<AutorizacionEntity> obtenerAutorizaciones(){
        return (ArrayList<AutorizacionEntity>) autorizacionRepository.findAll();
    }

    public AutorizacionEntity obtenerAutorizacionRut(String rut_autorizacion){
        return (autorizacionRepository.findByRut_Autorizacion(rut_autorizacion));
    }
    public boolean eliminarAutorizacion(Long id) {
        try{
            autorizacionRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }    }
}

