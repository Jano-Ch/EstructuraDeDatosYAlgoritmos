# Ejercicio 4: detectar elementos duplicados

## Objetivo

Detectar si un vector de enteros contiene al menos un elemento duplicado,
comparando dos estrategias: una basada en dos ciclos anidados y otra basada en
la estructura `HashSet`.

## Estructura de datos utilizada

El dato de entrada es un arreglo de enteros (`int[]`), cuyos elementos se
recorren por indice o mediante un ciclo `for-each`.

La segunda estrategia utiliza un `HashSet<Integer>` llamado
`valoresObservados` para registrar los valores que ya fueron recorridos. Si un
valor no puede agregarse porque ya estaba presente, se detecta un duplicado.

La primera estrategia no utiliza una estructura auxiliar: compara cada elemento
con todos los elementos que aparecen despues mediante dos ciclos anidados.

## Complejidad

Sea `n` la cantidad de elementos del vector:

| Operacion | Complejidad temporal | Complejidad espacial |
| --- | --- | --- |
| Deteccion con ciclos anidados | `O(n^2)` | `O(1)` |
| Deteccion con `HashSet` (promedio) | `O(n)` | `O(n)` |
| Validacion del vector | `O(1)` | `O(1)` |

La estrategia de ciclos anidados puede comparar cada par de posiciones, por lo
que su tiempo es cuadratico. La estrategia con `HashSet` realiza, en promedio,
una insercion o busqueda de costo `O(1)` por cada elemento y recorre el vector
una sola vez. En el peor caso teorico, las operaciones de una tabla hash pueden
costar mas que `O(1)` por elemento.

Ambas estrategias finalizan inmediatamente cuando encuentran el primer
duplicado. El vector recibido no se modifica.

## Estructura de archivos

- `DetectarDuplicados.java`: contiene la clase `DetectarDuplicados`, las dos
  estrategias de deteccion, la validacion de entrada y los ejemplos de
  ejecucion.
- `README.md`: documenta el objetivo, las estrategias, la complejidad y la
  verificacion del ejercicio.

## Como compilar y ejecutar

Desde la raiz del repositorio:

```powershell
Push-Location "Analisis_de_algoritmos\Ejercicio_4"; javac DetectarDuplicados.java; if ($LASTEXITCODE -eq 0) { java DetectarDuplicados }; Pop-Location
```

## Ejemplo de uso

Para el vector `{1, 2, 3, 2}`, ambas estrategias detectan un duplicado:

```java
int[] vector = {1, 2, 3, 2};
boolean conCiclos = DetectarDuplicados.detectarConCiclosAnidados(vector);
boolean conHashSet = DetectarDuplicados.detectarConHashSet(vector);
```

El resultado de ambas llamadas es `true`.

## Casos borde contemplados

- **Vector `null`:** se lanza `IllegalArgumentException` con el mensaje
  `El vector no puede ser null.`.
- **Vector vacio:** devuelve `false`, porque no contiene elementos repetidos.
- **Vector con un elemento:** devuelve `false`.
- **Todos los elementos distintos:** devuelve `false`.
- **Duplicados consecutivos o separados:** devuelve `true` al encontrar la
  primera repeticion.
- **Multiples duplicados:** devuelve `true` sin continuar despues de detectar
  el primero.
- **Valores negativos y extremos de `int`:** se comparan y almacenan como
  valores enteros, sin tratamiento especial que altere su valor.
- **Vector original:** no se modifica durante ninguna de las dos estrategias.

## Decisiones de implementacion

No hay comentarios `DECISION` en el codigo fuente de este ejercicio. Por lo
tanto, no existen decisiones marcadas con esa etiqueta para transcribir.

Las decisiones observables directamente en el codigo son:

- Se implementaron dos metodos publicos separados para comparar las
  estrategias: `detectarConCiclosAnidados` y `detectarConHashSet`.
- La estrategia de ciclos anidados compara cada posicion con las posiciones
  posteriores y no utiliza memoria auxiliar.
- La estrategia con `HashSet` conserva los valores observados y aprovecha el
  resultado booleano de `add` para detectar una repeticion.
- Ambas estrategias devuelven `true` apenas encuentran un duplicado.
- Se acepta el vector vacio y se informa como un vector sin duplicados.
- Se rechaza un vector `null` mediante `IllegalArgumentException`.
- El metodo `main` utiliza ejemplos incluidos en el codigo para mostrar el
  resultado de ambas estrategias y las validaciones de entrada.

## Informe final del ejecutador

La clase fue compilada y ejecutada correctamente con:

```powershell
Push-Location "Analisis_de_algoritmos\Ejercicio_4"; javac DetectarDuplicados.java; if ($LASTEXITCODE -eq 0) { java DetectarDuplicados }; Pop-Location
```

Salida obtenida:

```text
Ejemplo 1: ciclos anidados=false, HashSet=false
Ejemplo 2: ciclos anidados=true, HashSet=true
Ejemplo 3: ciclos anidados=true, HashSet=true
Ejemplo 4: ciclos anidados=false, HashSet=false
Ejemplo 5: ciclos anidados=false, HashSet=false
Validacion correcta: El vector no puede ser null.
Validacion correcta: El vector no puede ser null.
```

La ejecucion verifica un vector sin duplicados, un vector con duplicados
separados, un vector con valores repetidos, un vector vacio, un vector de un
elemento y el rechazo de un vector `null` en ambas implementaciones. La
comprobacion estatica posterior no detecto errores.

La clase y sus metodos publicos cuentan con Javadoc.

## Limitaciones y pendientes

- El programa devuelve un booleano y no informa cuales valores estan
  duplicados ni sus posiciones.
- Los ejemplos se encuentran definidos en el metodo `main`; no se reciben
  vectores mediante una interfaz interactiva.
- No se incluyen pruebas automatizadas separadas; los casos normales y borde
  se ejercitan desde `main`.
- La estrategia con `HashSet` utiliza memoria adicional proporcional al numero
  de valores recorridos.
