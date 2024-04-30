//ejercicio 9 Pilas
package ejer9;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args){
        Scanner lector = new Scanner(System.in);
        int opcion=0;
        String nombre;
        Nodo cliente = new Nodo();
        Pila filaBanco = new Pila();
        do{
        
        System.out.println("Pilas con menu");
        System.out.println("Menu de opciones: ");
        System.out.println("1- Agregar nodo");
        System.out.println("2- Eliminar nodo");
        System.out.println("3- Mostrar lista");
        System.out.println("4- Salir");
        System.out.println("Ingrese una opcion: ");
        opcion = lector.nextInt();
        lector.nextLine();
        switch(opcion){
            case 1: 
            System.out.println("Cliente: ");
            nombre = lector.nextLine();
            filaBanco.insertar(nombre);
            break;
            case 2:
            if(filaBanco.vacia()!=true){
                System.out.println("Eliminando a " + filaBanco.inicio.elemento);
                filaBanco.eliminar();
            }
            else{
                System.out.println("Fila vacia");
            }
            break;
            case 3:
            if(filaBanco.vacia()==true){
                System.out.println("Fila vacia");
            }
            else{
                System.out.println("Personas en fila");
                filaBanco.mostrar();
            }
            break;
            
        }


        }while(opcion!=4);
        
    }
}
