import java.util.Scanner;

public class ListaEnlazada {
    private Nodo cima;
    private int tamano;

    private class Nodo {
        private Object valor;
        private Nodo siguiente;

        public Nodo(Object valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    public ListaEnlazada() {
        this.cima = null;
        this.tamano = 0;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void agregar(Object valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
        tamano++;
    }

    public Object sacar() {
        if (estaVacia()) {
            return null;
        }
        Object valor = cima.valor;
        cima = cima.siguiente;
        tamano--;
        return valor;
    }

    public Object cima() {
        if (estaVacia()) {
            return null;
        }
        return cima.valor;
    }

    public void borrarPila() {
        cima = null;
        tamano = 0;
    }

    public static void main(String[] args) {
        ListaEnlazada pila = new ListaEnlazada();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
                System.out.println("Pila con lista enlazada");
            System.out.println("1. Agregar elemento");
            System.out.println("2. Sacar elemento");
            System.out.println("3. Verificar si la pila está vacía");
            System.out.println("4. Verificar si la pila está llena");
            System.out.println("5. Ver el elemento en la cima de la pila");
            System.out.println("6. Borrar pila");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor a agregar: ");
                    Object valorAgregar = scanner.next();
                    pila.agregar(valorAgregar);
                    System.out.println("Elemento agregado correctamente");
                    break;
                case 2:
                    Object valorSacar = pila.sacar();
                    if (valorSacar == null) {
                        System.out.println("La pila está vacía");
                    } else {
                        System.out.println("Elemento sacado de la pila: " + valorSacar);
                    }
                    break;
                case 3:
                    if (pila.estaVacia()) {
                        System.out.println("La pila está vacía");
                    } else {
                        System.out.println("La pila no está vacía");
                    }
                    break;
                case 4:
                    System.out.println("La pila no se puede llenar en una lista enlazada");
                    break;
                case 5:
                    Object valorCima = pila.cima();
                    if (valorCima == null) {
                        System.out.println("La pila está vacía");
                    } else {
                        System.out.println("El elemento en la cima de la pila es: " + valorCima);
                    }
                    break;
                case 6:
                    pila.borrarPila();
                    System.out.println("Pila borrada correctamente");
                    break;
                case 7:
                    System.out.println("Gracias por usar mi programa jaja");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 7);
    }
}

