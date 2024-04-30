package ejer12;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ptr = new Scanner(System.in);

        Baraja bj = new Baraja(); // Crea una nueva baraja
        Baraja user = new Baraja(); // Cartas del usuario
        Baraja casa = new Baraja(); // Cartas de la casa

        boolean terminar = false;
        iniciar(bj); // Barajeamos
        
        // bj.mostrar(); // Muestra la baraja
        
        tomarCarta(bj, user);
        // int carta1_user = bj.inicio.elemento;
        tomarCarta(bj, user);
        // int carta2_user = bj.inicio.elemento;
        System.out.println("\nCartas del Usuario:");
        user.mostrar();
        // comprobacion de suma 21
        if(cont21(user)){
             System.out.println("FIN DEL JUEGO");
             System.out.println("El Usuario ha ganado");
             terminar = true;
        }
        else{
            tomarCarta(bj, casa);
            // int carta1_casa = bj.inicio.elemento;
            tomarCarta(bj, casa);
            // int carta2_casa = bj.inicio.elemento;
            System.out.println("\nCartas de la Casa:");
            casa.mostrar();
            // comprobacion de suma 21
            if(cont21(user)){
                System.out.println("FIN DEL JUEGO");
                System.out.println("El Usuario ha ganado");
                terminar = true;
           }
           
        while(!terminar){ // Rondas
            char pedir = 'N';
            System.out.println("\u001B[37m \nPedir cartas por turnos.\u001B[0m"); 
            // Turno de Usuario
            do{
                System.out.println("\nUsuario, Quieres otra carta? S/N:");
                pedir = ptr.nextLine().toUpperCase().charAt(0);
                if(pedir == 'S'){
                    tomarCarta(bj, user);
                    user.mostrar();
                }
            }while(pedir == 'S');
            // Turno de Casa
            System.out.println("\nTurno de la Casa");
            while(casa.sumatoria() < 17){
                tomarCarta(bj, casa);
                System.out.println("\nCarta proporcionada");
                casa.mostrar();
            }
            terminar = true;
            }
        }
        ganador(casa, user); //Encuentra al ganador
        ptr.close();
    }

    public static void iniciar(Baraja bj){
        int[] a = new int[52];
        String denominacion = "", figura = "";
        String carta;
        barajear(a); // Barajea los números y guardarlos en el array a
        for (int elemento : a) {
            int cociente = (elemento-1)/13;
            switch(cociente){
                case 0: figura = "de Espadas "; break;
                case 1: figura = "de Trebol "; break;
                case 2: figura = "de Diamante "; break;
                case 3: figura = "de Corazon "; break;
            }
            int residuo = elemento % 13;
                switch(residuo){
                    case 1: denominacion = "As " + figura;  break;
                    case 11: denominacion = "J " + figura;   break;
                    case 12: denominacion = "Q " + figura;  break;
                    case 0: denominacion = "K " + figura;  break;
                    default: denominacion = String.valueOf(residuo) + " " + figura;    break;
                }
            if(residuo == 11 || residuo == 12 || residuo == 0){
                residuo = 10;
                // denominacion = String.valueOf(residuo) + " " + figura;
            }
            bj.insertar(residuo, denominacion); // Inserta cada número barajeado en la baraja
        }
    }

    public static void barajear(int[] a) {
        Random num = new Random();
        boolean[] usados = new boolean[a.length]; // Marca los números usados
        for (int i = 0; i < a.length; i++) {
            int aux;
            boolean igual;
            do {
                aux = num.nextInt(52) + 1 ; // Genera un número aleatorio entre 1 y 52
                // Verifica que el número no haya sido usado previamente
                igual = false;
                for (int j = 0; j < a.length; j++) {
                    if (a[j] == aux) {
                        igual = true;
                        break;
                    }
                }
            } while (igual); // Repite hasta encontrar un número no repetido
            a[i] = aux;
        }
    }

    public static boolean cont21(Baraja bj){
        if((bj.inicio.elemento == 1 && bj.inicio.sig.elemento == 10) || bj.inicio.elemento == 10 && bj.inicio.sig.elemento == 1){
            return true;
        }
        else{
            return false;
        }
    }

    public static void tomarCarta(Baraja bj, Baraja aux){
        aux.insertar(bj.inicio.elemento, bj.inicio.denominacion);
        bj.eliminarInicio();
    }

    public static void ganador(Baraja casa, Baraja user){
        if((casa.sumatoria() > user.sumatoria() & casa.sumatoria() <= 21) || casa.sumatoria() == 21){
            System.out.println("\nLa Casa ha ganado.");
        }
        else{
            if((user.sumatoria() > casa.sumatoria() & user.sumatoria() <= 21) || user.sumatoria() == 21){
                System.out.println("\nEl Usuario ha  ganado.");
            }
            else{
                System.out.println("\nNo hay ganador.");
            }
        }
    }
}
