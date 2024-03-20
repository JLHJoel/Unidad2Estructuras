package ejer11;

public class Pila{
    public Nodo inicio;
    public Nodo fin;

    public Pila(){
        inicio=null;
        fin=null; //no debe tener insertar inicio, ni insertar en medio
    }
    public void insertar(int numero){
        Nodo nuevo = new Nodo();
        Nodo aux = new Nodo();
        nuevo.elemento = numero;
        nuevo.sig = null;
        if(inicio==null){ //primer elemento
            inicio = nuevo;
            fin = nuevo;
        }
        else{//metodo facil, a partir del segundo elemento
            //fin.sig = nuevo;
            //fin = nuevo;
            aux = inicio;
            while(aux.sig!=null){
                aux = aux.sig;
            }
            aux.sig = nuevo;
            fin = nuevo;
        }
    
    }
    public void mostrar(Pila temp){//mostrar el fin, copiar a una pila temporal
        //borrar el fin, hasta que no tenga elementos
        //regresar los elementos del temporal a la pila
        if(vacia()==false){ //vacia igual a false, significa que hay personas, !vacia
        while(inicio!=null){
            switch(fin.elemento){//switch para mostrar los numeros ya coloreados en la pila
                case 1:
                System.out.println("\u001B[31m" + fin.elemento + "\u001B[0m"); //color rojo
                break;
                case 2:
                System.out.println("\u001B[32m" + fin.elemento + "\u001B[0m"); //color verde
                break;
                case 3:
                System.out.println("\u001B[34m" + fin.elemento + "\u001B[0m"); //color azul
                break;
                case 4:
                System.out.println("\u001B[33m" + fin.elemento + "\u001B[0m"); //color amarillo
                break;
                case 5:
                System.out.println("\u001B[35m" + fin.elemento + "\u001B[0m"); //color magenta
                break;
                case 6:
                System.out.println("\u001B[37m" + fin.elemento + "\u001B[0m"); //color blanco
                break;
                case 7:
                System.out.println("\u001B[36m" + fin.elemento + "\u001B[0m"); //color cyan
                break;
                default:
                System.out.println(fin.elemento);
                break;
            }
            //System.out.println(fin.elemento);
            temp.insertar(fin.elemento);
            eliminar();

        }
        while(temp.inicio!=null){
            insertar(temp.fin.elemento);
            temp.eliminar();
        }
        
        // Nodo aux = new Nodo();
        // aux = inicio;
        // while(aux!=null)
        // {
        //     System.out.println(aux.elemento);
        //     aux = aux.sig;
        // }
    }
    }

    public void eliminar(){//pilas siempre borra el final
            Nodo aux = new Nodo();
            aux = inicio;
            if(inicio==fin){
                inicio = fin = null;
            }
            else{
                aux = inicio;
            while(aux.sig!=fin){
                aux = aux.sig;
            }
            fin = aux;
            aux = aux.sig;
            fin.sig = null;
        }
    }


    public boolean vacia(){
        if(inicio==null){
            return true;
        }
        else{
            return false;
        }
    }

    public void reiniciar(){
        inicio = fin = null;
    }
}