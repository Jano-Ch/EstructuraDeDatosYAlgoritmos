/**
 * Representa un trabajo que espera ser procesado por una impresora.
 */
public final class TrabajoImpresion {
    private final String nombreArchivo;
    private final int paginas;
    private final String usuario;

    /**
     * Crea un trabajo de impresión válido.
     *
     * @param nombreArchivo nombre del archivo a imprimir
     * @param paginas cantidad de páginas
     * @param usuario usuario que solicitó el trabajo
     * @throws IllegalArgumentException si el archivo o usuario están vacíos,
     *                                  o si las páginas no son positivas
     */
    public TrabajoImpresion(String nombreArchivo, int paginas, String usuario) {
        if (nombreArchivo == null || nombreArchivo.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del archivo no puede estar vacío.");
        }
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new IllegalArgumentException("El usuario no puede estar vacío.");
        }
        if (paginas <= 0) {
            throw new IllegalArgumentException("La cantidad de páginas debe ser mayor que cero.");
        }
        this.nombreArchivo = nombreArchivo;
        this.paginas = paginas;
        this.usuario = usuario;
    }

    /**
     * @return nombre del archivo
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * @return cantidad de páginas
     */
    public int getPaginas() {
        return paginas;
    }

    /**
     * @return usuario que solicitó el trabajo
     */
    public String getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return nombreArchivo + " (" + paginas + " páginas, usuario: " + usuario + ")";
    }
}
