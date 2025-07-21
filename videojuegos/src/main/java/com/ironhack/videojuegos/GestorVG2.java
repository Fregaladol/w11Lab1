package com.ironhack.videojuegos;

import java.sql.*;
import java.util.Scanner;

public class GestorVG2 {

    public void consulta(){
        
        Scanner scanner = new Scanner(System.in);
        String titulo="";
        String fechaLanzamiento="";
 

        String insert = "INSERT INTO videojuego(titulo,lanzamiento) VALUES( ?,?)";

        

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/videojuegosDB", 
             "root","");
             
            //Statement stat1 = con1.createStatement();
            System.out.println("** Conexión Exitosa **");

            PreparedStatement ps = con1.prepareStatement(insert);
            
            do {

                System.out.println("Dame el título del juego");
                titulo = scanner.nextLine();

                if(titulo.equalsIgnoreCase("salir")){
                    break;
                }

                System.out.println("Escribe la fecha de lanzamiento (AAAA-MMM-DD)");
                fechaLanzamiento = scanner.nextLine();

                ps.setString(1, titulo);
                ps.setString(2, fechaLanzamiento);

                ps.executeUpdate();

                System.out.println("****Juego Añadido Correctamente ****");


            } while(true);
            
            scanner.close();
            



        } catch (Exception e) {

            System.out.println("Error en consulta.");
            e.printStackTrace();
        }
    }

}
