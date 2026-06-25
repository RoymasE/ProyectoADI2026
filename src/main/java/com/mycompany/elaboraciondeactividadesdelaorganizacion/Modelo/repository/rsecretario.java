package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoreguistro;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtosecretario;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.reguistro;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.secretario;
import static com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository.rinterface.entregador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class rsecretario implements rinterface<dtosecretario> {

    private String sqlc = c + "secretario (idsecretario, nombre, apellido, cedula, telefono, direccion, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private String sqlr = r + "secretario";
    private String sqlu = u + "secretario SET nombre = ?, apellido = ?, cedula = ?, telefono = ?, direccion = ?, estado = ? WHERE idsecretario = ?";
    private String sqld = d + "secretario where idsecretario =?";

    @Override
    public List<dtosecretario> listar() {
        List<dtosecretario> lista = new ArrayList<>();
        try (Connection conexion = entregador.getConexion(); PreparedStatement pez = conexion.prepareStatement(sqlr); ResultSet resultado = pez.executeQuery();) {
            while (resultado.next()) {
                secretario s = new secretario();
                s.setIdSecretario(resultado.getString("idsecretario"));
                s.setNombre(resultado.getString("nombre"));
                s.setApellido(resultado.getString("apellido"));
                s.setCedula(resultado.getString("cedula"));
                s.setTelefono(resultado.getString("telefono"));
                s.setDireccion(resultado.getString("direccion"));
                s.setEstado(resultado.getInt("estado"));
                dtosecretario dtos = new dtosecretario(s);
                lista.add(dtos);

            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;

    }

    @Override
    public void creardato(dtosecretario base) {
        try (Connection conectar = entregador.getConexion(); PreparedStatement pez = conectar.prepareStatement(sqlc)) {
            pez.setString(1, base.getC().getIdSecretario());
            pez.setString(2, base.getC().getNombre());
            pez.setString(3, base.getC().getApellido());
            pez.setString(4, base.getC().getCedula());
            pez.setString(5, base.getC().getTelefono());
            pez.setString(6, base.getC().getDireccion());
            pez.setInt(7, base.getC().getEstado());

            pez.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    @Override
    public void actualizar(dtosecretario base) {
        try (Connection conectar = entregador.getConexion(); PreparedStatement pez = conectar.prepareStatement(sqlu)) {
            pez.setString(1, base.getC().getNombre());
            pez.setString(2, base.getC().getApellido());
            pez.setString(3, base.getC().getCedula());
            pez.setString(4, base.getC().getTelefono());
            pez.setString(5, base.getC().getDireccion());
            pez.setInt(6, base.getC().getEstado());
            pez.setString(7, base.getC().getIdSecretario());

            pez.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    @Override
    public void eliminar(dtosecretario base) {
        try (Connection conectar = entregador.getConexion(); PreparedStatement pez = conectar.prepareStatement(sqld)) {
            pez.setString(1, base.getC().getIdSecretario());

            pez.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

}
