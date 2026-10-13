/*
 * Prompt inicial: implementar una Pila<T> con un arreglo de capacidad fija,
 * compatible con Integer, String y objetos simples, con operaciones LIFO,
 * controles de pila llena/vacía, explicación de genéricos y una demostración.
 *
 * La especificación vaga se ajustó iterativamente con el planificador hasta
 * definir capacidad explícita, errores documentados y los casos de prueba.
 */

import java.util.NoSuchElementException;

/**
 * Programa ejecutable que demuestra {@link Pila} con varios tipos y sus
 * controles de error.
 */
public class Ejercicio5 {

    /**
     * Objeto simple usado para comprobar que la pila no está limitada a
     * tipos primitivos o envoltorios numéricos.
     */
    private static final class Producto {
        private final String nombre;

        private Producto(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }

    /**
     * Ejecuta los casos normales y los casos límite de la pila.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        demostrarInteger();
        demostrarString();
        demostrarObjetoSimple();
        demostrarErrores();
    }

    private static void demostrarInteger() {
        Pila<Integer> pila = new Pila<>(3);
        pila.push(10);
        pila.push(20);
        pila.push(30);
        System.out.println("Integer (LIFO): " + pila.pop() + ", "
                + pila.pop() + ", " + pila.pop());
    }

    private static void demostrarString() {
        Pila<String> pila = new Pila<>(2);
        pila.push("primero");
        pila.push("segundo");
        System.out.println("String peek: " + pila.peek());
        System.out.println("String pop: " + pila.pop());
    }

    private static void demostrarObjetoSimple() {
        Pila<Producto> pila = new Pila<>(2);
        pila.push(new Producto("cuaderno"));
        pila.push(new Producto("lapicera"));
        System.out.println("Objeto simple pop: " + pila.pop());
    }

    private static void demostrarErrores() {
        Pila<Integer> llena = new Pila<>(1);
        llena.push(7);
        try {
            llena.push(8);
        } catch (IllegalStateException error) {
            System.out.println("Control de llena: " + error.getMessage());
        }

        Pila<Integer> vacia = new Pila<>(1);
        try {
            vacia.pop();
        } catch (NoSuchElementException error) {
            System.out.println("Control de vacía: " + error.getMessage());
        }
    }
}
