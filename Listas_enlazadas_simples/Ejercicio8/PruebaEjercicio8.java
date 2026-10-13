/**
 * Verificación manual ejecutable del Ejercicio 8.
 *
 * <p>Prompt inicial utilizado (prompt vago simulado): "Probar el ejercicio
 * 8".</p>
 *
 * <p>Iteración con agente planificador: se agregaron casos para lista vacía,
 * coincidencias repetidas, ausencia del dato y valor coincidente en los
 * extremos.</p>
 *
 * <p>Ajustes tras la primera respuesta de OpenCode: además de validar los
 * resultados, se vuelve a consultar la misma lista después de contar para
 * comprobar que la operación no modifica sus enlaces.</p>
 */
public final class PruebaEjercicio8 {

    private PruebaEjercicio8() {
    }

    /**
     * Ejecuta los casos normales y borde acordados.
     *
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        Ejercicio8 listaVacia = new Ejercicio8();
        verificar(listaVacia.contarOcurrencias(7) == 0,
                "una lista vacía devuelve cero");

        Ejercicio8 lista = new Ejercicio8();
        lista.agregarAlFinal(4);
        lista.agregarAlFinal(2);
        lista.agregarAlFinal(4);
        lista.agregarAlFinal(4);
        lista.agregarAlFinal(9);

        verificar(lista.contarOcurrencias(4) == 3,
                "cuenta todas las coincidencias");
        verificar(lista.contarOcurrencias(8) == 0,
                "un dato ausente devuelve cero");
        verificar(lista.contarOcurrencias(4) == 3,
                "la lista conserva sus enlaces después del recorrido");
        verificar(lista.contarOcurrencias(9) == 1,
                "cuenta una coincidencia al final");

        System.out.println("Pruebas del Ejercicio 8: OK");
    }

    private static void verificar(boolean condicion, String caso) {
        if (!condicion) {
            throw new AssertionError("Falló: " + caso);
        }
    }
}
