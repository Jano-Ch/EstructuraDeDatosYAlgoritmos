# Ejercicio 2: busqueda en un vector desordenado

## Objetivo

Buscar un elemento dentro de un vector de numeros enteros sin modificar el
vector original e informar si fue encontrado, su indice y cuantas posiciones
fueron examinadas.

## Estrategias posibles

- **Busqueda lineal iterativa:** recorre el vector desde el principio y
  compara cada elemento con el buscado. Puede detenerse al encontrar la
  primera coincidencia. Tiene complejidad temporal `O(1)` en el mejor caso y
  `O(n)` en el peor y promedio, con espacio adicional `O(1)`.
- **Busqueda lineal recursiva:** comprueba una posicion y continua con una
  llamada recursiva. Tiene complejidad temporal `O(n)`, pero utiliza `O(n)` de
  espacio por la pila de llamadas.
- **Ordenamiento y busqueda binaria:** ordena el vector y luego busca en
  `O(log n)`. El ordenamiento agrega `O(n log n)` de tiempo y puede modificar
  el vector o requerir una copia, por lo que no resulta conveniente para una
  unica busqueda.
- **Estructura auxiliar como `HashSet`:** construirla cuesta `O(n)` y la
  busqueda promedio cuesta `O(1)`, pero requiere `O(n)` de espacio y no
  permite contar las posiciones originales examinadas durante la busqueda.

## Estrategia elegida

Se utiliza una busqueda lineal iterativa. Como el vector esta desordenado, no
se puede descartar ninguna posicion basandose en el valor de un elemento. La
busqueda lineal es adecuada porque:

- no necesita ordenar ni copiar el vector;
- finaliza inmediatamente al encontrar la primera coincidencia;
- utiliza memoria adicional constante;
- permite contar directamente las posiciones examinadas.

Cuando hay elementos repetidos, el algoritmo devuelve la primera aparicion.
Las posiciones recorridas se cuentan desde `1`: si se revisa el indice `0`, se
ha examinado una posicion.

## Analisis de complejidad

Sea `n` la cantidad de elementos del vector:

| Caso | Situacion | Posiciones examinadas | Complejidad temporal |
| --- | --- | --- | --- |
| Mejor caso | El elemento esta en la primera posicion | `1` | `O(1)` |
| Peor caso | Esta en la ultima posicion o no existe | `n` | `O(n)` |
| Caso promedio | El elemento puede estar en cualquier posicion | aproximadamente `(n + 1) / 2` | `O(n)` |

La complejidad espacial es `O(1)` porque el algoritmo solo utiliza el indice y
el resultado de la busqueda. El vector recibido no se modifica.

## Resultado informado

`BuscarElementoVector.ResultadoBusqueda` contiene:

- `fueEncontrado()`: indica si el elemento existe;
- `getIndice()`: devuelve el indice de la primera coincidencia o `-1` si no
  existe;
- `getPosicionesRecorridas()`: devuelve la cantidad de posiciones examinadas.

## Casos borde contemplados

- **Vector `null`:** se lanza `IllegalArgumentException` con el mensaje `El
  vector no puede ser null.`.
- **Vector vacio:** se lanza `IllegalArgumentException` con el mensaje `El
  vector no puede estar vacio.`.
- **Vector con un elemento:** se examina una posicion y se informa el
  resultado correspondiente.
- **Elementos repetidos:** se devuelve la primera coincidencia.
- **Elemento inexistente:** se recorren todas las posiciones y se devuelve
  indice `-1`.
- **Valores negativos y extremos de `int`:** se comparan correctamente.
- **Vector original:** no se modifica durante la busqueda.

## Como compilar y ejecutar

Desde la raiz del repositorio:

```powershell
cd Analisis_de_algoritmos\Ejercicio_2
javac BuscarElementoVector.java
java BuscarElementoVector
```

## Estructura de archivos

- `BuscarElementoVector.java`: contiene la busqueda lineal, el resultado
  detallado y los ejemplos de ejecucion.
- `README.md`: documenta las estrategias, la justificacion y el analisis del
  algoritmo.

## Decisiones de implementacion

No hay comentarios `DECISION` en el codigo fuente del ejercicio. Por lo tanto,
no existen decisiones marcadas con esa etiqueta para transcribir.

Las decisiones observables directamente en el codigo son:

- Se eligio una busqueda lineal iterativa porque el vector esta desordenado y
  permite detenerse en la primera coincidencia.
- Se devuelve la primera aparicion cuando el elemento esta repetido.
- Se informa el indice desde `0`, siguiendo la indexacion de los arreglos de
  Java, y la cantidad de posiciones recorridas desde `1`.
- Se encapsula el resultado en `ResultadoBusqueda` para informar el estado, el
  indice y las posiciones recorridas en una sola respuesta.
- Se usa `-1` como indice cuando el elemento no existe.
- Se rechazan vectores `null` y vacios mediante `IllegalArgumentException`.
- No se modifica el vector recibido.

## Informe final del ejecutador

La clase fue compilada y ejecutada correctamente con:

```powershell
Push-Location "Analisis_de_algoritmos\Ejercicio_2"; javac BuscarElementoVector.java; if ($LASTEXITCODE -eq 0) { java BuscarElementoVector }; Pop-Location
```

Salida obtenida:

```text
Busqueda al inicio: Elemento encontrado en el indice 0. Posiciones recorridas: 1
Busqueda al final: Elemento encontrado en el indice 5. Posiciones recorridas: 6
Busqueda inexistente: Elemento no encontrado. Posiciones recorridas: 6
Primera coincidencia: Elemento encontrado en el indice 0. Posiciones recorridas: 1
Busqueda en un elemento: Elemento encontrado en el indice 0. Posiciones recorridas: 1
Validacion correcta: El vector no puede ser null.
Validacion correcta: El vector no puede estar vacio.
```

La compilacion y la ejecucion verifican las busquedas al inicio y al final,
un elemento inexistente, la primera coincidencia entre repetidos, un vector de
un elemento y las validaciones de `null` y vector vacio. La clase, la clase
publica anidada y sus metodos publicos cuentan con Javadoc.

## Limitaciones y pendientes

- El programa de demostracion usa vectores definidos en el codigo y no recibe
  datos mediante una interfaz interactiva.
- No se incluyen pruebas automatizadas separadas; los casos normales y borde
  se ejercitan desde `main`.
- El algoritmo realiza una nueva busqueda lineal para cada elemento buscado;
  no esta optimizado para muchas consultas sobre el mismo vector.