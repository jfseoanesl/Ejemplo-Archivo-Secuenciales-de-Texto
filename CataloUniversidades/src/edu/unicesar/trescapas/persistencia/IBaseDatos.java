/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicesar.trescapas.persistencia;

import edu.unicesar.trescapas.entidades.Universidad;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author jairo
 */
public interface IBaseDatos {
    
    void add(Universidad u);
    Universidad buscar(String id);
    List<Universidad> consultar();
    Universidad eliminar(String id);
    
}
