package com.example.Proyecto1_Tingeso.repositories;

import com.example.Proyecto1_Tingeso.entities.InasistenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;

@Repository
public interface InasistenciaRepository extends JpaRepository<InasistenciaEntity, Long> {

    @Query(value ="SELECT *  FROM tingeso.inasistencia as i where i.fecha=:fecha and i.rut_inasistencia = :rut_inasistencia" ,
            nativeQuery = true)
    InasistenciaEntity buscarInasistenciasPorRutFecha(@Param("rut_inasistencia") String rut_inasistencia,@Param("fecha") Date fecha);

    @Query(value ="SELECT *  FROM tingeso.inasistencia as i where i.rut_inasistencia = :rut_inasistencia" ,
            nativeQuery = true)
    ArrayList<InasistenciaEntity> buscarInasistenciasPorRut(@Param("rut_inasistencia") String rut_inasistencia);

    @Transactional
    @Modifying
    @Query(value = "UPDATE tingeso.inasistencia as i set i.justificativo = :valorJustificativo where i.id=:id", nativeQuery = true)
    void justificarInasistencia(@Param( "valorJustificativo") Boolean valorJustificativo, @Param("id") Long id);
}