# Ejercicio 10: Bubble Sort

## Objetivo

Ordenar ascendentemente un vector de enteros mediante Bubble Sort y devolver
metricas exactas del proceso: comparaciones entre elementos e intercambios
reales.

## Estructura de datos utilizada

Se utiliza un arreglo `int[]`. Bubble Sort compara elementos adyacentes y,
cuando el de la izquierda es mayor, los intercambia; asi, el mayor elemento
pendiente llega al final de cada pasada. El vector se modifica **in-place**,
por lo que no se necesita una estructura auxiliar proporcional al tamano de la
entrada.

## Algoritmo

Bubble Sort recorre el vector comparando elementos adyacentes. Si el elemento de la izquierda es mayor, los intercambia; de ese modo, el mayor elemento pendiente llega al final de cada pasada. La bandera `huboIntercambio` permite terminar antes cuando una pasada no modifica el vector.

El metodo `ordenar` recibe un `int[]`, lo ordena ascendentemente **in-place** y devuelve un objeto `ResultadoOrdenamiento` con las metricas del proceso.

## Metricas

- **Comparaciones:** cada evaluacion de la relacion entre dos elementos adyacentes.
- **Intercambios:** solo se cuenta un intercambio cuando dos elementos efectivamente cambian de posicion.
- No se cuentan asignaciones auxiliares ni comparaciones de indices.

## Complejidad

| Operacion | Mejor caso | Caso promedio | Peor caso | Espacio adicional |
|---|---:|---:|---:|---:|
| Ordenar el vector | `O(n)` | `O(n^2)` | `O(n^2)` | `O(1)` |

El mejor caso ocurre cuando el vector ya esta ordenado y la primera pasada no
realiza intercambios, activando la salida anticipada. En los casos promedio y
peor se realizan pasadas cuadraticas; el orden inverso es un ejemplo del peor
caso. El algoritmo usa solo variables auxiliares de tamano constante.

## Utilidad y mutacion

Bubble Sort sirve principalmente para fines didacticos porque su implementacion permite observar directamente comparaciones, intercambios y el efecto de una salida anticipada. Para conjuntos pequenos tambien puede ser suficiente por su simplicidad, aunque para entradas grandes existen algoritmos mas eficientes.

El ordenamiento muta el vector recibido y no devuelve una copia. `ResultadoOrdenamiento` conserva los contadores como `long` para reducir el riesgo de desbordamiento en vectores grandes sin cambiar la API solicitada.

## Estructura de archivos

- `BubbleSort.java`: contiene el algoritmo, el programa de demostracion, la
	clase `ResultadoOrdenamiento` y sus accesores de metricas.
- `README.md`: documenta el algoritmo, su complejidad, ejecucion y casos.

## Como compilar y ejecutar

Desde esta carpeta:

```text
javac -Xlint:all BubbleSort.java
java BubbleSort
```

## Ejemplo de uso

Una ejecucion del caso desordenado muestra la mutacion del vector y sus
metricas:

```text
Desordenado: entrada=[5, 1, 4, 2, 8]
	salida=[1, 2, 4, 5, 8], comparaciones=9, intercambios=4
```

## Casos borde contemplados

- Vector ya ordenado: termina mediante la salida anticipada tras la primera
	pasada.
- Vector en orden inverso: ejercita el peor caso de intercambios.
- Valores repetidos: se conservan y solo se intercambian elementos cuando el
	de la izquierda es estrictamente mayor.
- Negativos y extremos de `int`: se ordenan como enteros, incluyendo
	`Integer.MIN_VALUE` y `Integer.MAX_VALUE`.
- Un elemento: se acepta y no requiere comparaciones ni intercambios.
- `null`: se rechaza con `IllegalArgumentException`.
- Vector vacio: se rechaza con `IllegalArgumentException`.

El `main` ejecuta todos estos casos, junto con un vector desordenado general.

## Decisiones de implementacion

- **Usar contadores `long`** en `BubbleSort.java` (linea de decision marcada
	con `DECISION`): evita desbordamientos en vectores grandes sin cambiar la
	API solicitada.

El conteo de comparaciones, intercambios reales y la bandera de salida
anticipada se describen en las secciones de metricas y algoritmo porque forman
parte del comportamiento observable implementado.

## Limitaciones y pendientes

- El algoritmo esta pensado principalmente para fines didacticos y conjuntos
	pequenos; para entradas grandes conviene evaluar algoritmos mas eficientes.
- Solo admite vectores de `int` y rechaza vectores `null` o vacios.
- No se incluyen pruebas automatizadas independientes; la verificacion
	informada corresponde a los casos ejecutados por `main`.