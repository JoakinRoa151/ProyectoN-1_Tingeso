/*package com.example.Proyecto1_Tingeso.services;
import java.io.BufferedReader;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.StringTokenizer;

import com.example.Proyecto1_Tingeso.entities.Ingreso_salidaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadService {

    Ingreso_salidaService ingreso_salidaService;
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
                    System.out.println("ENTRE DE NUEVO");
                }
                //ingreso_salida.add(ingreso_salida);
                ingreso_salidaService.guardarIngreso_salida(ingreso_salida);
                System.out.println("XDDDDDDDDDDDD");
            }
            scanner.close();
            return;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

public class ReadService {

    public static void main(String[] args) {
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
                System.out.println(ingreso_salida.getFecha());
                System.out.println(ingreso_salida.getHora());
                System.out.println(ingreso_salida.getRut_ing_sal());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}¨*/