package com.example.Proyecto1_Tingeso.repositories;

import com.example.Proyecto1_Tingeso.entities.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {


}
