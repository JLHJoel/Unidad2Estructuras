package ejer14;

public class Main {
    public static void main(String[] args) {

        int[] arreglo = {80 ,50, 40, 20, 19, 16, 14, 8, 4, 3};
        //int[] arreglo = {14, 8, 3, 20, 40, 16, 19, 4, 50, 80};
        int cont = 0, intercambios = 0;

        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                cont += 1;
                if (arreglo[j] > arreglo[j + 1]) {
                    intercambios += 1;
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }

        System.out.println("Arreglo ordenado:");
        for (int elemento : arreglo) {
            System.out.print(elemento + " ");
    }
    System.out.println("\n\nContador: " + cont);
    System.out.println("Numero de intercambios: " + intercambios);

    }
    
}
