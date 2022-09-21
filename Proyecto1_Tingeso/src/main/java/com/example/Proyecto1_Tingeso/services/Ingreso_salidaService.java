package com.example.Proyecto1_Tingeso.services;
import com.example.Proyecto1_Tingeso.repositories.Ingreso_salidaRepository;
import com.example.Proyecto1_Tingeso.entities.Ingreso_salidaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
@Service
public class Ingreso_salidaService {
    @Autowired
     Ingreso_salidaRepository ingreso_salidaRepository;

    public Ingreso_salidaEntity guardarIngreso_salida(Ingreso_salidaEntity ingreso_salida){
        return ingreso_salidaRepository.save(ingreso_salida);
    }
    public void LeerArchivo(){
        try {
            File myObj = new File("data/DATA.txt");
            Scanner scanner = new Scanner(myObj);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                StringTokenizer atributo= new StringTokenizer(linea, ";");
                Ingreso_salidaEntity ingreso_salida = new Ingreso_salidaEntity();
                while(atributo.hasMoreElements()){
                    ingreso_salida.setFecha(atributo.nextElement().toString());
                    ingreso_salida.setHora(atributo.nextElement().toString());
                    ingreso_salida.setRut_ing_sal(atributo.nextElement().toString());
                }
                guardarIngreso_salida(ingreso_salida);
            }
            scanner.close();
            return;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
