
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Conexion.pruebaconexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class pruebaconexionbd implements CasoBase{
       
    public String comprobarconexion(){
     System.out.println("Intentando conectar a la base de datos...");

        // 2. El try-with-resources abre y cierra la conexión automáticamente
        try (Connection conectar = 
                DriverManager.getConnection(URL, USER, PASSWORD)) {
            
            if (conectar != null) {
                return ("¡Conexión exitosa a MySQL!");
            }

        } catch (SQLException e) {
              e.printStackTrace();
           return ("Error al conectar a la base de datos:");
          
        }
    
       return "No se pudo establecer la conexión.";
    
    }
    
    
}
