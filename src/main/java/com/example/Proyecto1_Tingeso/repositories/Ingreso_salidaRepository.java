package com.example.Proyecto1_Tingeso.repositories;

import com.example.Proyecto1_Tingeso.entities.Ingreso_salidaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface Ingreso_salidaRepository extends JpaRepository<Ingreso_salidaEntity, Long> {
    @Query(value ="SELECT count(*)  FROM tingeso.ingreso_salida as t where hora>\"08:10\" and hora<=\"08:25\" and t.rut_ing_sal = :rut_ing_sal" ,
            nativeQuery = true)
    Integer buscarAtrasosPorRutTipo1(@Param("rut_ing_sal") String rut_ing_sal);

        @Query(value ="SELECT count(*) FROM tingeso.ingreso_salida as t where hora>\"08:25\" and hora<=\"08:45\"  and t.rut_ing_sal = :rut_ing_sal" ,
            nativeQuery = true)
    Integer buscarAtrasosPorRutTipo2(@Param("rut_ing_sal") String rut_ing_sal);

    @Query(value ="SELECT count(*)  FROM tingeso.ingreso_salida as t where hora>\"08:45\" and hora<=\"09:10\" and t.rut_ing_sal = :rut_ing_sal" ,
            nativeQuery = true)
    Integer  buscarAtrasosPorRutTipo3(@Param("rut_ing_sal") String rut_ing_sal);

    @Query(value ="SELECT *  FROM tingeso.ingreso_salida as t where hora>\"09:10\" and hora<\"18:00\"" ,
            nativeQuery = true)
    ArrayList<Ingreso_salidaEntity> buscarInasistencias();

    @Query(value= "SELECT * FROM tingeso.ingreso_salida as i where i.hora>\"18:00\" and i.rut_ing_sal= :rut_ing_sal",
            nativeQuery = true)
        ArrayList<Ingreso_salidaEntity> buscarHorasExtrasPorRut(@Param("rut_ing_sal") String rut_ing_sal);

    @Query(value= "SELECT DISTINCT i.rut_ing_sal FROM tingeso.ingreso_salida  as i where i.hora>\"18:00\"", nativeQuery = true)
    ArrayList<String> buscarEmpleadosHorasExtra();
}
