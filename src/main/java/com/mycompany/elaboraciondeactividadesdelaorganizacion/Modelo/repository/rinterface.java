package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Conexion.pruebaconexion.entregadordedatos;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtocliente;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface rinterface<E> {

    /*Areglar*/
    public String c = "insert into ";

    public String r = "select * from ";
    public String u = "update ";
    public String d = "delete from ";

    public entregadordedatos entregador = new entregadordedatos();

    List<E> listar();

    void creardato(E base);

    void actualizar(E base);

    void eliminar(E base);

}
