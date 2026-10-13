# Ejercicio 5: contar hasta cero

## Objetivo

Imprimir una cuenta regresiva desde un número entero no negativo hasta cero utilizando recursividad.

## Estructura de datos utilizada

No se utiliza una estructura de datos explicita. La recursion usa la pila de
ejecucion de Java para conservar las llamadas activas; cada llamada contiene
el valor actual de `n`.

## Estrategia

El método `contarHastaCero(int n)` no devuelve ningún valor: su tipo de retorno es `void` y muestra cada número directamente en la consola.

Primero valida que `n` no sea negativo. Después imprime el valor actual. Si `n` es mayor que cero, se llama nuevamente con `n - 1`.

El caso base es `n == 0`: se imprime `0` y no se realiza otra llamada recursiva.

Un valor negativo se rechaza mediante `IllegalArgumentException` porque no representa una cuenta regresiva válida para este ejercicio.

## Por qué se utiliza `n - 1`

Cada llamada debe acercarse al caso base. Al usar `n - 1`, la secuencia avanza hacia `0` y la recursividad termina.

Si se utilizara `n + 1`, el valor se alejaría de `0` en cada llamada. Por eso nunca se alcanzaría el caso base, las llamadas continuarían hasta agotar la memoria de la pila y se produciría un `StackOverflowError`.

## Complejidad

Para un valor inicial `n`:

- **Tiempo:** `O(n)`, porque se imprime cada valor desde `n` hasta `0`.
- **Espacio:** `O(n)`, porque existen hasta `n + 1` llamadas activas en la pila de ejecución.

La complejidad temporal considera las `n + 1` impresiones y llamadas, mientras
que la espacial corresponde a la profundidad máxima de la pila para el valor
inicial `n`.

## Pruebas y casos borde contemplados

El método `main` prueba tres situaciones:

- `contarHastaCero(5)`: imprime la cuenta completa de `5` a `0`.
- `contarHastaCero(0)`: verifica directamente el caso base e imprime `0` una sola vez.
- `contarHastaCero(-1)`: verifica que un valor negativo lance
  `IllegalArgumentException`, que luego es capturada y mostrada por `main`.

## Estructura de archivos

- `ContarHastaCero.java`: contiene el método recursivo y un `main` con los ejemplos `5`, `0` y la validación de un valor negativo.
- `README.md`: documenta la estrategia, el caso base, la complejidad y la ejecución.

## Cómo compilar y ejecutar

Desde la raíz del repositorio:

```powershell
cd Recursividad\Ejercicio_5
javac ContarHastaCero.java
java ContarHastaCero
```

Los comandos compilan la clase y ejecutan su método `main` desde la carpeta del
ejercicio.

## Ejemplo de uso y salida esperada

```text
5
4
3
2
1
0
0
Validacion correcta: El numero no puede ser negativo.
```

## Decisiones de implementación

- El método `contarHastaCero` es `void` porque su resultado observable es la
  impresión de cada número, no un valor que deba retornar (`ContarHastaCero.java`).
- Se valida el valor negativo antes de imprimir para rechazar entradas que no
  forman parte de la cuenta regresiva (`ContarHastaCero.java`).
- Se eligió `n - 1` para acercar cada llamada al caso base `n == 0`; `n + 1`
  impediría terminar la recursión (`ContarHastaCero.java`).

<!-- DECISION: denominar esta sección solo como limitaciones — Motivo: no quedan tareas pendientes de integración en el ejercicio. -->
## Limitaciones

- La salida está acoplada a la consola y no puede ser reutilizada directamente
  como una colección o como un valor retornado.
- Para valores iniciales muy grandes, la profundidad de la recursión puede
  agotar la pila de ejecución.