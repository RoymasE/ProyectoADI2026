package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoproducto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoreguistro;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.producto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.reguistro;
import static com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository.rinterface.entregador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class rreguistro implements rinterface<dtoreguistro> {

    private String sqlc = c + "reguistro (idreguistro, idcliente, idsecretario) values (?,?,?)";
    private String sqlr = r + "reguistro";
    private String sqlu = u + "reguistro set idcliente= ?, idsecretario=? where idreguistro = ?";
    private String sqld = d + " reguistro where idreguistro= ?";

    @Override
    public List<dtoreguistro> listar() {
        List<dtoreguistro> lista = new ArrayList<>();
        try (Connection conexion = entregador.getConexion(); PreparedStatement pez = conexion.prepareStatement(sqlr); ResultSet resultado = pez.executeQuery();) {
            while (resultado.next()) {
                reguistro r = new reguistro();
                r.setIdRegistro(resultado.getString("idreguistro"));
                r.setIdCliente(resultado.getString("idcliente"));
                r.setIdSecretario(resultado.getString("idsecretario"));
                dtoreguistro dtor = new dtoreguistro(r);
                lista.add(dtor);

            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;

    }

    @Override
    public void creardato(dtoreguistro base) {
        try (Connection conectar = entregador.getConexion(); PreparedStatement pez = conectar.prepareStatement(sqlc)) {
            pez.setString(1, base.getC().getIdRegistro());
            pez.setString(2, base.getC().getIdCliente());
            pez.setString(3, base.getC().getIdSecretario());

            pez.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    @Override
    public void actualizar(dtoreguistro base) {
        try (Connection conectar = entregador.getConexion(); PreparedStatement pez = conectar.prepareStatement(sqlu)) {
            pez.setString(1, base.getC().getIdCliente());
            pez.setString(2, base.getC().getIdSecretario());
            pez.setString(3, base.getC().getIdRegistro());

            pez.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    @Override
    public void eliminar(dtoreguistro base) {
        try (Connection conectar = entregador.getConexion(); PreparedStatement pez = conectar.prepareStatement(sqld)) {

            pez.setString(1, base.getC().getIdRegistro());
            pez.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

}
