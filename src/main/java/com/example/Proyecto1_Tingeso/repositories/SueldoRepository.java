package com.example.Proyecto1_Tingeso.repositories;
import com.example.Proyecto1_Tingeso.entities.EmpleadoEntity;
import com.example.Proyecto1_Tingeso.entities.SueldoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SueldoRepository extends JpaRepository<SueldoEntity, Long> {
}