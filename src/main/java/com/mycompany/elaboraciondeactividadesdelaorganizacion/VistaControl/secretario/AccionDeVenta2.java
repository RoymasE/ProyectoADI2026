package com.mycompany.elaboraciondeactividadesdelaorganizacion.VistaControl.secretario;

import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.controller.interfacedeeliminaciondeventa;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.controller.interfasecargadecomponentespredefinidosactualizarventa;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.controller.interfasecargadeventa;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.controller.interfasedeCargadeventa;
import static com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.controller.interfasedeCargadeventa.verventaobject;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.controller.interfasedeeliminarfactura;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.controller.interfaserealizarventa;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtocliente;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtofactura;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoproducto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtosecretario;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.dto.dtoventa;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.factura;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model.venta;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.ComplementosdeCompletado.Complementodeinterfaceivairpf;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.Resoluciondecambios.BaseDeTransformacion;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.Resoluciondecambios.DeStringaDouble;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.Resoluciondecambios.DeStringaInt;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.actualizarproducto;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.verfactura;
import com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service.verventa;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AccionDeVenta2 extends javax.swing.JFrame implements
        interfaserealizarventa,
        interfasedeCargadeventa,
        interfasecargadeventa,
        Complementodeinterfaceivairpf,
        interfasecargadecomponentespredefinidosactualizarventa,
        interfacedeeliminaciondeventa,
        interfasedeeliminarfactura {

    // ---------------------------------------------------------------
    // Variables de estado
    // ---------------------------------------------------------------
    private LocalDate fecha = LocalDate.now();
    private dtoventa ventadto = new dtoventa();
    private dtofactura facturadto = new dtofactura();
    private int catidad;
    private int idfacturageneral;
    private double preciofijo;

    // Listeners guardados para no acumularlos en cada llamada
    private java.awt.event.MouseAdapter listenerCliente = null;
    private java.awt.event.MouseAdapter listenerProducto = null;
    private java.awt.event.MouseAdapter listenerFactura  = null;

    // ---------------------------------------------------------------
    // Constructor
    // ---------------------------------------------------------------
    public AccionDeVenta2() {
        initComponents();
        registrarListeners();   // registra todos los listeners UNA sola vez
        cargarDatosIniciales(); // carga todas las tablas al abrir
    }

    // ---------------------------------------------------------------
    // Registro de listeners (se llama solo desde el constructor)
    // ---------------------------------------------------------------
    private void registrarListeners() {

        // --- TablaVenta: rellena inputs al hacer clic en una fila ---
        TablaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = TablaVenta.getSelectedRow();
                if (fila >= 0) {
                    InIDVenta.setText(TablaVenta.getValueAt(fila, 0).toString());
                    InIDCliente.setText(TablaVenta.getValueAt(fila, 1).toString());
                    InIDProducto.setText(TablaVenta.getValueAt(fila, 2).toString());
                    InEstado.setText(TablaVenta.getValueAt(fila, 5).toString());
                }
            }
        });

        // --- TablaVenta: filtra clientes por idCliente de la fila ---
        listenerCliente = new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = TablaVenta.getSelectedRow();
                if (fila >= 0) {
                    String idCliente = TablaVenta.getValueAt(fila, 1).toString();
                    List<dtocliente> lista1 = verventaobject.EntregarComplementocliente();
                    List<dtocliente> lista2 = verventaobject.buscarcliente(idCliente, lista1);
                    cargarcliente1(lista2);
                }
            }
        };
        TablaVenta.addMouseListener(listenerCliente);

        // --- TablaVenta: filtra productos por idProducto de la fila ---
        listenerProducto = new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = TablaVenta.getSelectedRow();
                if (fila >= 0) {
                    String idProducto = TablaVenta.getValueAt(fila, 2).toString();
                    List<dtoproducto> lista1 = verventaobject.EntregarComplementoproducto();
                    List<dtoproducto> lista2 = verventaobject.buscarproducto(idProducto, lista1);
                    CargarTablaProducto(lista2);
                }
            }
        };
        TablaVenta.addMouseListener(listenerProducto);

        // --- TablaVenta: filtra facturas por idVenta de la fila ---
        listenerFactura = new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = TablaVenta.getSelectedRow();
                if (fila >= 0) {
                    DeStringaInt di = new DeStringaInt();
                    int idVenta = di.Tranformacion(TablaVenta.getValueAt(fila, 0).toString());
                    List<dtofactura> lista1 = verventaobject.EntregarComplementofactura();
                    List<dtofactura> lista2 = verventaobject.buscarfactura(idVenta, lista1);
                    cargartablafactura(lista2);
                }
            }
        };
        TablaVenta.addMouseListener(listenerFactura);

        // --- TablaFactura: rellena Cantidad e IDSecretario al hacer clic ---
        TablaFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = TablaFactura.getSelectedRow();
                if (fila >= 0 && TablaFactura.getRowCount() > 0) {
                    InCantidad.setText(TablaFactura.getValueAt(fila, 2).toString());
                    InIDSecretario.setText(TablaFactura.getValueAt(fila, 8).toString());
                }
            }
        });

        // --- TablaFactura: muestra secretario al hacer clic ---
        TablaFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = TablaFactura.getSelectedRow();
                if (fila >= 0) {
                    String idsecretario = TablaFactura.getValueAt(fila, 8).toString();
                    List<dtosecretario> lista1 = verventaobject.EntregarComplementoSecretario();
                    List<dtosecretario> lista2 = verventaobject.buscarsecretario(idsecretario, lista1);
                    cargarsecretario1(lista2);
                }
            }
        });
    }

    // ---------------------------------------------------------------
    // Carga inicial de todas las tablas
    // ---------------------------------------------------------------
    private void cargarDatosIniciales() {
        verventas();
        cargarcliente1(verventaobject.EntregarComplementocliente());
        CargarTablaProducto(verventaobject.EntregarComplementoproducto());
        cargarsecretario1(verventaobject.EntregarComplementoSecretario());
    }

    // ---------------------------------------------------------------
    // Actualización general (después de crear / actualizar / eliminar)
    // ---------------------------------------------------------------
    public void granactualizacion() {
        verventas();
        cargarcliente1(verventaobject.EntregarComplementocliente());
        CargarTablaProducto(verventaobject.EntregarComplementoproducto());
        cargarsecretario1(verventaobject.EntregarComplementoSecretario());
    }

    // ---------------------------------------------------------------
    // initComponents generado por NetBeans (NO modificar)
    // ---------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Producto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        InIDCliente = new javax.swing.JTextField();
        InIDProducto = new javax.swing.JTextField();
        InCantidad = new javax.swing.JTextField();
        InEstado = new javax.swing.JTextField();
        InIDSecretario = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaVenta = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaCliente = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaSecretario = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablaProducto = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        TablaFactura = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        Mensaje = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        InIDVenta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 0));
        jScrollPane1.setForeground(new java.awt.Color(255, 153, 0));

        Producto.setBackground(new java.awt.Color(255, 153, 204));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("IDCliente");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("IDProducto");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cantidad");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Estado");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("IDSecretario");

        InEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InEstadoActionPerformed(evt);
            }
        });

        TablaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {{null,null,null,null},{null,null,null,null},{null,null,null,null},{null,null,null,null}},
            new String [] {"Title 1","Title 2","Title 3","Title 4"}
        ));
        jScrollPane3.setViewportView(TablaVenta);

        TablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {{null,null,null,null},{null,null,null,null},{null,null,null,null},{null,null,null,null}},
            new String [] {"Title 1","Title 2","Title 3","Title 4"}
        ));
        jScrollPane4.setViewportView(TablaCliente);

        TablaSecretario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {{null,null,null,null},{null,null,null,null},{null,null,null,null},{null,null,null,null}},
            new String [] {"Title 1","Title 2","Title 3","Title 4"}
        ));
        jScrollPane5.setViewportView(TablaSecretario);

        TablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {{null,null,null,null},{null,null,null,null},{null,null,null,null},{null,null,null,null}},
            new String [] {"Title 1","Title 2","Title 3","Title 4"}
        ));
        jScrollPane6.setViewportView(TablaProducto);

        TablaFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {{null,null,null,null},{null,null,null,null},{null,null,null,null},{null,null,null,null}},
            new String [] {"Title 1","Title 2","Title 3","Title 4"}
        ));
        jScrollPane7.setViewportView(TablaFactura);

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { jButton1ActionPerformed(evt); }
        });

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { jButton2ActionPerformed(evt); }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { jButton3ActionPerformed(evt); }
        });

        jButton4.setText("Limpiar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { jButton4ActionPerformed(evt); }
        });

        jButton5.setText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { jButton5ActionPerformed(evt); }
        });

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Mensaje++++>");

        Mensaje.setBackground(new java.awt.Color(255, 255, 255));
        Mensaje.setColumns(20);
        Mensaje.setForeground(new java.awt.Color(0, 0, 0));
        Mensaje.setRows(5);
        jScrollPane8.setViewportView(Mensaje);

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));  jLabel7.setText("IDVenta");
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));  jLabel8.setText("Venta");
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));  jLabel9.setText("Cliente");
        jLabel10.setText("jLabel10");
        jLabel11.setForeground(new java.awt.Color(0, 0, 0)); jLabel11.setText("Producto");
        jLabel12.setText("jLabel12");
        jLabel13.setForeground(new java.awt.Color(0, 0, 0)); jLabel13.setText("Secretario");
        jLabel14.setForeground(new java.awt.Color(0, 0, 0)); jLabel14.setText("Factura");
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel15.setForeground(new java.awt.Color(0, 0, 0)); jLabel15.setText("Acciones de venta");

        javax.swing.GroupLayout ProductoLayout = new javax.swing.GroupLayout(Producto);
        Producto.setLayout(ProductoLayout);
        ProductoLayout.setHorizontalGroup(
            ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductoLayout.createSequentialGroup()
                .addGap(25,25,25)
                .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductoLayout.createSequentialGroup()
                        .addComponent(jLabel6).addGap(61,61,61)
                        .addComponent(jScrollPane8,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79,79,79).addComponent(jLabel14).addContainerGap())
                    .addGroup(ProductoLayout.createSequentialGroup()
                        .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3).addComponent(jButton1)
                            .addComponent(jLabel5).addComponent(jLabel4).addComponent(jLabel3).addComponent(jLabel2)
                            .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7).addComponent(jLabel1)))
                        .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,ProductoLayout.createSequentialGroup()
                                .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,false)
                                    .addGroup(ProductoLayout.createSequentialGroup().addGap(12,12,12)
                                        .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(InIDCliente,javax.swing.GroupLayout.PREFERRED_SIZE,230,javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(InIDProducto,javax.swing.GroupLayout.PREFERRED_SIZE,217,javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(ProductoLayout.createSequentialGroup().addGap(18,18,18).addComponent(InIDVenta)))
                                .addGap(0,0,Short.MAX_VALUE))
                            .addGroup(ProductoLayout.createSequentialGroup()
                                .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ProductoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(InCantidad,javax.swing.GroupLayout.PREFERRED_SIZE,238,javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(ProductoLayout.createSequentialGroup()
                                                .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(InIDSecretario,javax.swing.GroupLayout.PREFERRED_SIZE,301,javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(InEstado,javax.swing.GroupLayout.PREFERRED_SIZE,269,javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(101,101,101)
                                                .addComponent(jScrollPane4,javax.swing.GroupLayout.DEFAULT_SIZE,634,Short.MAX_VALUE))))
                                    .addGroup(ProductoLayout.createSequentialGroup().addGap(144,144,144)
                                        .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton4).addComponent(jButton2))))
                                .addContainerGap()))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,ProductoLayout.createSequentialGroup()
                .addGap(143,143,143).addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,false)
                    .addComponent(jLabel13)
                    .addComponent(jScrollPane5,javax.swing.GroupLayout.DEFAULT_SIZE,610,Short.MAX_VALUE)
                    .addComponent(jScrollPane6).addComponent(jScrollPane7))
                .addGap(40,40,40))
            .addGroup(ProductoLayout.createSequentialGroup()
                .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,false)
                        .addGroup(ProductoLayout.createSequentialGroup().addGap(461,461,461)
                            .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9).addComponent(jLabel10)
                                .addGroup(ProductoLayout.createSequentialGroup().addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel12))))
                        .addGroup(ProductoLayout.createSequentialGroup().addContainerGap()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                            .addComponent(jLabel8)))
                    .addGroup(ProductoLayout.createSequentialGroup().addGap(529,529,529)
                        .addComponent(jScrollPane3,javax.swing.GroupLayout.PREFERRED_SIZE,401,javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE))
        );
        ProductoLayout.setVerticalGroup(
            ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductoLayout.createSequentialGroup()
                .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductoLayout.createSequentialGroup().addGap(27,27,27)
                        .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7).addComponent(InIDVenta,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18,18,18)
                        .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1).addComponent(InIDCliente,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29,29,29)
                        .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2).addComponent(InIDProducto,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27,27,27)
                        .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3).addComponent(InCantidad,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ProductoLayout.createSequentialGroup().addContainerGap()
                        .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8).addComponent(jLabel15))
                        .addGap(18,18,18)
                        .addComponent(jScrollPane3,javax.swing.GroupLayout.PREFERRED_SIZE,118,javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3,3,3).addComponent(jLabel9).addGap(14,14,14)
                .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductoLayout.createSequentialGroup()
                        .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4).addComponent(InEstado,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18,18,18)
                        .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5).addComponent(InIDSecretario,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4,javax.swing.GroupLayout.PREFERRED_SIZE,89,javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1,1,1)
                .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1).addComponent(jButton2).addComponent(jLabel11))
                .addGap(16,16,16)
                .addComponent(jScrollPane6,javax.swing.GroupLayout.PREFERRED_SIZE,60,javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3).addComponent(jButton4))
                .addGap(41,41,41)
                .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13).addComponent(jButton5))
                .addGap(18,18,18)
                .addComponent(jScrollPane5,javax.swing.GroupLayout.PREFERRED_SIZE,106,javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductoLayout.createSequentialGroup().addGap(18,18,18).addComponent(jLabel6))
                    .addGroup(ProductoLayout.createSequentialGroup().addGap(8,8,8)
                        .addComponent(jScrollPane8,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProductoLayout.createSequentialGroup().addGap(44,44,44).addComponent(jLabel14)
                        .addGap(18,18,18)
                        .addComponent(jScrollPane7,javax.swing.GroupLayout.PREFERRED_SIZE,167,javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(201,201,201)
                        .addGroup(ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10,javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12,javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(Producto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,642,Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,617,Short.MAX_VALUE));

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addGap(21,21,21)
                .addComponent(jScrollPane1,javax.swing.GroupLayout.PREFERRED_SIZE,1164,javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2,javax.swing.GroupLayout.PREFERRED_SIZE,574,javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addGap(21,21,21)
                .addComponent(jScrollPane2,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jScrollPane1,javax.swing.GroupLayout.PREFERRED_SIZE,989,javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pack();
    }
    // </editor-fold>

    // ---------------------------------------------------------------
    // Manejadores de botones
    // ---------------------------------------------------------------
    private void InEstadoActionPerformed(java.awt.event.ActionEvent evt) { }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { crearventas(); }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) { actualizarventa(); }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) { eliminarventa(); }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        InCantidad.setText("");
        InEstado.setText("");
        InIDCliente.setText("");
        InIDProducto.setText("");
        InIDSecretario.setText("");
        InIDVenta.setText("");
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        MenuSecretarioGUI ms = new MenuSecretarioGUI();
        ms.setVisible(true);
        AccionDeVenta2.this.dispose();
    }

    // ---------------------------------------------------------------
    // Implementación de interfaserealizarventa
    // ---------------------------------------------------------------
    @Override
    public void verventas() {
        DefaultTableModel modelo = (DefaultTableModel) TablaVenta.getModel();
        String[] columnas = {"ID Venta", "IDCliente", "IDProducto", "Valor a pagar", "FechaVenta", "Estado"};
        modelo.setColumnIdentifiers(columnas);
        modelo.setRowCount(0);
        verventa vv = new verventa();
        for (dtoventa dtov : vv.Entrega()) {
            modelo.addRow(new Object[]{
                dtov.getC().getIdVenta(),
                dtov.getC().getIdCliente(),
                dtov.getC().getIdProducto(),
                dtov.getC().getValorAPagar(),
                dtov.getC().getFechaVenta(),
                dtov.getC().getEstado()
            });
        }
        Mensaje.setText("Tabla de ventas actualizada.");
    }

    @Override
    public void crearventas() {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DeStringaInt di = new DeStringaInt();
        DeStringaDouble sd = new DeStringaDouble();

        venta v = new venta();
        v.setIdVenta(di.Tranformacion(InIDVenta.getText()));
        v.setIdCliente(InIDCliente.getText());
        v.setIdProducto(InIDProducto.getText());
        v.setValorAPagar(sd.Tranformacion(InCantidad.getText()) * preciofijo);
        v.setFechaVenta(this.fecha.format(formateador));
        v.setEstado(1);
        ventadto.setC(v);
        crearventaobjeto.regusitrar(ventadto);

        double total = sd.Tranformacion(InCantidad.getText()) * preciofijo;
        this.catidad = di.Tranformacion(InCantidad.getText());

        factura f = new factura();
        f.setIdVenta(di.Tranformacion(InIDVenta.getText()));
        f.setCantidad(di.Tranformacion(InCantidad.getText()));
        f.setSubTotal(total * IVA);
        f.setFecha(this.fecha.format(formateador));
        f.setCorreo("Null");
        f.setIva(IVA);
        f.setIrpf(IRPF);
        f.setIdSecretario(InIDSecretario.getText());
        facturadto.setC(f);
        crearfacturaobjeto.regusitrar(facturadto);

        Mensaje.setText("Venta y factura creadas correctamente.");
        actualizarcantidadproducto(catidad, v.getIdProducto());
        granactualizacion();
    }

    @Override
    public void actualizarventa() {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DeStringaInt di = new DeStringaInt();
        DeStringaDouble sd = new DeStringaDouble();

        venta v = new venta();
        v.setIdVenta(di.Tranformacion(InIDVenta.getText()));
        v.setIdCliente(InIDCliente.getText());
        v.setIdProducto(InIDProducto.getText());
        v.setValorAPagar(sd.Tranformacion(InCantidad.getText()) * preciofijo);
        v.setFechaVenta(this.fecha.format(formateador));
        v.setEstado(1);
        ventadto.setC(v);
        actualizarventaobject.actualizardato(ventadto);

        double total = sd.Tranformacion(InCantidad.getText()) * preciofijo;

        factura f = new factura();
        f.setIdFactura(idfacturageneral);
        f.setIdVenta(di.Tranformacion(InIDVenta.getText()));
        f.setCantidad(di.Tranformacion(InCantidad.getText()));
        f.setSubTotal(total * IVA);
        f.setFecha(this.fecha.format(formateador));
        f.setCorreo("Null");
        f.setIva(IVA);
        f.setIrpf(IRPF);
        f.setIdSecretario(InIDSecretario.getText());
        facturadto.setC(f);
        actualizarfacturaobject.actualizardato(facturadto);

        Mensaje.setText("Venta y factura actualizadas correctamente.");
        granactualizacion();
    }

    @Override
    public void eliminarventa() {
        DeStringaInt di = new DeStringaInt();

        // 1. Eliminar factura primero (FK)
        factura f = new factura();
        f.setIdFactura(idfacturageneral);
        facturadto.setC(f);
        eliminarfacturaobject.eliminardato(facturadto);

        // 2. Eliminar venta
        venta v = new venta();
        v.setIdVenta(di.Tranformacion(InIDVenta.getText()));
        ventadto.setC(v);
        eliminarventaobject.eliminardato(ventadto);

        Mensaje.setText("Venta y factura eliminadas correctamente.");
        granactualizacion();
    }

    // ---------------------------------------------------------------
    // Carga de tablas
    // ---------------------------------------------------------------
    public void cargartablafactura(List<dtofactura> lista) {
        DefaultTableModel modelo = (DefaultTableModel) TablaFactura.getModel();
        String[] columnas = {"idFactura","idVenta","cantidad","subTotal","fecha","correo","IVA","IRPF","idSecretario"};
        modelo.setColumnIdentifiers(columnas);
        modelo.setRowCount(0);
        for (dtofactura dtof : lista) {
            this.idfacturageneral = dtof.getC().getIdFactura();
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
    }

    public void CargarTablaProducto(List<dtoproducto> lista) {
        DefaultTableModel modelo = (DefaultTableModel) TablaProducto.getModel();
        String[] columnas = {"idProducto","Nombre","Cantidad","Precio","Descripcion","Estado"};
        modelo.setColumnIdentifiers(columnas);
        modelo.setRowCount(0);
        for (dtoproducto dtop : lista) {
            this.preciofijo = dtop.getC().getPrecio();
            modelo.addRow(new Object[]{
                dtop.getC().getIdProducto(),
                dtop.getC().getNombre(),
                dtop.getC().getCantidad(),
                dtop.getC().getPrecio(),
                dtop.getC().getDescripcion(),
                dtop.getC().getEstado()
            });
        }
    }

    @Override
    public void cargarcliente1(List<dtocliente> lista) {
        DefaultTableModel modelo = (DefaultTableModel) TablaCliente.getModel();
        String[] columnas = {"ID+Cliente","Nombre","Estado"};
        modelo.setColumnIdentifiers(columnas);
        modelo.setRowCount(0);
        for (dtocliente dtoc : lista) {
            modelo.addRow(new Object[]{
                dtoc.getC().getIdCliente(),
                dtoc.getC().getNombre(),
                dtoc.getC().getEstado()
            });
        }
    }

    @Override
    public void cargarsecretario1(List<dtosecretario> lista) {
        DefaultTableModel modelo = (DefaultTableModel) TablaSecretario.getModel();
        String[] columnas = {"ID+Secretario","Nombre","Apellido","Cedula","Telefono","Direccion","Estado"};
        modelo.setColumnIdentifiers(columnas);
        modelo.setRowCount(0);
        for (dtosecretario dtos : lista) {
            modelo.addRow(new Object[]{
                dtos.getC().getIdSecretario(),
                dtos.getC().getNombre(),
                dtos.getC().getApellido(),
                dtos.getC().getCedula(),
                dtos.getC().getTelefono(),
                dtos.getC().getDireccion(),
                dtos.getC().getEstado()
            });
        }
    }

    @Override
    public void cargarfactura1(List<dtofactura> lista) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void cargarventa1(List<dtoventa> lista) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void cargarproducto1(List<dtoproducto> lista) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // ---------------------------------------------------------------
    // Métodos auxiliares (vacíos — la lógica está en registrarListeners)
    // ---------------------------------------------------------------
    public void vercliente()   { /* listener registrado en registrarListeners() */ }
    public void verproducto()  { /* listener registrado en registrarListeners() */ }
    public void versecretario(){ /* listener registrado en registrarListeners() */ }
    public void verfactura()   { /* listener registrado en registrarListeners() */ }

    // ---------------------------------------------------------------
    // Actualiza cantidad del producto al crear una venta
    // ---------------------------------------------------------------
    public void actualizarcantidadproducto(int cantidad, String ID) {
        List<dtoproducto> lista1 = verventaobject.EntregarComplementoproducto();
        List<dtoproducto> lista2 = verventaobject.buscarproducto(ID, lista1);
        dtoproducto productoaactualizar = new dtoproducto();
        for (dtoproducto dtop : lista2) {
            dtop.getC().setCantidad(cantidad);
            productoaactualizar = dtop;
        }
        actualizarproducto actp = new actualizarproducto();
        actp.actualizardato(productoaactualizar);
    }

    // ---------------------------------------------------------------
    // Variables del formulario (generadas por NetBeans)
    // ---------------------------------------------------------------
    private javax.swing.JTextField InCantidad;
    private javax.swing.JTextField InEstado;
    private javax.swing.JTextField InIDCliente;
    private javax.swing.JTextField InIDProducto;
    private javax.swing.JTextField InIDSecretario;
    private javax.swing.JTextField InIDVenta;
    private javax.swing.JTextArea  Mensaje;
    private javax.swing.JPanel     Producto;
    private javax.swing.JTable     TablaCliente;
    private javax.swing.JTable     TablaFactura;
    private javax.swing.JTable     TablaProducto;
    private javax.swing.JTable     TablaSecretario;
    private javax.swing.JTable     TablaVenta;
    private javax.swing.JButton    jButton1, jButton2, jButton3, jButton4, jButton5;
    private javax.swing.JLabel     jLabel1, jLabel2, jLabel3, jLabel4, jLabel5,
                                   jLabel6, jLabel7, jLabel8, jLabel9, jLabel10,
                                   jLabel11, jLabel12, jLabel13, jLabel14, jLabel15;
    private javax.swing.JPanel     jPanel1;
    private javax.swing.JScrollPane jScrollPane1, jScrollPane2, jScrollPane3,
                                    jScrollPane4, jScrollPane5, jScrollPane6,
                                    jScrollPane7, jScrollPane8;
}