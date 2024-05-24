package ejer16;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArregloHash {
    ArrayList<LinkedList<String>> arreglo; //creamos un arraylist que contiene listas enlazadas, para almazenar los datos
    //y poder tener mas de un elemento por posicion
    int size;

    public ArregloHash(int size){
        this.size = size;
        arreglo = new ArrayList<>(size);
        //inicializar arreglo
        for(int i=0; i<size; i++){
            arreglo.add(new LinkedList<>()); //modificamos este constructor, en esta parte
            //inicializamos cada posicion del arreglo con una nueva lista enlazada vacia
        }
    }

    public void mostrar(){
        for(int i=0; i<arreglo.size(); i++){
            System.out.println("[" + i + "] =" + arreglo.get(i));
        }
    }

    // public void asignaHash(String dato){
    //     int pos;
    //     int sumaAscii=0;
    //     for(int x=0; x<dato.length(); x++){
    //         //sumaAscii += Math.pow(dato.codePointAt(x), x+1);
    //         //se empeoro, hay mas colisiones, 2a opcion
    //         sumaAscii += dato.codePointAt(x);
    //     }
    //     //pos = sumaAscii % size; //1a opcion
    //     pos = sumaAscii / 2; //3a opcion
    //     pos = pos % size;
        
    //     if(arreglo.get(pos).equals("vacio")){
    //         arreglo.set(pos, dato);
    //         System.out.println(dato + " asignado en pos " + pos);
    //     }
    //     else{
            
    //         while(!arreglo.get(pos).equals("vacio")){
    //             System.out.println("colision en posicion " + pos);
    //             pos++;
    //             if(pos==size){ //llegue al final del arreglo y no hay vacio
    //                 pos=0;
    //             }
                
    //         }
    //         arreglo.set(pos, dato);
    //         System.out.println(dato + " reasignado en " + pos);
    //     }
    // }

    public void asignaHash(String dato) {
        int pos;
        int sumaAscii = 0;
        for (int x = 0; x < dato.length(); x++) {
            //sumaAscii += Math.pow(dato.codePointAt(x), x+1);
            //se empeoro, hay mas colisiones, 2a opcion
            sumaAscii += dato.codePointAt(x);
        }

        //pos = sumaAscii % size; //1a opcion
        pos = (sumaAscii / 2); //3a opcion
        pos = pos % size;

        LinkedList<String> lista = arreglo.get(pos); //ahora cada posicion del arraylist lo convertimos en una lista enlazada, la cual
        //llamaremos lista

        if (lista.isEmpty()) { //si la lista esta vacia
            lista.add(dato);
            System.out.println(dato + " asignado en pos " + pos);
        } else { //si no esta vacia, y quiere agregar el elemento en dicha posicion
            System.out.println("colision en posicion " + pos + ", se agrega el elemento a la lista enlazada");
            lista.add(dato); //agregamos el elemento en la misma posicion, ya que es una lista enlazada
        }
    }
}
    
