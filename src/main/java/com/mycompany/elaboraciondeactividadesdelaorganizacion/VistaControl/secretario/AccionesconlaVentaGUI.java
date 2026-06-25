package com.mycompany.elaboraciondeactividadesdelaorganizacion.VistaControl.secretario;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.controller.interfasedeCargadeventa;
import static com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.controller.interfasedeCargadeventa.verventaobject;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.controller.interfaserealizarventa;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtocliente;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtofactura;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoproducto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoventa;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.Resoluciondecambios.BaseDeTransformacion;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.Resoluciondecambios.DeStringaInt;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.Resoluciondeproblemasmatematicos.ClaseMatematicabase;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.verfactura;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.verventa;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class AccionesconlaVentaGUI extends javax.swing.JFrame implements interfaserealizarventa, interfasedeCargadeventa {

    public AccionesconlaVentaGUI() {
        initComponents();
        tablaVentaMouseClicked();
        verventas();
        verfactura();
        verproducto();
        this.setSize(1300, 780);
        this.setLocationRelativeTo(null);

    }

    private javax.swing.JTable TablaCliente;
private javax.swing.JScrollPane jScrollPane7;
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
       
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaVenta = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaSecretario = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaProducto = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaFactura = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("IDCliente");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("IDproducto");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Cantidad");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Estado");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("IDSecretario");

        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setForeground(new java.awt.Color(0, 0, 0));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setForeground(new java.awt.Color(0, 0, 0));

        jTextField4.setForeground(new java.awt.Color(0, 0, 0));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setForeground(new java.awt.Color(0, 0, 0));

        TablaVenta.setBackground(new java.awt.Color(255, 255, 255));
        TablaVenta.setForeground(new java.awt.Color(0, 0, 0));
        TablaVenta.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"IDventa", "IDcliente", "IDproducto", "Valor a pagar", "Fecha de venta", "Estado"}
        ));
        jScrollPane1.setViewportView(TablaVenta);

        TablaSecretario.setBackground(new java.awt.Color(255, 255, 255));
        TablaSecretario.setForeground(new java.awt.Color(0, 0, 0));
        TablaSecretario.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"IDSecretario", "Nombre", "Apellido", "Cedula", "Telefono", "Direccion", "Estado"}
        ));
        jScrollPane2.setViewportView(TablaSecretario);

        TablaProducto.setBackground(new java.awt.Color(255, 255, 255));
        TablaProducto.setForeground(new java.awt.Color(0, 0, 0));
        TablaProducto.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"IDProducto", "Nombre", "Cantidad", "Precio", "Descripcion", "Estado"}
        ));
        jScrollPane3.setViewportView(TablaProducto);

        TablaFactura.setBackground(new java.awt.Color(255, 255, 255));
        TablaFactura.setForeground(new java.awt.Color(0, 0, 0));
        TablaFactura.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"IDFactura", "IDVenta", "Cantidad", "SubTotal", "Fecha", "Correo", "IVA", "IRPF", "IDSecretario"}
        ));

        jScrollPane4.setViewportView(TablaFactura);

        jToggleButton1.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setForeground(new java.awt.Color(0, 0, 0));
        jToggleButton1.setText("Crear");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jScrollPane7 = new javax.swing.JScrollPane();

TablaCliente = new javax.swing.JTable();

TablaCliente.setBackground(new java.awt.Color(255,255,255));
TablaCliente.setForeground(new java.awt.Color(0,0,0));

TablaCliente.setModel(
    new javax.swing.table.DefaultTableModel(
        new Object[][]{},
        new String[]{
            "IDCliente",
            "Nombre",
            "Apellido",
            "Cedula",
            "Telefono",
            "Direccion",
            "Estado"
        }
    )
);
        
        
        
        
        jToggleButton2.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setForeground(new java.awt.Color(0, 0, 0));
        jToggleButton2.setText("Actualizar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton3.setForeground(new java.awt.Color(0, 0, 0));
        jToggleButton3.setText("Limpiar");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton4.setForeground(new java.awt.Color(0, 0, 0));
        jToggleButton4.setText("Eliminar");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jToggleButton5.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton5.setForeground(new java.awt.Color(0, 0, 0));
        jToggleButton5.setText("Salir");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Mensaje -------->");

        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setRows(3);
        jTextArea1.setEditable(false);
        jScrollPane5.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, 80, 80, 80)
                                                .addGap(10)
                                                .addComponent(jTextField1, 200, 200, 200))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2, 80, 80, 80)
                                                .addGap(10)
                                                .addComponent(jTextField2, 200, 200, 200))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4, 80, 80, 80)
                                                .addGap(10)
                                                .addComponent(jTextField3, 200, 200, 200))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5, 80, 80, 80)
                                                .addGap(10)
                                                .addComponent(jTextField4, 200, 200, 200))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6, 80, 80, 80)
                                                .addGap(10)
                                                .addComponent(jTextField5, 200, 200, 200))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jToggleButton1)
                                                .addGap(10)
                                                .addComponent(jToggleButton2))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jToggleButton3)
                                                .addGap(10)
                                                .addComponent(jToggleButton4))
                                        .addComponent(jToggleButton5)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(10)
                                                .addComponent(jScrollPane5, 200, 200, 200)))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(20, 20, 20))
                .addComponent(jScrollPane7, 100, 100, 100)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jToggleButton1)
                                        .addComponent(jToggleButton2))
                                .addGap(10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jToggleButton3)
                                        .addComponent(jToggleButton4))
                                .addGap(10)
                                .addComponent(jToggleButton5)
                                .addGap(20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15)
                                .addComponent(jScrollPane1, 150, 150, 150)
                                .addGap(10)
                                .addComponent(jScrollPane2, 100, 100, 100)
                                .addGap(10)
                                .addComponent(jScrollPane3, 100, 100, 100)
                                .addGap(10)
                                .addComponent(jScrollPane4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(15))
        );

        jScrollPane6.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jScrollPane6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jScrollPane6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        crearventas();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        actualizarventa();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        eliminarventa();
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        MenuSecretarioGUI ms = new MenuSecretarioGUI();
        ms.setVisible(true);
        AccionesconlaVentaGUI.this.dispose();
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
    }//GEN-LAST:event_jTextField4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaFactura;
    private javax.swing.JTable TablaProducto;
    private javax.swing.JTable TablaSecretario;
    private javax.swing.JTable TablaVenta;
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    // End of variables declaration//GEN-END:variables

    public void tablaVentaMouseClicked() {
        TablaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = TablaVenta.getSelectedRow();
                if (fila >= 0) {
                    jTextField1.setText(TablaVenta.getValueAt(fila, 1).toString());
                    jTextField2.setText(TablaVenta.getValueAt(fila, 2).toString());
                    jTextField4.setText(TablaVenta.getValueAt(fila, 5).toString());
                }
            }
        });
    }

    @Override
    public void verventas() {
        DefaultTableModel modelo = (DefaultTableModel) TablaVenta.getModel();
        modelo.setRowCount(0);
        verventa vv = new verventa();
        List<dtoventa> lista = vv.Entrega();
        for (dtoventa dtov : lista) {
            modelo.addRow(new Object[]{
                dtov.getC().getIdVenta(),
                dtov.getC().getIdCliente(),
                dtov.getC().getIdProducto(),
                dtov.getC().getValorAPagar(),
                dtov.getC().getFechaVenta(),
                dtov.getC().getEstado()
            });
        }
        jTextArea1.setText("Tabla de ventas actualizada.");
    }

    @Override
    public void crearventas() {
        jTextArea1.setText("Función Crear: por implementar.");
    }

    @Override
    public void actualizarventa() {
        jTextArea1.setText("Función Actualizar: por implementar.");
    }

    @Override
    public void eliminarventa() {
        jTextArea1.setText("Función Eliminar: por implementar.");
    }

    public void verfactura() {
        TablaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                BaseDeTransformacion<String, Integer> cmd = new DeStringaInt();
                int fila = TablaVenta.getSelectedRow();
                int idventa = 0;
                if (fila >= 0) {
                    String idventas = TablaVenta.getValueAt(fila, 0).toString();
                    idventa = cmd.Tranformacion(idventas);

                }
                List<dtofactura> listafactura1 = verventaobject.EntregarComplementofactura();
                List<dtofactura> listafactura2 = verventaobject.buscarfactura(idventa, listafactura1);
                cargartablafactura(listafactura2);

            }
        });

    }

    public void cargartablafactura(List<dtofactura> lista2) {
        DefaultTableModel modelo = (DefaultTableModel) TablaFactura.getModel();
        modelo.setRowCount(0);

        verfactura vf = new verfactura();
        List<dtofactura> lista = lista2;

        for (dtofactura dtof : lista) {
            modelo.addRow(new Object[]{
                dtof.getC().getIdFactura(),
                dtof.getC().getIdVenta(),
                dtof.getC().getCantidad(),
                dtof.getC().getSubTotal(),
                dtof.getC().getFecha(),
                dtof.getC().getCorreo(),
                dtof.getC().getIva(),
                dtof.getC().getIrpf(),
                dtof.getC().getIdSecretario()
            });
        }
        jTextArea1.setText("Tabla de facturas actualizada.");

    }

    public void verproducto() {
        TablaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                BaseDeTransformacion<String, Integer> cmd = new DeStringaInt();
                int fila = TablaProducto.getSelectedRow();
                String idventa = "";
                if (fila >= 0) {
                    String idventas = TablaProducto.getValueAt(fila, 0).toString();
                    idventa = idventas;

                }
                List<dtoproducto> listafactura1 = verventaobject.EntregarComplementoproducto();
                List<dtoproducto> listafactura2 = verventaobject.buscarproducto(idventa, listafactura1);
                CargarTablaProducto(listafactura2);
            }
        });

    }

    public void versecretario() {
    }

    public void CargarTablaProducto(List<dtoproducto> lista2) {
        DefaultTableModel modelo = (DefaultTableModel) TablaProducto.getModel();
        modelo.setRowCount(0);

        verfactura vf = new verfactura();
        List<dtoproducto> lista = lista2;

        for (dtoproducto dtop : lista) {
            modelo.addRow(new Object[]{
                dtop.getC().getIdProducto(),
                dtop.getC().getNombre(),
                dtop.getC().getCantidad(),
                dtop.getC().getPrecio(),
                dtop.getC().getDescripcion(),
                dtop.getC().getEstado()
            }
            );
        }

        jTextArea1.setText(
                "Tabla de productos actualizada.");
    }

}
