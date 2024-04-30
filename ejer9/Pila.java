package ejer9;

public class Pila{
    public Nodo inicio;
    public Nodo fin;

    public Pila(){
        inicio=null;
        fin=null; //no debe tener insertar inicio, ni insertar en medio
    }
    public void insertar(String nombre){
        Nodo nuevo = new Nodo();
        Nodo aux = new Nodo();
        nuevo.elemento = nombre;
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
    public void mostrar(){
        if(vacia()==false){ //vacia igual a false, significa que hay personas, !vacia
        Nodo aux = new Nodo();
        aux = inicio;
        while(aux!=null)
        {
            System.out.println(aux.elemento);
            aux = aux.sig;
        }
    }
    }

    public void eliminar(){//pilas siempre borra el final
            Nodo aux = new Nodo();
            aux = inicio;
            while(aux.sig!=fin){
                aux = aux.sig;
            }
            fin = aux;
            aux = aux.sig;
            fin.sig = null;
    }


    public boolean vacia(){
        if(inicio==null){
            return true;
        }
        else{
            return false;
        }
    }
}