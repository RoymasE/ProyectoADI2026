package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtosecretario;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoventa;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.secretario;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.venta;
import static com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository.rinterface.entregador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class rventa implements rinterface<dtoventa> {

    private String sqlc = c + "venta (idcliente, idproducto, subtotal, fechaventa, estado) VALUES (?, ?, ?, ?, ?)";
    private String sqlr = r + "venta";
    private String sqlu = u + "venta SET idcliente = ?, idproducto = ?, subtotal = ?, fechaventa = ?, estado = ? WHERE idventa = ?";
    private String sqld = d + "venta where idventa =?";

    @Override
    public List<dtoventa> listar() {
        List<dtoventa> lista = new ArrayList<>();
        try (Connection conexion = entregador.getConexion(); PreparedStatement pez = conexion.prepareStatement(sqlr); ResultSet resultado = pez.executeQuery();) {
            while (resultado.next()) {
                venta v = new venta();
                v.setIdVenta(resultado.getInt("idventa"));
                v.setIdCliente(resultado.getString("idcliente"));
                v.setIdProducto(resultado.getString("idproducto"));
                v.setValorAPagar(resultado.getDouble("subtotal"));
                v.setFechaVenta(resultado.getString("fechaventa"));
                v.setEstado(resultado.getInt("estado"));
                dtoventa dtov = new dtoventa(v);
                lista.add(dtov);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;

    }

    @Override
    public void creardato(dtoventa base) {
        try (Connection conectar = entregador.getConexion(); PreparedStatement pez = conectar.prepareStatement(sqlc)) {
            
            pez.setString(1, base.getC().getIdCliente());
            pez.setString(2, base.getC().getIdProducto());
            pez.setDouble(3, base.getC().getValorAPagar());
            pez.setString(4, base.getC().getFechaVenta());
            pez.setInt(5, base.getC().getEstado());
            pez.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    @Override
    public void actualizar(dtoventa base) {
        try (Connection conectar = entregador.getConexion(); PreparedStatement pez = conectar.prepareStatement(sqlu)) {
            pez.setString(1, base.getC().getIdCliente());
            pez.setString(2, base.getC().getIdProducto());
            pez.setDouble(3, base.getC().getValorAPagar());
            pez.setString(4, base.getC().getFechaVenta());
            pez.setInt(5, base.getC().getEstado());
            pez.setInt(6, base.getC().getIdVenta());

            pez.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    @Override
    public void eliminar(dtoventa base) {
        try (Connection conectar = entregador.getConexion(); PreparedStatement pez = conectar.prepareStatement(sqld)) {
            pez.setInt(1, base.getC().getIdVenta());

            pez.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

}
