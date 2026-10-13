# Potencia recursiva

`PotenciaRecursiva` calcula una potencia usando multiplicaciones sucesivas.

## Objetivo

Practicar la resolución recursiva del cálculo de una potencia para una base `long` y un exponente entero no negativo.

## Estructura de datos utilizada

No se utiliza una estructura de datos explícita. El resultado parcial se transporta mediante el retorno de cada llamada recursiva y las llamadas pendientes se almacenan en la pila de ejecución.

## Funcionamiento

- **Caso base:** si el exponente es `0`, devuelve `1`. Por lo tanto, `0^0` también devuelve `1`.
- **Caso recursivo:** multiplica la base por el resultado de calcular la misma potencia con el exponente reducido en `1`.
- **Retorno:** cada llamada devuelve su producto a la llamada anterior hasta llegar al caso base.
- Los exponentes negativos no son válidos y producen `IllegalArgumentException`.
- `Math.multiplyExact` detecta el overflow del tipo `long` y produce `ArithmeticException`.

## Pruebas incluidas

<!-- DECISION: referir el punto de entrada como `main` — Motivo: coincide con el metodo estatico de la clase `PotenciaRecursiva` y con la ejecucion real. -->
El metodo `main` prueba `2^0`, `2^5`, bases negativas con exponentes par e impar, `0^5`, `0^0`, un caso de overflow y un exponente negativo.

## Estructura de archivos

- `PotenciaRecursiva.java`: contiene el método recursivo `calcularPotencia`, el punto de entrada `main` y el método privado que muestra cada resultado.

## Cómo compilar y ejecutar

Desde este directorio:

```text
javac PotenciaRecursiva.java
java PotenciaRecursiva
```

## Ejemplo de uso

La ejecución del punto de entrada incluye, entre otros, el caso `2^5`, que muestra un resultado de `32`, y el caso `2^0`, que muestra un resultado de `1`.

## Casos borde contemplados

- Exponente `0`: devuelve `1`, incluido el caso `0^0`.
- Base `0` con exponente positivo: devuelve `0`.
- Base negativa: conserva el signo esperado según el exponente sea impar o par.
- Exponente negativo: lanza `IllegalArgumentException`.
- Resultado fuera del rango de `long`: `Math.multiplyExact` lanza `ArithmeticException`.
- Exponentes muy grandes: pueden agotar la pila de llamadas antes de finalizar.

## Decisiones de implementación

- Se usa el caso base `exponente == 0` y se devuelve `1`, por lo que `0^0` queda definido con ese valor (`PotenciaRecursiva.java`).
- Se reduce el exponente en una unidad por llamada y se realizan multiplicaciones sucesivas (`PotenciaRecursiva.java`).
- Se usa `Math.multiplyExact` para detectar overflow en lugar de permitir un desbordamiento silencioso de `long` (`PotenciaRecursiva.java`).
- Se refiere el punto de entrada como `main`, porque coincide con el método estático de la clase y con la ejecución real (`README.md`).

## Complejidad y limitaciones

Para un exponente `n` no negativo, el algoritmo realiza `n` multiplicaciones, por lo que tiene complejidad temporal **O(n)** y espacial **O(n)** debido a la pila de llamadas recursivas. En el caso `n = 0`, no realiza multiplicaciones.

El resultado está limitado al rango de `long`. Además, exponentes muy grandes pueden provocar un desbordamiento de la pila antes de terminar.

## Limitaciones

- El algoritmo no usa exponenciación rápida; por eso el tiempo y la profundidad de la recursión crecen linealmente con el exponente.