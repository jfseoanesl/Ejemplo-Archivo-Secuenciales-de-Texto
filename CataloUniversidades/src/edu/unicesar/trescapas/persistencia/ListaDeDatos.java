/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicesar.trescapas.persistencia;

import edu.unicesar.trescapas.entidades.Universidad;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jairo
 */
public class ListaDeDatos implements IBaseDatos {
    private List<Universidad> lista;

    public ListaDeDatos() {
        this.lista = new ArrayList();
    }

    public List<Universidad> getLista() {
        return lista;
    }

    public void setLista(List<Universidad> lista) {
        this.lista = lista;
    }

    @Override
    public void add(Universidad u)  {
        if(!this.lista.add(u)){
            throw new NullPointerException("No fue posible adicionarl el elemnto");
        }        
    }

    @Override
    public Universidad buscar(String id) {
        Universidad res=null;
        for(Universidad u: this.lista){
            if(u.getId().equalsIgnoreCase(id)){
                res = u;
                break;
            }
        }
        return res;
    }

    @Override
    public List<Universidad> consultar() {
        List<Universidad> aux = new ArrayList(this.getLista());
        return aux;
    }

    @Override
    public Universidad eliminar(String id) {
        Universidad u =  this.buscar(id);
        if(u!=null){
            int x = this.lista.indexOf(u);
            Universidad eliminado = this.lista.remove(x);
            return eliminado;
        }
        else{
            return u;
        }
    }
    
    
}
