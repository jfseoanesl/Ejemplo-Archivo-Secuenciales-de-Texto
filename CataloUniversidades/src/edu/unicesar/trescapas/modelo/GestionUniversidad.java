/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicesar.trescapas.modelo;

import edu.unicesar.trescapas.entidades.Universidad;
import edu.unicesar.trescapas.persistencia.*;
import java.util.List;

/**
 *
 * @author jairo
 */
public class GestionUniversidad {
    private IBaseDatos db;

    public GestionUniversidad() {
        //this.db = new ListaDeDatos();
        this.db = new ASecuencialT();
    }

    public IBaseDatos getDb() {
        return db;
    }

    public void setDb(IBaseDatos db) {
        this.db = db;
    }
    
    public void adicionar(Universidad u){
        this.db.add(u);
    }
    
    public Universidad eliminar(String id){
        return this.db.eliminar(id);
    }
    
    public List<Universidad> consultar(){
        return this.db.consultar();
    }
    
    public Universidad buscar(String id){
        return this.db.buscar(id);
    }
}
