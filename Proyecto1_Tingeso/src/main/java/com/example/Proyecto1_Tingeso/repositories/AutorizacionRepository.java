package com.example.Proyecto1_Tingeso.repositories;

import com.example.Proyecto1_Tingeso.entities.AutorizacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AutorizacionRepository extends JpaRepository<AutorizacionEntity, Long> {

    @Query(value= "SELECT * FROM tingeso.autorizacion  as a where a.rut_autorizacion = :rut_autorizacion", nativeQuery = true)
    public AutorizacionEntity findByRut_Autorizacion(@Param( "rut_autorizacion") String rut_autorizacion);
}