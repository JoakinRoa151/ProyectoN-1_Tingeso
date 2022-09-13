package com.example.Proyecto1_Tingeso.repositories;

import com.example.Proyecto1_Tingeso.entities.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {
    public EmpleadoEntity findByRut(String rut);

    @Query("select e from EmpleadoEntity as e where e.nombres = :nombres")
    EmpleadoEntity findByNameCustomQuery(@Param("nombre") String nombres);

    @Query(value = "select * from empleados as e where e.nombres = :nombres",
            nativeQuery = true)
    EmpleadoEntity findByNameNativeQuery(@Param("nombre") String nombres);

}
