/**
 * Demostración ejecutable de {@link PilaEnlazada}, incluidos sus casos
 * normales y los casos de pila vacía.
 */
public final class DemostracionPilaEnlazada {

    private DemostracionPilaEnlazada() {
        // Clase de demostración: no se instancia.
    }

    /**
     * Ejecuta una demostración breve de la API pública.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        PilaEnlazada pila = new PilaEnlazada();

        System.out.println("Vacia al comenzar: " + pila.estaVacia());
        System.out.println("Desapilar vacia: " + pila.desapilar());
        System.out.println("Tope de vacia: " + pila.tope());
        System.out.println("Buscar en vacia: " + pila.buscar(0));

        pila.apilar(-3);
        pila.apilar(0);
        pila.apilar(7);
        pila.apilar(7);

        System.out.println("Pila, del tope a la base:");
        pila.imprimir();
        System.out.println("Tope: " + pila.tope());
        System.out.println("Buscar 7: " + pila.buscar(7));
        System.out.println("Buscar 99: " + pila.buscar(99));

        System.out.println("Desapilado: " + pila.desapilar());
        System.out.println("Nuevo tope: " + pila.tope());
    }
}
