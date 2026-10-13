# Mayor elemento de una matriz

## Objetivo

Encontrar el mayor valor de una matriz rectangular de enteros y rechazar las
matrices que no cumplen el formato requerido.

## Estructura de datos utilizada

Se utiliza un arreglo bidimensional `int[][]`, interpretado como una matriz de
`f` filas y `c` columnas. La matriz debe ser no nula, no vacia, tener filas no
nulas y no vacias, y conservar la misma cantidad de columnas en todas sus
filas. La eleccion de un arreglo bidimensional representa directamente la
organizacion fila-columna del problema y permite acceder a cada elemento por
sus indices.

## Estrategia

El maximo se inicializa con `matriz[0][0]`, no con cero, porque la matriz
puede contener solamente valores negativos. Luego se recorren todas las filas
y columnas con ciclos anidados, sin modificar ni ordenar la matriz.

Es necesario revisar todos los elementos porque cualquier posicion posterior
puede contener un valor mayor que el maximo encontrado hasta ese momento. Sin
recorrer una posicion no se puede descartar que contenga el resultado.

## Complejidad

Si la matriz tiene `f` filas y `c` columnas:

| Operacion | Complejidad temporal |
| --- | --- |
| Validar la matriz | `O(f)` |
| Encontrar el mayor | `O(f*c)` |

La complejidad total es `O(f*c)`, porque el recorrido inspecciona cada una de
las `f*c` posiciones; la validacion queda acotada por ese recorrido. El
espacio adicional es `O(1)`, porque solo se utilizan variables auxiliares
independientes del tamano de la matriz. El metodo no modifica la matriz de
entrada.

## Estructura de archivos

- `MayorMatriz.java`: contiene la validacion de la matriz, el algoritmo para
  encontrar el mayor elemento y un `main` con ejemplos y validaciones.

## Como compilar y ejecutar

Desde esta carpeta:

```text
javac MayorMatriz.java
java MayorMatriz
```

## Ejemplo de uso

Para una matriz como `{{3, 1}, {9, 4}}`, la llamada
`MayorMatriz.encontrarMayor(matriz)` devuelve `9`. El `main` incluye este caso
y muestra una linea `OK` para cada caso aceptado.

## Casos borde contemplados

- Valores positivos: devuelve el mayor valor encontrado.
- Valores negativos: devuelve el mayor negativo, gracias a la inicializacion
  con `matriz[0][0]`.
- Valores repetidos: acepta la matriz y devuelve ese valor si es el maximo.
- Un solo elemento: devuelve el unico valor.
- `Integer.MAX_VALUE`: lo reconoce como maximo sin desbordar.
- Matriz `null` o vacia: lanza `IllegalArgumentException`.
- Fila `null` o vacia: lanza `IllegalArgumentException`.
- Filas irregulares: lanza `IllegalArgumentException`.

## Decisiones de implementacion

- Inicializar el maximo con `matriz[0][0]` permite resolver correctamente
  matrices cuyos valores son todos negativos.
- Recorrer todas las filas y columnas es necesario porque cualquier posicion
  posterior puede contener un valor mayor; no se puede detener el algoritmo
  antes de revisar todos los elementos.
- Validar que la matriz sea rectangular permite recorrer cada fila con un
  limite de columnas comun y hace explicito el contrato de entrada.
- No se registraron comentarios `DECISION` en `MayorMatriz.java`; las
  decisiones anteriores se documentan a partir del comportamiento existente.

## Limitaciones y pendientes

- El metodo trabaja exclusivamente con valores `int` y devuelve un `int`.
- Solo acepta matrices rectangulares no vacias; no contempla matrices
  irregulares como entrada valida.
- No se indican pendientes en el informe del ejecutor.