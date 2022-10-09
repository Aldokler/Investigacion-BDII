/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author jeffr
 */
public class UsuariosProvincia {
    int cantidad;
    String nombreProvincia;

    public UsuariosProvincia() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public UsuariosProvincia(int cantidad, String nombreProvincia) {
        this.cantidad = cantidad;
        this.nombreProvincia = nombreProvincia;
    }
    
}
