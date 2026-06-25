
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Conexion.pruebaconexion;

import java.sql.*;

public class entregadordedatos implements CasoBase{
    
    public Connection getConexion() throws SQLException{
    try{
    return DriverManager.getConnection(URL,USER,PASSWORD);
    }catch(ClassCastException e){
    throw new SQLException("Error de conexion",e);
    }
    
    
    }
    
}
