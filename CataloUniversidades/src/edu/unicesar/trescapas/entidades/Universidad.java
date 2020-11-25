/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicesar.trescapas.entidades;

/**
 *
 * @author jairo
 */
public class Universidad {
    private  String id;
    private String nombre, ciudad, categoria;
    private int nSedes, nProgramas;

    public Universidad(String id, String nombre, String ciudad, String categoria, int nSedes, int nProgramas) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.categoria = categoria;
        this.nSedes = nSedes;
        this.nProgramas = nProgramas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getnSedes() {
        return nSedes;
    }

    public void setnSedes(int nSedes) {
        this.nSedes = nSedes;
    }

    public int getnProgramas() {
        return nProgramas;
    }

    public void setnProgramas(int nProgramas) {
        this.nProgramas = nProgramas;
    }

    @Override
    public String toString() {
        return id + ";" + nombre + ";" + ciudad + ";" + categoria + ";" + nSedes + ";" + nProgramas ;
    }
    
    
}
