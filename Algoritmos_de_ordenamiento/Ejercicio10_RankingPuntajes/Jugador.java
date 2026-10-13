/**
 * Representa a un jugador y su puntaje obtenido.
 */
public class Jugador {
    private final String nombre;
    private final int puntaje;

    /**
     * Crea un jugador.
     *
     * @param nombre nombre del jugador
     * @param puntaje puntaje del jugador
     * @throws IllegalArgumentException si el nombre es nulo o está vacío
     */
    public Jugador(String nombre, int puntaje) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del jugador no puede estar vacío.");
        }
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el puntaje del jugador.
     *
     * @return puntaje del jugador
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * Devuelve una representación legible del jugador.
     *
     * @return nombre y puntaje del jugador
     */
    @Override
    public String toString() {
        return nombre + " - " + puntaje + " puntos";
    }
}
