package ejer13;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio 13 Arboles");
        Scanner lector = new Scanner(System.in);
        Arbolbin nums = new Arbolbin();
        Random aleatorio = new Random();
        System.out.println(nums.raiz.getElemento());
        int opcion = 0;
        int num = 0, total=0;;
        do{
            menu();
            opcion = Integer.parseInt(lector.nextLine());
            switch(opcion){
                case 1:
                System.out.println("num: ");
                num = Integer.parseInt(lector.nextLine());
                nums.insertar(num);
                break;
                case 2:
                if(nums.vacia()){
                    System.out.println("No hay elementos");
                }
                else{
                    System.out.println("PreOrden");
                    nums.mostrarPreOrden(nums.raiz);
                }
                break;
                case 3:
                if(nums.vacia()){
                    System.out.println("No hay elementos");
                }
                else{
                    System.out.println("InOrden");
                    nums.mostrarInOrden(nums.raiz);
                }
                break;
                case 4:
                if(nums.vacia()){
                    System.out.println("No hay elementos");
                }
                else{
                    System.out.println("PostOrden");
                    nums.mostrarPostOrden(nums.raiz);
                }
                break;
                case 5:
                if(nums.vacia()){
                    System.out.println("No hay elementos");
                }
                else{
                    System.out.println("PreOrden invertido");
                    nums.mostrarPreOrdenInv(nums.raiz);
                }
                break;
                case 6:
                System.out.println("Elemento: ");
                num = Integer.parseInt(lector.nextLine());
                System.out.println("Esta? " + nums.buscar(num));
                break;
                case 7:
                System.out.println("Cantidad elementos: ");
                total = Integer.parseInt(lector.nextLine());
                for(int i=1; i<=total;i++){
                    num = aleatorio.nextInt(250 + 1) + 1;
                    nums.insertar(num);
                }
                break;
                case 8:
                if(nums.vacia()){
                    System.out.println("No hay elementos");
                }
                else{ 
                System.out.println("num: ");
                num = Integer.parseInt(lector.nextLine());
                if(nums.buscar(num)==false){
                    System.out.println("No existe el numero");
                }
                else{ 
                nums.eliminar(nums.raiz, num, null);
                }
                }
                break;
            }
        }while(opcion!=9);

        
    }

    public static void menu(){
            System.out.println("Arboles binarios");
            System.out.println("Menu de opciones: ");
            System.out.println("1- Insertar");
            System.out.println("2- Mostrar PreOrden");
            System.out.println("3- Mostrar InOrden");
            System.out.println("4- Mostrar PostOrden");
            System.out.println("5- Mostrar Derechas");
            System.out.println("6- Buscar Elemento");
            System.out.println("7- Insertar Elementos Aleatorios");
            System.out.println("8- Eliminar Elemento");
            System.out.println("9- Salir");
            System.out.println("Ingrese una opcion: ");      
        }
    
}
