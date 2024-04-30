package ejer13;

public class Nodo {
    int elemento;
    Nodo izq;
    Nodo der;

    public Nodo(int elemento){
        this.elemento = elemento;
        this.izq = null;
        this.der = null;
    }

    public int getElemento() {
        return elemento;
    }

    
    
}
