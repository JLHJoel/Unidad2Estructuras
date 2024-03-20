package ejer11;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner lector = new Scanner(System.in);
        Pila pila1 = new Pila();
        Pila pila2 = new Pila();
        Pila pila3 = new Pila();
        pila1.insertar(7);
        pila1.insertar(6);
        pila1.insertar(5);
        pila1.insertar(4);
        pila1.insertar(3);
        pila1.insertar(2);
        pila1.insertar(1);

        int mov = 0;
        
        int opcion=0;
        System.out.println("-------- \u001B[31mT\u001B[0m \u001B[32mO\u001B[0m \u001B[34mR\u001B[0m \u001B[33mR\u001B[0m \u001B[35mE\u001B[0m \u001B[37mS\u001B[0m  \u001B[33mD\u001B[0m \u001B[35mE\u001B[0m  \u001B[32mH\u001B[0m \u001B[34mA\u001B[0m \u001B[33mN\u001B[0m \u001B[35mO\u001B[0m \u001B[37mI\u001B[0m --------");
        System.out.println("\nTorres predeterminadas");
        mostrarTorres(pila1, pila2, pila3);
        //mostrar el final en cuantos movimientos lo resolvio
        //validar cuando ya termina
        do{
            System.out.println("\nElija una opcion para mover su ficha: ");
            System.out.println("1. Torre 1 a Torre 2");
            System.out.println("2. Torre 1 a Torre 3");
            System.out.println("3. Torre 2 a Torre 3");
            System.out.println("4. Torre 2 a Torre 1");
            System.out.println("5. Torre 3 a Torre 2");
            System.out.println("6. Torre 3 a Torre 1");
            System.out.println("7. Nuevo juego");
            System.out.println("8. Mostrar");
            System.out.println("9. Salir");
            System.out.println("Elige: ");
            opcion = lector.nextInt();
            lector.nextLine(); //truco


            switch(opcion){
                case 1: //sacar elemento torre 1, insertar en torre 2
                //mostrar las 3 torres
                mover(pila1, pila2);
                mostrarTorres(pila1, pila2, pila3);
                mov++; 
                break; 
                case 2:
                mover(pila1, pila3);
                mostrarTorres(pila1, pila2, pila3);
                mov++;
                break;
                case 3:
                mover(pila2, pila3);
                mostrarTorres(pila1, pila2, pila3);
                mov++;
                break;
                case 4:
                mover(pila2, pila1);
                mostrarTorres(pila1, pila2, pila3);
                mov++;
                break;
                case 5:
                mover(pila3, pila2);
                mostrarTorres(pila1, pila2, pila3);
                mov++;
                break;
                case 6:
                mover(pila3, pila1);
                mostrarTorres(pila1, pila2, pila3);
                mov++;
                break;
                case 7:
                mov = 0;
                pila1.reiniciar();
                pila2.reiniciar();
                pila3.reiniciar();
                pila1.insertar(7);
                pila1.insertar(6);
                pila1.insertar(5);
                pila1.insertar(4);
                pila1.insertar(3);
                pila1.insertar(2);
                pila1.insertar(1);
                break;
                case 8:
                mostrarTorres(pila1, pila2, pila3);
                break;
            }//fin switch
            //validar si ya gano
            if((pila1.inicio == null && pila2.inicio == null) || (pila3.inicio == null && pila1.inicio == null)){
                System.out.println("\n!Felicidades!, has ganado el juego. Realizaste un total de " + mov + " " + "movimientos\n");
                System.out.println("\nPara jugar de nuevo elija la opcion 7\n");
            }
        }while(opcion!=9);


    }//numeros de colores

    public static void mover(Pila origen, Pila destino){
        if(!origen.vacia()){
            if(destino.vacia() || origen.fin.elemento < destino.fin.elemento){
                destino.insertar(origen.fin.elemento);
                origen.eliminar();
            }
            else{
                System.out.println("El aro debe ser menor");
            }
        }
    }

    public static void mostrarTorres(Pila pila1, Pila pila2, Pila pila3){
        Pila temp =  new Pila();
        System.out.println("\nTORRE 1");
        if(pila1.vacia()){
            System.out.println("No hay elementos en la Torre 1");
        }
        else{
            pila1.mostrar(temp);
        }
        System.out.println("\nTORRE 2");
        if(pila2.vacia()){
            System.out.println("No hay elementos en la Torre 2");
        }
        else{
            pila2.mostrar(temp);
        }
        System.out.println("\nTORRE 3");
        if(pila3.vacia()){
            System.out.println("No hay elementos en la Torre 3");
        }
        else{
            pila3.mostrar(temp);
        }
    }
    
}
