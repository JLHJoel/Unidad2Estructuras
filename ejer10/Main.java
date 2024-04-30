//ejercicio 10 Calculadora
package ejer10;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main{
    
    public static void main(String[] args){
        Scanner lector = new Scanner(System.in);
        int opcion=0;
        Pila operadores = new Pila();
        Pila numeros = new Pila();
        Pila temporal = new Pila();
        String expresion; 
        //validacion //positivos +-
        System.out.println("Ingresa Expresion:");
        expresion = lector.nextLine();
        System.out.println("Expresion ingresada: " + expresion); 
        
        //separar elementos
        String []expresionsep = expresion.split(" ");

        for (String expresionsep1 : expresionsep) {
            // Si la parte es un número, insertarlo en la pila de números
            if (!expresionsep1.matches("[-+*/=]")) { // Verifica si no es operador
                numeros.insertar(expresionsep1);
                temporal.insertar(expresionsep1);
            } else {
                // Si es un operador, insertarlo en la pila de operadores
                operadores.insertar(expresionsep1);
            }
        }

        //enviar a pilas numeros y operadores

        int resul = 0, num1, num2;
        String operador = "";
        while(operadores.inicio!=null){
            //sacar un operador y sacar 2 numeros
            num2 = Integer.parseInt(numeros.fin.elemento);
            numeros.eliminar();
            num1 = Integer.parseInt(numeros.fin.elemento);
            numeros.eliminar();
            operador = operadores.fin.elemento;
            operadores.eliminar();
            switch(operador){
                case "+": resul = num1 + num2;
                
                break;
                case "-": resul = num1 - num2;
                break;
                
                case "*": resul = num1 * num2;
                break;

                case "/": resul = num1 / num2;
                break;
                
            }//fin switch
            numeros.insertar(String.valueOf(resul));
        }//fin while
        System.out.println("Resultado: " + 2);
        numeros.eliminar();
        
        

        
    }
}
