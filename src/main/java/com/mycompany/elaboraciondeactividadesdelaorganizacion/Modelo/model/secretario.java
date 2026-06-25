package com.mycompany.elaboraciondeactividadesdelaorganizacion.Modelo.model;

public class secretario {

    private String idSecretario;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String direccion;
    private int estado;

    public secretario() {
    }

    public secretario(String idSecretario, String nombre, String apellido, String cedula, String telefono, String direccion, int estado) {
        this.idSecretario = idSecretario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }

    public String getIdSecretario() {
        return idSecretario;
    }

    public void setIdSecretario(String idSecretario) {
        this.idSecretario = idSecretario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
