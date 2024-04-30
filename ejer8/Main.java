//ejercicio 8 Colas
package ejer8;

import java.util.Scanner;

public class Main {
    public static void main (String [] args){
        Scanner lector = new Scanner (System.in);

        int opcion;
        // String nombre;
        Cola fila_Banco = new Cola();
    do{
        System.out.println("\nMenu");
        System.out.println("[1] Ingresar cliente");
        System.out.println("[2] Mostrar cliente");
        System.out.println("[3] Eliminar cliente");
        System.out.println("Ingrese opcion:");
        opcion = lector.nextInt();
        String nombre;
        switch(opcion){
            case 1: 
            lector.nextLine();
            System.out.println("Ingresa Cliente:");
            nombre = lector.nextLine();
            fila_Banco.insertar(nombre);
            break;
            case 2: 
                if(fila_Banco.vacia() == true){
                System.out.println("La cola está vacia.");
            }
            else{
                System.out.println("Personas en la cola:");
                fila_Banco.mostrar();
            }
            break;
            case 3: if(fila_Banco.vacia() != true){
                System.out.println("Elimiando a: " + fila_Banco.inicio.elemento);
                fila_Banco.eliminar();
            } 
            else{
                System.out.println("Cola vacia.");
            }
            break;
            case 4: break;
            default:
            System.out.println("\nIngrese una de las opciones.");
        }}while(opcion != 4);

    }
}
    
