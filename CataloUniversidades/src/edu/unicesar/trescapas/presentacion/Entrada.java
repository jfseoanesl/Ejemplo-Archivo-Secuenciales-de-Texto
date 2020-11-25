/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicesar.trescapas.presentacion;

import java.util.Scanner;

/**
 *
 * @author jairo
 */
public class Entrada {
    private static Scanner entrada = new Scanner(System.in);
    
    public static int leerInt(String texto){
        boolean error;
        int valor=0;
        do{
            error = false;
            try{
                System.out.print(texto + ": ");
                valor = entrada.nextInt();

            }catch(java.util.InputMismatchException ime){
                System.out.println("Se requiere un valor entero");
                entrada.nextLine();
                error= true;
            }    
        }while(error); 
        return valor;
    }
    
    public static String leerString(String texto){
        System.out.print(texto + ": ");
        return entrada.next();
    }
}
