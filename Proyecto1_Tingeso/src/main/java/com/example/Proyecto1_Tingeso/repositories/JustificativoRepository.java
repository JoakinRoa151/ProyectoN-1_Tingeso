package com.example.Proyecto1_Tingeso.repositories;
import com.example.Proyecto1_Tingeso.entities.JustificativoEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JustificativoRepository {

    JustificativoEntity save(JustificativoEntity empleado);
}
