import java.util.Objects;

/**
 * Representa un cliente que puede almacenarse en una {@link Cola}.
 */
public class Cliente {
    private final int id;
    private final String nombre;

    // DECISION: usar el paquete por defecto — Motivo: la carpeta del ejercicio estaba vacía y no definía paquetes.

    /**
     * Construye un cliente.
     *
     * @param id identificador del cliente
     * @param nombre nombre del cliente
     */
    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * @return identificador del cliente
     */
    public int getId() {
        return id;
    }

    /**
     * @return nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Compara clientes por identificador y nombre.
     *
     * @param objeto objeto a comparar
     * @return {@code true} si representa el mismo cliente
     */
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (!(objeto instanceof Cliente)) {
            return false;
        }
        Cliente otro = (Cliente) objeto;
        return id == otro.id && Objects.equals(nombre, otro.nombre);
    }

    /**
     * @return hash consistente con {@link #equals(Object)}
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    /**
     * @return representación legible del cliente
     */
    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nombre='" + nombre + "'}";
    }
}
