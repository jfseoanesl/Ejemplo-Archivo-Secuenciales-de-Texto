/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicesar.trescapas.presentacion;

import edu.unicesar.trescapas.entidades.Universidad;
import edu.unicesar.trescapas.modelo.GestionUniversidad;

/**
 *
 * @author jairo
 */
public class GuiConsola {
    
    private GestionUniversidad modelo;
    
    public GuiConsola() {
        this.modelo = new GestionUniversidad();
    }
    
    
    public void menuPpal(){
        
        int opc=0;
        do{
            System.out.println(" CATALOGO DE UNIVERSIDADES  ");
            System.out.println(" 1. Registrar   ");
            System.out.println(" 2. Buscar   ");
            System.out.println(" 3. Eliminar   ");
            System.out.println(" 4. Listar   ");
            System.out.println(" 5. Salir   ");
            
            opc = Entrada.leerInt("Selecione");
            switch(opc){
                case 1: this.vistaRegistra();break;
                case 2: this.vistaBuscar();break;
                case 3: this.vistaEliminar();break;
                case 4: this.vistaListar();break;
                case 5: System.out.println("Ha salido con exito");break;
                default: System.out.println("Opcion no valida, intente de nuevo");
            }
        }while(opc!=5);
        
    }
    
    public Universidad vistaCrearUiversidad(){
        String id = Entrada.leerString("Id");
        String nombre = Entrada.leerString("Nombre");
        String ciudad = Entrada.leerString("Ciudad");
        //------------------------
        String categoria;
        int cat;
        do{
            cat = Entrada.leerInt("Categoria[1-Publica][2->Privada]");
        }while(cat!=1 && cat !=2);    
        if(cat==1) categoria="Publica";
        else categoria = "Privada";
        //---------------------------
        int nSedes = Entrada.leerInt("No Sedes");
        int programas = Entrada.leerInt("Programas");
        return new Universidad(id, nombre, ciudad, categoria, nSedes, programas);
    }
    
    public void vistaRegistra(){    
        int continuar;
        do{
            System.out.println("1. REGISTRO DE UNIVERSIDAD ");
            Universidad u = this.vistaCrearUiversidad();
            try{
                this.modelo.adicionar(u);
                System.out.println("Registro exitoso");
            }catch(NullPointerException ne){
                System.out.println(ne);
            }    
            
            continuar = Entrada.leerInt("[1]->Registrar otro [!1]->Volver al menu");
        }while(continuar==1);     
    }
    
    public void imprimirU(Universidad u){
            System.out.println("Nombre: " + u.getNombre());
            System.out.println("Ciudad: " + u.getCiudad());
            System.out.println("Categoria: " + u.getCategoria());
            System.out.println("No Sedes: " + u.getnSedes());
            System.out.println("No Programas: " + u.getnProgramas());
    }
    
    public void vistaBuscar(){    
        System.out.println("2. BUSQUEDA DE UNIVERSIDAD ");
        String id = Entrada.leerString("Id a Buscar");
        Universidad u = this.modelo.buscar(id);
        if(u!=null){
            this.imprimirU(u);
        }
        else{
            System.out.println("EL id no se encuentra registrado");
        }
    }
    
    public void vistaEliminar(){    
        System.out.println("3.ELIMINACION DE UNIVERSIDAD ");
        try{
            String id = Entrada.leerString("Id a eliminar");
            Universidad u = this.modelo.eliminar(id);
            if(u!=null){
                System.out.println("Datos elemento eliminado: ");
                this.imprimirU(u);
            }
            else{
                System.out.println("EL id no se encuentra registrado");
            }
        }catch(NullPointerException npe){
            System.out.println(npe);
        }    
    
    }
    public void vistaListar(){    
        System.out.println("4.UNIVERSIDADES REGISTRADAS ");  
       
        try{
            System.out.print("\nId");
            System.out.print("\tNombre");
            System.out.print("\tCiudad");
            System.out.print("\tCategoria");
            System.out.print("\tNo Sedes");
            System.out.println("\t No Programas");

            for(Universidad u: this.modelo.consultar()){
                this.imprimirFila(u);
            }
        }catch(NullPointerException npe){
            System.out.println(npe);
        }    
    
    }
    
    public void imprimirFila(Universidad u){
            System.out.print("\t " + u.getId());
            System.out.print("\t " + u.getNombre());
            System.out.print("\t " + u.getCiudad());
            System.out.print("\t " + u.getCategoria());
            System.out.print("\t " + u.getnSedes());
            System.out.println("\t " + u.getnProgramas());
            
    }
    
    
}
