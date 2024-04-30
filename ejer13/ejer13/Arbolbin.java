//Arbol balanceado, binario cada nodo tiene 2 hijos
//basado en lista doble
package ejer13;

public class Arbolbin {
    Nodo raiz; //inicio de la lista

    public Arbolbin(){
        raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public boolean vacia(){
        if(raiz == null){
            return true;
        }
        else{
            return false;
        }
    }

    public void eliminarArbol(){ //borrar todo el arbol
        raiz = null;
    }

    public void insertar(int elemento){
        Nodo nuevo = new Nodo(elemento);
        boolean direccion=true; //true es izquierda, false es derecha
        if(raiz==null){ //primer elemento
            raiz = nuevo;
        }
        else{
            Nodo aux = raiz;
            Nodo ant = null;
            while(aux!=null){
                ant = aux;
                if(elemento<aux.getElemento()){
                    aux = aux.izq;
                    direccion = true;
                }
                else{
                    aux = aux.der;
                    direccion = false;
                }
            }//fin while
            if(direccion){
                ant.izq = nuevo;
            }
            else{
                ant.der = nuevo;
            }
            //else a partir del 2 elemento
            
        }

    }

    public void mostrarPreOrden(Nodo aux){ 
        if(aux!=null){
            System.out.print(aux.getElemento() + " - ");
            mostrarPreOrden(aux.izq);
            mostrarPreOrden(aux.der);
        }

    }

    public void mostrarInOrden(Nodo aux){
        if(aux!=null){
            mostrarInOrden(aux.izq);
            System.out.print(aux.getElemento() + " - ");
            mostrarInOrden(aux.der);
        }

    }

    public void mostrarPostOrden(Nodo aux){
        if(aux!=null){
            mostrarPostOrden(aux.izq);
            mostrarPostOrden(aux.der);
            System.out.print(aux.getElemento() + " - ");
        }

    }
    //PreOrdenInvertido, recorre por la derecha
    public void mostrarPreOrdenInv(Nodo aux){
        if(aux!=null){
            mostrarPreOrdenInv(aux.der);
            mostrarPreOrdenInv(aux.izq);       
            System.out.print(aux.getElemento() + " - ");
        }

    }
    //muestra de forma mayor a menor
    public void mostrarInOrdenInv(Nodo aux){
        if(aux!=null){
            mostrarInOrden(aux.der);
            System.out.print(aux.getElemento() + " - ");
            mostrarInOrden(aux.izq);
        }

    }

    public void mostrarPostOrdenInv(Nodo aux){
        if(aux!=null){
            System.out.print(aux.getElemento() + " - ");
            mostrarPostOrden(aux.der);
            mostrarPostOrden(aux.izq);
        }

    }

    //buscar elemento (existe o no existe) y en que nivel
    public boolean buscar(int elemento){
        Nodo aux = raiz;
        int cont=0;

        while(aux!=null){
            if(elemento==aux.getElemento()){
                System.out.println("Comparaciones: " + cont++);
                return true;
            }
            else{
                cont++;
            if(elemento<aux.getElemento()){
                aux = aux.izq;
            }
            else{
                aux = aux.der;
            }
        }
        }//fin while
        System.out.println("Comparaciones: " + cont++);
        return false; //Cuando llega a un null y no esta el numero regresa false
              
    }

    public void eliminar(Nodo aux, int elemento, Nodo ant){
               
        if(elemento == aux.getElemento()){
            //entra cuando el elemento ya coincidio
            if(raiz.izq == null && raiz.der == null){ //caso 1 , raiz tiene 1 solo hijo
                eliminarArbol();
            }
            else{
                //caso 2 el nodo tiene hijos
                if(aux.izq==null && aux.der==null){
                    if(ant.izq!=null && elemento == ant.izq.getElemento()){
                        ant.izq = null;
                    }
                    else{
                        ant.der = null;
                    }
                }  

            }
        }
        //si no encuentro el elemento, debo bajar de arbol
        else{
            if(elemento<aux.getElemento()){
                eliminar(aux.izq, elemento, aux);
            }
            else{
                eliminar(aux.der, elemento, aux);
            }
        }

    }



}
