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

public class rcliente implements rinterface<dtocliente> {

    private String sqlc = c + "cliente (idcliente, nombre, estado) "
            + "VALUES (?, ?, ?)";

    private String sqlr = r + " cliente";
    private String sqlu = u + " cliente "
            + "SET nombre = ?, estado = ? "
            + "WHERE idcliente = ?";
    private String sqld = d + " cliente "
            + "WHERE idcliente = ?";

    @Override
    public List<dtocliente> listar() {
        List<dtocliente> lista = new ArrayList<>();
        try (Connection conexion = entregador.getConexion(); PreparedStatement pez = conexion.prepareStatement(sqlr); ResultSet resultado = pez.executeQuery();) {
            while (resultado.next()) {
                cliente c = new cliente();
                c.setIdCliente(resultado.getString("idcliente"));
                c.setNombre(resultado.getString("nombre"));
                c.setEstado(resultado.getInt("estado"));
                dtocliente dtoc = new dtocliente(c);

                lista.add(dtoc);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public void creardato(dtocliente base) {
        try (Connection conectar = entregador.getConexion(); PreparedStatement pez = conectar.prepareStatement(sqlc)) {

            pez.setString(1, base.getC().getIdCliente());
            pez.setString(2, base.getC().getNombre());
            pez.setInt(3, base.getC().getEstado());
            pez.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    @Override
    public void actualizar(dtocliente base) {

        try (Connection conectar = entregador.getConexion(); PreparedStatement pez = conectar.prepareStatement(sqlu)) {
            pez.setString(1, base.getC().getNombre());
            pez.setInt(2, base.getC().getEstado());
            pez.setString(3, base.getC().getIdCliente());
            pez.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    @Override
    public void eliminar(dtocliente base) {

        try (Connection conectar = entregador.getConexion(); PreparedStatement pez = conectar.prepareStatement(sqld)) {

            pez.setString(1, base.getC().getIdCliente());
            pez.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

}
