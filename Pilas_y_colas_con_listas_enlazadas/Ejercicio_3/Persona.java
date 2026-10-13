/**
 * Objeto propio utilizado para demostrar que {@link Pila} funciona con tipos
 * definidos por el usuario.
 */
public final class Persona {
    private final String nombre;
    private final int edad;

    /**
     * Crea una persona para la demostración.
     *
     * @param nombre nombre de la persona
     * @param edad edad de la persona
     */
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Describe la persona para la salida de la demostración.
     *
     * @return representación textual de la persona
     */
    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }

    /**
     * Compara personas por sus datos.
     *
     * @param objeto objeto que se compara
     * @return {@code true} si nombre y edad coinciden
     */
    @Override
    public boolean equals(Object objeto) {
        if (!(objeto instanceof Persona)) {
            return false;
        }
        Persona otra = (Persona) objeto;
        return edad == otra.edad && nombre.equals(otra.nombre);
    }

    /**
     * Genera un hash coherente con {@link #equals(Object)}.
     *
     * @return hash de los datos de la persona
     */
    @Override
    public int hashCode() {
        return 31 * nombre.hashCode() + edad;
    }
}
