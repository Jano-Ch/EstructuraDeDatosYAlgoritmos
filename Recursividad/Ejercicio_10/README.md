# Ejercicio 10: Buscar un numero recursivamente

## Objetivo

Buscar un numero en un arreglo de enteros mediante recursion y devolver el indice de su primera aparicion.

## Estructura de datos utilizada

Se utiliza un arreglo (`int[]`) de enteros. La busqueda recorre sus posiciones en orden ascendente, comenzando en el indice `0`. La recursion recibe el indice actual como estado de la operacion.

## Funcionamiento

- La busqueda publica valida que el arreglo no sea `null` ni vacio y delega en la funcion recursiva con indice inicial `0`.
- La base de encontrado se alcanza cuando `vector[indice]` coincide con el numero buscado; se devuelve ese indice.
- La base de final se alcanza cuando el indice llega a `vector.length`; se devuelve `-1` porque no quedan elementos por revisar.
- Si el elemento actual no coincide, la llamada recursiva avanza al indice siguiente (`indice + 1`), por lo que el proceso no queda en ciclo.
- Cuando hay valores repetidos, se devuelve la primera coincidencia porque la recursion avanza en orden desde el indice `0`.

## Complejidad

| Operacion | Complejidad temporal | Complejidad espacial | Justificacion |
| --- | --- | --- | --- |
| Buscar un numero | `O(n)` en el peor caso | `O(n)` en el peor caso | Puede revisar las `n` posiciones y acumular hasta `n` llamadas en la pila recursiva. |

## Estructura de archivos

- `BuscarNumeroRecursivo.java`: contiene la clase publica, la validacion de entrada, la busqueda recursiva y las verificaciones ejecutables desde `main`.
- `README.md`: documenta el objetivo, el funcionamiento, la complejidad y la forma de ejecutar el ejercicio.

## Compilacion y ejecucion

Desde la carpeta `Recursividad/Ejercicio_10`:

```text
javac BuscarNumeroRecursivo.java
java BuscarNumeroRecursivo
```

## Ejemplo de uso

Una llamada como:

```java
BuscarNumeroRecursivo.buscar(new int[] {7, 2, 9, 4}, 4);
```

devuelve `3`, porque el numero `4` se encuentra en esa posicion.

Al ejecutar el programa de prueba con `java BuscarNumeroRecursivo`, la salida esperada es:

```text
Todas las validaciones fueron exitosas.
```

## Casos borde contemplados

- Coincidencia en la posicion inicial: devuelve `0`.
- Coincidencia en la posicion final: devuelve el ultimo indice.
- Numero inexistente: recorre todo el arreglo y devuelve `-1`.
- Valores repetidos: devuelve el indice de la primera coincidencia.
- Arreglo de un solo elemento: devuelve `0` si coincide o `-1` si no coincide.
- Arreglo `null` o vacio: lanza `IllegalArgumentException`.

## Pruebas incluidas

El metodo `main` verifica coincidencias inicial y final, numero inexistente, primera coincidencia entre repetidos, arreglos unitarios y las excepciones para arreglos `null` y vacios. Las comprobaciones fallan mediante `AssertionError` y, si todas pasan, se imprime el mensaje de exito indicado en el ejemplo.

## Decisiones de implementacion

No hay decisiones marcadas con `DECISION` en los archivos de este ejercicio.

<!-- DECISION: denominar esta sección solo como limitaciones — Motivo: no quedan tareas pendientes de integración en el ejercicio. -->
## Limitaciones

- La implementacion solo acepta arreglos de enteros (`int[]`) y busca una coincidencia exacta.
- La recursion consume memoria proporcional al numero de elementos revisados; para arreglos muy grandes, una implementacion iterativa evitaria el crecimiento de la pila.