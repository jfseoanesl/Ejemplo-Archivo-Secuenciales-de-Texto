/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicesar.trescapas.persistencia;

import edu.unicesar.trescapas.entidades.Universidad;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jairo
 */
public class ASecuencialT implements IBaseDatos {
    private File archivo;
    private FileWriter escribir;
    private Scanner leer;

    public ASecuencialT(String name) {
        this.archivo = new File(name);
    }

    public ASecuencialT() {
        this("Universidades.dat");
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public FileWriter getEscribir() {
        return escribir;
    }

    public void setEscribir(FileWriter escribir) {
        this.escribir = escribir;
    }

    public Scanner getLeer() {
        return leer;
    }

    public void setLeer(Scanner leer) {
        this.leer = leer;
    }
    
         

    @Override
    public void add(Universidad u) {
       try{
            this.escribir = new FileWriter(this.archivo,true);
            PrintWriter pw = new PrintWriter(this.escribir);
            pw.println(u);
       }
       catch(IOException ioe){
          throw new NullPointerException("No fue posible adicionar el elemnto");
       }
       finally{
           try{
              if(this.escribir!=null)
                 this.escribir.close();
           }catch(IOException ioe){
             throw new NullPointerException("No fue posible cerrar el archivo de escritura"); 
           }   
       }
    }

    @Override
    public Universidad buscar(String id) {
       return null;
    }
    
    public Universidad leerDatos(String dato[]){
        String id = dato[0];
        String nombre = dato[1];
        String ciudad = dato[2];
        String categoria = dato[3];
        int sede = Integer.valueOf(dato[4]);
        int programas = Integer.valueOf(dato[5]);
        
        return new Universidad(id, nombre, ciudad, categoria, sede, programas);
    }

    @Override
    public List<Universidad> consultar() {
        List<Universidad> lista = new ArrayList();
        try{
            this.leer = new Scanner(this.archivo);
            while(this.leer.hasNext()){
                String datos[] = this.leer.nextLine().split(";");
                Universidad u = this.leerDatos(datos);
                lista.add(u);
            }
            return lista;
        }catch(FileNotFoundException fne){
            throw new NullPointerException("El archivo de lectura no existe"); 
        } 
        finally{
            if(this.leer!=null)
                this.leer.close();
        }
        
    }
    
    public void renombrarArchivo(File nvoArchivo) throws IOException{
        boolean error;
        if(!nvoArchivo.exists())
             nvoArchivo.createNewFile();
        
        if(this.archivo.delete())
            error = nvoArchivo.renameTo(archivo);
        else
           error = false;
        if(!error)
            throw new NullPointerException("Error al escribir el nuevo archivo");
    }

    @Override
    public Universidad eliminar(String id) {
       Universidad res = null;
       try{
            this.leer = new Scanner(this.archivo);
            ASecuencialT aTemp = new ASecuencialT("UniversidadesTmp.dat");
            while(this.leer.hasNext()){
              Universidad u = this.leerDatos(this.leer.nextLine().split(";"));
              if(u.getId().equalsIgnoreCase(id)){// eliminar
                  res = u;
              }
              else{
                  aTemp.add(u);
              }
            }
            this.leer.close();
            this.renombrarArchivo(aTemp.getArchivo());
            return res;
            
       }catch(FileNotFoundException fne){
           throw new NullPointerException("El archivo de lectura no existe"); 
       } 
       catch(IOException ioe){
           throw new NullPointerException("Error al actualizar el archivo"); 
       }
       catch(NullPointerException npe){
           throw npe;
       }
    }
    
}
