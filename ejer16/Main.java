//tablas hash en lista
package ejer16;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner lector = new Scanner(System.in);
        String dato;
        int size;
        System.out.println("Tamano del arreglo");
        size = Integer.parseInt(lector.nextLine());

        ArregloHash grupo4to = new ArregloHash(size);
        grupo4to.mostrar();
        
        for(int i=0; i<size; i++){
            System.out.println("Nombre: ");
            dato = lector.nextLine();
            grupo4to.asignaHash(dato);
            grupo4to.mostrar();
        }


    }
}
