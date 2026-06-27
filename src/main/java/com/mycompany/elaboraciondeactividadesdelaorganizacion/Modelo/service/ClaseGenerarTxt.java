/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author x
 */
public class ClaseGenerarTxt {
    public void generarTxt(String idFactura, String contenido) {
       

        File carpeta = new File("facturas_txt");
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        File archivo = new File(carpeta, "factura_" + idFactura + ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(contenido);
     JOptionPane.showMessageDialog(
                null,
                "Archivo generado en:\n" + archivo.getAbsolutePath()
            );       
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(
                null,
                "Error al generar el archivo TXT:\n" + ex.getMessage()
            );
        }
    }
    
    
    
    
    
    
}
