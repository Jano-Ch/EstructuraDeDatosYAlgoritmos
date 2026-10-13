/*
 * Prompt inicial: implementar una cola de impresión FIFO con un arreglo de
 * capacidad fija; cada documento debe conservar su nombre y cantidad de
 * páginas, y una demostración debe encolarlos e imprimirlos en orden de llegada.
 *
 * Refinamiento iterativo:
 * 1) Se modeló cada documento como un objeto inmutable.
 * 2) Se agregó una cola circular para reutilizar las posiciones del arreglo
 *    luego de imprimir documentos.
 * 3) Se incorporaron validaciones de datos, mensajes de error y una demostración
 *    fija que permite comprobar el orden y los casos límite.
 *
 * Complejidad y casos:
 * - Crear un documento, encolar y desencolar/imprimir son operaciones O(1).
 * - La memoria utilizada por la cola es O(capacidad).
 * - Se contemplan cola vacía, cola llena, nombre vacío y páginas no positivas.
 *
 * Prueba de ejecución esperada:
 *   Encolar informe.pdf, diapositivas.pptx y resumen.txt produce las salidas
 *   en ese mismo orden, aunque el arreglo se implemente de forma circular.
 *
 * DECISION: Se usa el directorio solicitado "Ejercicio8", aunque la carpeta
 * vecina existente sigue la convención "Ejercicio_8" — Motivo: no modificar
 * ni incorporar archivos en otra carpeta.
 * DECISION: La demostración usa un flujo fijo sin menú — Motivo: el plan lo
 * considera preferente y permite reproducir automáticamente las pruebas FIFO.
 */

/**
 * Representa un documento que puede enviarse a la cola de impresión.
 */
public final class Documento {
    private final String nombre;
    private final int cantidadPaginas;

    /**
     * Crea un documento con nombre y cantidad de páginas válidos.
     *
     * @param nombre nombre del archivo
     * @param cantidadPaginas cantidad de páginas a imprimir
     * @throws IllegalArgumentException si el nombre está vacío o las páginas
     *                                  no son positivas
     */
    public Documento(String nombre, int cantidadPaginas) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del documento no puede estar vacío.");
        }
        if (cantidadPaginas <= 0) {
            throw new IllegalArgumentException("La cantidad de páginas debe ser positiva.");
        }
        this.nombre = nombre;
        this.cantidadPaginas = cantidadPaginas;
    }

    /**
     * Obtiene el nombre del documento.
     *
     * @return nombre del documento
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la cantidad de páginas del documento.
     *
     * @return cantidad de páginas
     */
    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    /**
     * Devuelve una descripción legible del documento.
     *
     * @return nombre y páginas del documento
     */
    @Override
    public String toString() {
        return nombre + " (" + cantidadPaginas + " páginas)";
    }
}
