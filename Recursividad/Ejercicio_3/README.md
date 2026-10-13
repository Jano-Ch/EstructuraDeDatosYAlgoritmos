# Multiplicación recursiva

## Representación como sumas

La multiplicación se representa como una suma repetida. Por ejemplo:

`3 x 4 = 3 + 3 + 3 + 3`

El método `multiplicar` calcula las magnitudes de los factores y suma la
magnitud mayor tantas veces como indica la menor magnitud. Al final aplica el
signo correspondiente.

## Parámetro reducido

La recursión recibe como segundo parámetro la menor magnitud. Así se reduce la
cantidad de llamadas cuando los factores tienen tamaños diferentes. Las
magnitudes se almacenan en `long`, por lo que `Integer.MIN_VALUE` puede
convertirse y negarse sin desbordamiento.

## Base cero y retorno

El caso base ocurre cuando la cantidad de sumas es cero: el método retorna
`0L`. En cada paso recursivo se resta una unidad a esa cantidad y se agrega el
sumando. El resultado final se niega únicamente cuando los factores tienen
signos distintos.

## Pruebas incluidas

El `main` fijo prueba:

- dos factores positivos;
- un factor cero;
- un factor negativo;
- ambos factores negativos;
- `Integer.MAX_VALUE` por uno;
- `Integer.MIN_VALUE` por uno, por menos uno y por cero.

## Complejidad

Si $m$ es la menor magnitud, la complejidad temporal es $O(m)$ y la
complejidad espacial es $O(m)$ por la pila de llamadas recursivas.

## Límites y restricción del operador

El resultado se retorna como `long`. Los factores de entrada son `int`, así
que el producto exacto de dos factores siempre cabe en `long`. La profundidad
de la recursión está limitada por la pila disponible; factores con magnitudes
enormes pueden producir `StackOverflowError` aunque el resultado sea válido.

El algoritmo y las expresiones de implementación no utilizan el operador `*`
ni ningún operador de multiplicación; el cálculo se realiza exclusivamente
mediante sumas y recursividad.