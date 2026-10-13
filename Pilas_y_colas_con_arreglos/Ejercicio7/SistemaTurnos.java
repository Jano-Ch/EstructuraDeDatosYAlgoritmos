/*
 * Prompt inicial: implementar un sistema de turnos con una cola circular de
 * arreglo de capacidad fija. Debe permitir agregar personas con turnos
 * consecutivos desde 1, atender al siguiente y consultar el primero,
 * preservando FIFO y distinguiéndose de una pila LIFO.
 *
 * Refinamiento iterativo:
 * 1) Se definió la interfaz mínima: agregar, consultar y atender.
 * 2) Se agregó la representación circular con frente, cantidad y próxima
 *    posición de inserción, evitando desplazar elementos del arreglo.
 * 3) Se incorporaron validaciones de cola llena/vacía y una demostración
 *    ejecutable que prueba los casos normales y los límites.
 *
 * Complejidad y casos:
 * - agregar, consultar y atender son O(1); la memoria es O(capacidad).
 * - Se contemplan cola llena, cola vacía, nombres nulos o vacíos y el
 *   reciclado circular de posiciones.
 *
 * Prueba de ejecución con ejemplos:
 * - Se agregan Ana, Bruno y Carla; se consulta Ana y se atienden en ese orden.
 * - Luego se reutiliza una posición circular y se comprueba que Diego queda
 *   detrás de Carla.
 * - Finalmente se muestran los errores esperados al llenar y vaciar la cola.
 */

/**
 * Sistema de turnos FIFO implementado sobre un arreglo circular de capacidad
 * fija.
 *
 * <p>Una cola atiende al primero que llegó (FIFO, "first in, first out").
 * Una pila, en cambio, atiende al último que llegó (LIFO, "last in, first
 * out"); por eso este sistema no extrae el elemento desde el extremo de
 * inserción.</p>
 */
public class SistemaTurnos {
    // DECISION: representar a cada persona con su nombre y número entero de turno
    // — Motivo: el plan requiere turnos consecutivos y una demostración legible,
    // sin definir un modelo de persona más complejo.
    private final Turno[] turnos;
    private int frente;
    private int cantidad;
    private int proximaPosicion;
    private int proximoNumero = 1;

    /**
     * Crea un sistema de turnos con la capacidad indicada.
     *
     * @param capacidad cantidad máxima de personas en espera
     * @throws IllegalArgumentException si la capacidad no es positiva
     */
    public SistemaTurnos(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser positiva.");
        }
        turnos = new Turno[capacidad];
    }

    /**
     * Agrega una persona al final de la cola y le asigna el siguiente número.
     *
     * @param nombre nombre de la persona
     * @return el turno asignado
     * @throws IllegalStateException si la cola está llena
     * @throws IllegalArgumentException si el nombre es nulo o está vacío
     */
    public int agregarPersona(String nombre) {
        validarNombre(nombre);
        if (estaLlena()) {
            throw new IllegalStateException("No se puede agregar: la cola está llena.");
        }

        // DECISION: informar estados inválidos mediante excepciones estándar
        // — Motivo: permite que quien use la clase distinga claramente cola llena,
        // cola vacía y datos inválidos sin agregar dependencias.
        Turno turno = new Turno(proximoNumero, nombre);
        turnos[proximaPosicion] = turno;
        proximaPosicion = siguienteIndice(proximaPosicion);
        cantidad++;
        return proximoNumero++;
    }

    /**
     * Consulta la persona que será atendida primero sin quitarla de la cola.
     *
     * @return una descripción del primer turno
     * @throws IllegalStateException si no hay personas esperando
     */
    public String consultarPrimero() {
        verificarNoVacia();
        return turnos[frente].descripcion();
    }

    /**
     * Atiende y elimina la primera persona de la cola.
     *
     * @return una descripción del turno atendido
     * @throws IllegalStateException si no hay personas esperando
     */
    public String atenderSiguiente() {
        verificarNoVacia();
        Turno atendido = turnos[frente];
        turnos[frente] = null;
        frente = siguienteIndice(frente);
        cantidad--;
        return atendido.descripcion();
    }

    /**
     * Indica si no hay personas esperando.
     *
     * @return {@code true} cuando la cola está vacía
     */
    public boolean estaVacia() {
        return cantidad == 0;
    }

    /**
     * Indica si se alcanzó la capacidad máxima.
     *
     * @return {@code true} cuando no quedan posiciones disponibles
     */
    public boolean estaLlena() {
        return cantidad == turnos.length;
    }

    /**
     * Devuelve cuántas personas esperan actualmente.
     *
     * @return cantidad de personas en espera
     */
    public int cantidadEnEspera() {
        return cantidad;
    }

    private int siguienteIndice(int indice) {
        return (indice + 1) % turnos.length;
    }

    private void verificarNoVacia() {
        if (estaVacia()) {
            throw new IllegalStateException("No se puede realizar la operación: la cola está vacía.");
        }
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío.");
        }
    }

    private static final class Turno {
        private final int numero;
        private final String nombre;

        private Turno(int numero, String nombre) {
            this.numero = numero;
            this.nombre = nombre;
        }

        private String descripcion() {
            return "Turno " + numero + " - " + nombre;
        }
    }

    /**
     * Ejecuta una demostración de FIFO, consulta sin eliminación y límites.
     *
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        SistemaTurnos sistema = new SistemaTurnos(3);

        System.out.println("=== Demostración de turnos (FIFO, no LIFO) ===");
        sistema.agregarPersona("Ana");
        sistema.agregarPersona("Bruno");
        sistema.agregarPersona("Carla");
        System.out.println("Consulta: " + sistema.consultarPrimero());
        System.out.println("Consulta nuevamente: " + sistema.consultarPrimero());
        System.out.println("Atiende: " + sistema.atenderSiguiente());
        System.out.println("Atiende: " + sistema.atenderSiguiente());

        sistema.agregarPersona("Diego");
        System.out.println("Tras reutilizar el arreglo, atiende: " + sistema.atenderSiguiente());
        System.out.println("El siguiente conserva el orden: " + sistema.consultarPrimero());

        sistema.agregarPersona("Elena");
        sistema.agregarPersona("Fabio");
        try {
            sistema.agregarPersona("Gabriela");
        } catch (IllegalStateException exception) {
            System.out.println("Cola llena: " + exception.getMessage());
        }

        while (!sistema.estaVacia()) {
            System.out.println("Atiende: " + sistema.atenderSiguiente());
        }
        try {
            sistema.atenderSiguiente();
        } catch (IllegalStateException exception) {
            System.out.println("Cola vacía: " + exception.getMessage());
        }
    }
}
