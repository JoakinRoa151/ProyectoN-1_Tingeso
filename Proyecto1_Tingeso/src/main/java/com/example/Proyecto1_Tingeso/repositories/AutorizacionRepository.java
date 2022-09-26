package com.example.Proyecto1_Tingeso.repositories;

import com.example.Proyecto1_Tingeso.entities.AutorizacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface AutorizacionRepository extends JpaRepository<AutorizacionEntity, Long> {

}