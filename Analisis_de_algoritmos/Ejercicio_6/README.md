# Comparar vectores

## Objetivo

Determinar si dos vectores de enteros son iguales. Para ser iguales deben
tener la misma longitud y el mismo valor en cada posicion correspondiente.

## Estructura de datos utilizada

Se utilizan dos arreglos (`int[]`) de longitud fija. La comparacion accede a
cada posicion correspondiente mediante su indice, sin insertar, eliminar ni
reordenar elementos. Esta estructura es adecuada porque el ejercicio necesita
comparar valores por posicion y permite acceder a cada elemento en tiempo
constante.

El metodo `sonIguales(int[] vector1, int[] vector2)` rechaza referencias
`null`, compara primero las longitudes y luego recorre las posiciones. Si
encuentra una diferencia, devuelve `false` inmediatamente. Si termina el
recorrido sin diferencias, devuelve `true`.

Los vectores vacios se aceptan y se consideran iguales entre si. Las entradas
no se modifican.

## Complejidad

Sea `n` la longitud de los vectores cuando tienen igual longitud:

| Operacion | Complejidad | Justificacion |
| --- | --- | --- |
| Comparar longitudes | O(1) | La longitud de cada arreglo se consulta directamente. |
| Mejor caso | O(1) | Las longitudes difieren o la primera posicion contiene una diferencia. |
| Peor caso | O(n) | Los vectores son iguales o la primera diferencia esta en la ultima posicion. |
| Caso promedio | O(n) | Bajo la hipotesis de que la primera diferencia puede aparecer en cualquier posicion con una distribucion que no concentra el corte al principio, se revisa una cantidad proporcional de posiciones en promedio. |
| Espacio adicional | O(1) | Solo se usa una variable de recorrido; no se crean estructuras proporcionales a `n`. |

La comparacion corta el recorrido en la primera diferencia, por lo que el
costo observado puede acercarse a O(1) cuando las diferencias suelen aparecer
al principio.

## Estructura de archivos

| Archivo | Responsabilidad |
| --- | --- |
| `CompararVectores.java` | Define `sonIguales` y un `main` con comprobaciones representativas del algoritmo. |
| `README.md` | Documenta el objetivo, el funcionamiento, la complejidad y el uso del ejercicio. |

## Como compilar y ejecutar

Desde la carpeta `Analisis_de_algoritmos/Ejercicio_6/`:

```text
javac CompararVectores.java
java CompararVectores
```

## Ejemplo de uso

Una llamada con vectores iguales devuelve `true`:

```java
boolean resultado = CompararVectores.sonIguales(
        new int[] {1, 2, 3}, new int[] {1, 2, 3});
```

Al ejecutar el `main` se muestra:

```text
Todas las comprobaciones fueron exitosas.
```

## Casos borde contemplados

| Caso | Comportamiento |
| --- | --- |
| Vectores iguales | Devuelve `true`. |
| Diferencia en la primera posicion | Devuelve `false` y corta inmediatamente. |
| Diferencia en la ultima posicion | Devuelve `false` despues de revisar las posiciones anteriores. |
| Longitudes distintas | Devuelve `false` sin recorrer posiciones. |
| Dos vectores vacios | Devuelve `true`. |
| Valores negativos y `Integer.MIN_VALUE`/`Integer.MAX_VALUE` | Los compara correctamente como valores `int`. |
| Alguna entrada `null` | Lanza `IllegalArgumentException`. |
| Vectores de entrada | Permanecen sin modificaciones. |

## Decisiones de implementacion

No hay comentarios `DECISION` en los archivos de este ejercicio. La
implementacion utiliza comparacion por longitud seguida de recorrido
secuencial con corte anticipado, tal como requiere el algoritmo documentado.

## Limitaciones y pendientes

- El programa no recibe vectores desde la entrada estandar: los casos estan
  definidos directamente en `main`.
- El metodo compara exclusivamente vectores de enteros (`int[]`); no ofrece
  una variante generica para otros tipos.