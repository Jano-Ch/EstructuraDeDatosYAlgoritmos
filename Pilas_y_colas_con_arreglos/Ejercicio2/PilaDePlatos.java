/**
 * Prompt inicial: implementar un simulador de torre de platos usando una pila
 * basada en un arreglo de capacidad fija, con platos representados como
 * {@code String}, operaciones para agregar, retirar y consultar el superior,
 * y una demostración ejecutable.
 *
 * <p>Refinamiento iterativo de la especificación vaga: la idea de "torre de
 * platos" se convirtió en una pila con tope explícito; "agregar" significa
 * insertar en el tope, "retirar" y "consultar" siempre acceden al tope, y los
 * estados llena y vacía tienen errores explícitos. Se eligió {@code String}
 * para que el mismo simulador acepte números y nombres.</p>
 *
 * <p>Cada operación de acceso al tope tiene complejidad temporal O(1) y la
 * estructura usa O(capacidad) memoria. La capacidad no cambia durante la
 * ejecución.</p>
 */
public class PilaDePlatos {
    private final String[] platos;
    private int cantidad;

    /**
     * Crea una pila vacía con la capacidad indicada.
     *
     * @param capacidad cantidad máxima de platos
     * @throws IllegalArgumentException si la capacidad no es positiva
     */
    public PilaDePlatos(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser positiva.");
        }
        platos = new String[capacidad];
    }

    /**
     * Agrega un plato en la parte superior de la torre.
     *
     * @param plato número o nombre del plato
     * @throws IllegalStateException si la pila está llena
     * @throws IllegalArgumentException si el plato es {@code null}
     */
    public void agregar(String plato) {
        if (estaLlena()) {
            throw new IllegalStateException("No se puede agregar: la pila está llena.");
        }
        // DECISION: se rechazan platos null — Motivo: un plato debe tener una representación String identificable.
        if (plato == null) {
            throw new IllegalArgumentException("El plato no puede ser null.");
        }
        platos[cantidad] = plato;
        cantidad++;
    }

    /**
     * Retira y devuelve el plato que está en la parte superior.
     *
     * @return plato superior retirado
     * @throws IllegalStateException si la pila está vacía
     */
    public String retirarSuperior() {
        if (estaVacia()) {
            throw new IllegalStateException("No se puede retirar: la pila está vacía.");
        }
        cantidad--;
        String plato = platos[cantidad];
        platos[cantidad] = null;
        return plato;
    }

    /**
     * Consulta el plato superior sin retirarlo.
     *
     * @return plato que está en la parte superior
     * @throws IllegalStateException si la pila está vacía
     */
    public String consultarSuperior() {
        if (estaVacia()) {
            throw new IllegalStateException("No se puede consultar: la pila está vacía.");
        }
        return platos[cantidad - 1];
    }

    /**
     * Indica si no hay platos en la torre.
     *
     * @return {@code true} si está vacía
     */
    public boolean estaVacia() {
        return cantidad == 0;
    }

    /**
     * Indica si se alcanzó la capacidad fija.
     *
     * @return {@code true} si está llena
     */
    public boolean estaLlena() {
        return cantidad == platos.length;
    }

    /**
     * Devuelve la cantidad actual de platos.
     *
     * @return cantidad de platos almacenados
     */
    public int tamanio() {
        return cantidad;
    }

    /**
     * Devuelve la capacidad máxima de la pila.
     *
     * @return capacidad fija
     */
    public int capacidad() {
        return platos.length;
    }
}
