# Ejercicio 8: Sumar elementos de una matriz

## Objetivo

Sumar todos los elementos de una matriz rectangular y devolver tanto la suma como la cantidad de elementos procesados.

## Estructura de datos utilizada

Se utiliza un arreglo bidimensional de enteros (`int[][]`). La matriz se interpreta como una colección de `f` filas con `c` columnas, donde todas las filas deben tener la misma longitud. El resultado se encapsula en `ResultadoSuma`, que almacena la suma y el contador como valores `long`.

## Recorrido y contador

`SumarElementosMatriz.sumar(int[][] matriz)` valida la matriz y luego la recorre con dos ciclos `for`:

1. El ciclo exterior visita cada fila.
2. El ciclo interior visita cada columna de la fila actual.
3. Cada elemento se agrega al acumulador `long` `suma`.
4. Por cada elemento procesado se incrementa `operaciones` una vez.

La definición exacta del contador es **una operación por cada elemento procesado por el ciclo interior**. Para una matriz de `f` filas y `c` columnas:

```text
operaciones = f * c
```

## Complejidad

| Operación | Complejidad |
|---|---|
| Sumar y contar elementos | `O(f * c)` |
| Espacio adicional | `O(1)` |

El tiempo es `O(f * c)` porque se visita cada elemento una vez. El espacio adicional es `O(1)`, sin contar el objeto `ResultadoSuma` devuelto.

## Estructura de archivos

- `SumarElementosMatriz.java`: valida la matriz, realiza el recorrido, calcula la suma y las operaciones, define `ResultadoSuma` y contiene ejemplos verificables en `main`.
- `README.md`: documenta el objetivo, el algoritmo, la complejidad, los casos y la ejecución.

## Cómo compilar y ejecutar

Desde la carpeta del repositorio:

```powershell
javac Analisis_de_algoritmos\Ejercicio_8\SumarElementosMatriz.java
java -cp Analisis_de_algoritmos\Ejercicio_8 SumarElementosMatriz
```

La ejecución correcta muestra:

```text
Todas las verificaciones de Ejercicio_8 fueron exitosas.
```

## Ejemplo de uso

Para la matriz `{{1, 2, 3}, {4, 5, 6}}`, la ejecución produce un `ResultadoSuma` con `getSuma() = 21` y `getOperaciones() = 6`.

## Casos borde contemplados

Antes del recorrido se valida que:

- Una matriz `null` provoca `IllegalArgumentException`.
- Una fila `null` provoca `IllegalArgumentException`.
- Una matriz irregular provoca `IllegalArgumentException`.
- Una matriz sin filas se acepta y produce suma `0` y `0` operaciones.
- Una matriz con filas de cero columnas se acepta y produce suma `0` y `0` operaciones.
- Los valores negativos se suman normalmente.
- Una suma grande se conserva mediante el acumulador `long`.

El método `main` verifica todos estos casos, además de una matriz rectangular con valores positivos.

## Decisiones de implementación

No se encontraron marcas `DECISION` en los archivos de este ejercicio. El comportamiento documentado se basa en la implementación existente y en las verificaciones informadas por el ejecutor.

## Limitaciones y pendientes

- El método requiere que la matriz sea rectangular; no procesa matrices irregulares.
- La suma se almacena en `long`, pero no se documenta ni se verifica un manejo especial del desbordamiento de `long`.
- No hay pendientes adicionales informados para este ejercicio.
