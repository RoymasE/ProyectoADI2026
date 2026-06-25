package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtocliente;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtofactura;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.cliente;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.factura;
import static com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.repository.rinterface.entregador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class rfactura implements rinterface<dtofactura> {

    private String sqlc = c + "factura (idventa, catidad, subtotal, fecha, correo, IVA, IRPF, idsecretario) "
            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private String sqlr = r + " factura";
    private String sqlu = u + "  factura "
            + "SET "
            + "    idventa = ?, "
            + "    catidad = ?, "
            + "    subtotal = ?,"
            + "    fecha = ?, "
            + "    correo = ?,"
            + "    IVA = ?,"
            + "    IRPF = ?,"
            + "    idsecretario = ?"
            + " WHERE idfactura = ?;";
    private String sqld = d + " factura "
            + " WHERE idfactura = ?";

    @Override
    public List<dtofactura> listar() {
        List<dtofactura> lista = new ArrayList<>();
        try (Connection conexion = entregador.getConexion(); PreparedStatement pez = conexion.prepareStatement(sqlr); ResultSet resultado = pez.executeQuery();) {
            while (resultado.next()) {
                factura f = new factura();
                f.setIdFactura(resultado.getInt("idfactura"));
                f.setIdVenta(resultado.getInt("idventa"));
                f.setCantidad(resultado.getInt("catidad")); // Usando "cantidad" corregido
                f.setSubTotal(resultado.getDouble("subtotal"));
                f.setFecha(resultado.getString("fecha"));
                f.setCorreo(resultado.getString("correo"));
                f.setIva(resultado.getDouble("IVA"));
                f.setIrpf(resultado.getDouble("IRPF"));
                f.setIdSecretario(resultado.getString("idsecretario"));

                dtofactura dtof = new dtofactura(f);
                lista.add(dtof);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return lista;

    }

    @Override
    public void creardato(dtofactura base) {
        try (Connection conectar = entregador.getConexion(); PreparedStatement pez = conectar.prepareStatement(sqlc)) {
            pez.setInt(1, base.getC().getIdVenta());
            pez.setInt(2, base.getC().getCantidad());
            pez.setDouble(3, base.getC().getSubTotal());
            pez.setString(4, base.getC().getFecha());
            pez.setString(5, base.getC().getCorreo());
            pez.setDouble(6, base.getC().getIva());
            pez.setDouble(7, base.getC().getIrpf());
            pez.setString(8, base.getC().getIdSecretario());

            // ¡IMPORTANTE! Te faltaba esta línea para que la consulta realmente se ejecute en la BD:
            pez.executeUpdate();

            System.out.println("Factura registrada con éxito.");

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    @Override
    public void actualizar(dtofactura base) {
        try (Connection conectar = entregador.getConexion(); PreparedStatement pez = conectar.prepareStatement(sqlu)) {
            pez.setInt(1, base.getC().getIdVenta());
            pez.setInt(2, base.getC().getCantidad());
            pez.setDouble(3, base.getC().getSubTotal());
            pez.setString(4, base.getC().getFecha());
            pez.setString(5, base.getC().getCorreo());
            pez.setDouble(6, base.getC().getIva());
            pez.setDouble(7, base.getC().getIrpf());
            pez.setString(8, base.getC().getIdSecretario());

            // El ID de la factura va al final (para el WHERE)
            pez.setInt(9, base.getC().getIdFactura());

            // Ejecutamos la actualización en la base de datos
            pez.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    @Override
    public void eliminar(dtofactura base) {
        try (Connection conectar = entregador.getConexion(); PreparedStatement pez = conectar.prepareStatement(sqld)) {

            pez.setInt(1, base.getC().getIdFactura());
            pez.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

}
