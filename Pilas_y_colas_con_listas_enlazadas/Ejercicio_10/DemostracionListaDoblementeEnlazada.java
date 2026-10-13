/**
 * Demostración ejecutable de la lista doblemente enlazada.
 *
 * <p>Recorre los casos normales y especiales definidos para el ejercicio.
 * Las verificaciones se realizan sin dependencias externas.</p>
 */
public class DemostracionListaDoblementeEnlazada {

    /**
     * Ejecuta una demostración de inserciones, impresiones y eliminaciones.
     *
     * @param args argumentos ignorados
     */
    public static void main(String[] args) {
        ListaDoblementeEnlazada<String> lista = new ListaDoblementeEnlazada<>();
        lista.imprimirAdelante();
        lista.imprimirAtras();
        comprobar(!lista.eliminarPrimeraCoincidencia("inexistente"),
                "no debe eliminar en una lista vacía");

        lista.insertarFinal(null);
        lista.insertarInicio("cabeza");
        lista.insertarFinal("cola");
        lista.insertarFinal("duplicado");
        lista.insertarFinal("duplicado");
        lista.imprimirAdelante();
        lista.imprimirAtras();

        comprobar(lista.eliminarPrimeraCoincidencia(null),
                "debe eliminar null");
        comprobar(lista.eliminarPrimeraCoincidencia("cabeza"),
                "debe eliminar la cabeza");
        comprobar(lista.eliminarPrimeraCoincidencia("duplicado"),
                "debe eliminar solo el primer duplicado");
        comprobar(lista.tamanio() == 2, "debe conservar los elementos restantes");
        comprobar(!lista.eliminarPrimeraCoincidencia("inexistente"),
                "no debe eliminar un valor inexistente");
        lista.imprimirAdelante();
        lista.imprimirAtras();

        comprobar(lista.eliminarPrimeraCoincidencia("cola"),
                "debe eliminar la cola");
        comprobar(lista.eliminarPrimeraCoincidencia("duplicado"),
                "debe eliminar el único elemento restante");
        comprobar(lista.estaVacia(), "la lista debe quedar vacía");
        comprobar(lista.tamanio() == 0, "el tamaño final debe ser cero");
        lista.imprimirAdelante();
        lista.imprimirAtras();
        System.out.println("Demostración completada correctamente.");
    }

    private static void comprobar(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new AssertionError(mensaje);
        }
    }
}
