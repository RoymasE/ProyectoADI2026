/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtofactura;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoproducto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.factura;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.producto;
import static com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository.rinterface.entregador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class rproducto implements rinterface<dtoproducto> {

    private String sqlc = c + "producto (idproducto, nombre, cantidad, precio, descripcion, estado) VALUES (?, ?, ?, ?, ?, ?)";
    private String sqlr = r + " producto";
    private String sqlu = u + " producto SET nombre = ?, cantidad = ?, precio = ?, descripcion = ?, estado = ? WHERE idproducto = ?";
    private String sqld = d + "producto WHERE idproducto = ?";

    @Override
    public List<dtoproducto> listar() {
        List<dtoproducto> lista = new ArrayList<>();
        try (Connection conexion = entregador.getConexion(); PreparedStatement pez = conexion.prepareStatement(sqlr); ResultSet resultado = pez.executeQuery();) {
            while (resultado.next()) {
                producto p = new producto();
                p.setIdProducto(resultado.getString("idproducto"));
                p.setNombre(resultado.getString("nombre"));
                p.setCantidad(resultado.getInt("cantidad"));
                p.setPrecio(resultado.getDouble("precio"));
                p.setDescripcion(resultado.getString("descripcion"));
                p.setEstado(resultado.getInt("estado"));
                dtoproducto dtop = new dtoproducto(p);
                lista.add(dtop);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void creardato(dtoproducto base) {
        try (Connection conectar = entregador.getConexion(); PreparedStatement pez = conectar.prepareStatement(sqlc)) {
            pez.setString(1, base.getC().getIdProducto());
            pez.setString(2, base.getC().getNombre());
            pez.setInt(3, base.getC().getCantidad());
            pez.setDouble(4, base.getC().getPrecio());
            pez.setString(5, base.getC().getDescripcion());
            pez.setInt(6, base.getC().getEstado());

            pez.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    @Override
    public void actualizar(dtoproducto base) {
        try (Connection conectar = entregador.getConexion(); PreparedStatement pez = conectar.prepareStatement(sqlu)) {
            pez.setString(1, base.getC().getNombre());
            pez.setInt(2, base.getC().getCantidad());
            pez.setDouble(3, base.getC().getPrecio());
            pez.setString(4, base.getC().getDescripcion());
            pez.setInt(5, base.getC().getEstado());
            pez.setString(6, base.getC().getIdProducto());

            // Ejecutamos la actualización en la base de datos
            pez.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    @Override
    public void eliminar(dtoproducto base) {
        try (Connection conectar = entregador.getConexion(); PreparedStatement pez = conectar.prepareStatement(sqld)) {

            pez.setString(1, base.getC().getIdProducto());
            pez.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

}
