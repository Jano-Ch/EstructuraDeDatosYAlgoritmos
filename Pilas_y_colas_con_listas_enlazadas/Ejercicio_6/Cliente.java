/**
 * Representa a un cliente que espera atención bancaria.
 *
 * <p>Prompt inicial inventado: «Necesito una cola bancaria enlazada que
 * atienda a los clientes respetando el orden de llegada».</p>
 *
 * <p>Aclaración de la iteración posterior con ayuda del planificador:
 * la solución debe ser una cola propia FIFO, permitir turnos duplicados y
 * conservar el orden de llegada independientemente del número de turno.</p>
 */
public final class Cliente {
    private final String nombre;
    private final int numeroTurno;
    private final String motivo;

    /**
     * Crea un cliente validando sus datos básicos.
     *
     * @param nombre nombre del cliente; no puede estar vacío
     * @param numeroTurno número de turno; debe ser positivo
     * @param motivo motivo de la consulta; no puede estar vacío
     * @throws IllegalArgumentException si un texto está vacío o el turno no es positivo
     */
    public Cliente(String nombre, int numeroTurno, String motivo) {
        // DECISION: validar también referencias nulas en los textos — Motivo: una referencia nula equivale a un dato no ingresado y evita errores posteriores.
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (numeroTurno <= 0) {
            throw new IllegalArgumentException("El número de turno debe ser positivo.");
        }
        if (motivo == null || motivo.trim().isEmpty()) {
            throw new IllegalArgumentException("El motivo no puede estar vacío.");
        }
        this.nombre = nombre.trim();
        this.numeroTurno = numeroTurno;
        this.motivo = motivo.trim();
    }

    /**
     * @return nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return número de turno del cliente
     */
    public int getNumeroTurno() {
        return numeroTurno;
    }

    /**
     * @return motivo de la consulta
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @return representación legible del cliente
     */
    @Override
    public String toString() {
        return "Cliente{nombre='" + nombre + "', numeroTurno=" + numeroTurno
                + ", motivo='" + motivo + "'}";
    }
}
