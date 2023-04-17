import java.util.Scanner;

public class ColaListaEnlazada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ColaEnlazada cola = new ColaEnlazada();
        int opcion;
        do {
            System.out.println("Cola con lista enlazada");
            System.out.println("1. Agregar elemento");
            System.out.println("2. Sacar elemento");
            System.out.println("3. Cola vacía");
            System.out.println("4. Cola llena");
            System.out.println("5. Ver elemento al frente de la cola");
            System.out.println("6. Borrar cola");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor a agregar: ");
                    Object valor = scanner.next();
                    cola.agregar(valor);
                    break;
                case 2:
                    Object valorSacado = cola.sacar();
                    if (valorSacado != null) {
                        System.out.println("Valor sacado: " + valorSacado);
                    }
                    break;
                case 3:
                    if (cola.estaVacia()) {
                        System.out.println("La cola está vacía");
                    } else {
                        System.out.println("La cola NO está vacía");
                    }
                    break;
                case 4:
                    System.out.println("La cola implementada con lista enlazada no puede estar llena");
                    break;
                case 5:
                    Object valorFrente = cola.frente();
                    if (valorFrente != null) {
                        System.out.println("Valor al frente de la cola: " + valorFrente);
                    }
                    break;
                case 6:
                    cola.borrarCola();
                    System.out.println("La cola ha sido borrada");
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

class ColaEnlazada {

    private Nodo primero;
    private Nodo ultimo;

    public ColaEnlazada() {
        primero = null;
        ultimo = null;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public void agregar(Object valor) {
        Nodo nuevo = new Nodo(valor);
        if (estaVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }

    public Object sacar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
            return null;
        } else {
            Object valor = primero.getValor();
            primero = primero.getSiguiente();
            if (primero == null) {
                ultimo = null;
            }
            return valor;
        }
    }

    public Object frente() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
            return null;
        } else {
            return primero.getValor();
        }
    }

    public void borrarCola() {
        primero = null;
        ultimo = null;
    }
}

class Nodo {

    private Object valor;
    private Nodo siguiente;

    public Nodo(Object valor) {
        this.valor = valor;
        siguiente = null;
    }

    public Object getValor() {
        return valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
