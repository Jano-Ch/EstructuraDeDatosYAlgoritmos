# Ejercicio 2: suma recursiva

## Objetivo

Calcular la suma de los enteros desde cero hasta un numero `n` utilizando recursion, sin ciclos para el calculo.

## Estructura de datos utilizada

No se utiliza una estructura de datos explícita. La solución usa la pila de llamadas del lenguaje para conservar cada suma pendiente mientras la recursión avanza desde `n` hasta `0`.

## Estrategia

El problema se expresa con la siguiente relacion:

```text
suma(n) = n + suma(n - 1)
```

El caso simple o base es `n == 0`, que devuelve `0`. Para un valor positivo, el metodo suma `n` con el resultado de resolver el mismo problema para `n - 1`.

Por ejemplo, para `n = 3` la evaluación es `3 + suma(2)`, luego `3 + 2 + suma(1)`, luego `3 + 2 + 1 + suma(0)` y finalmente `3 + 2 + 1 + 0 = 6`.

Antes de comenzar la recursion se valida que `n` no sea negativo. Si `n < 0`, se lanza `IllegalArgumentException` porque el dominio definido para el metodo son los enteros no negativos.

## Complejidad

| Operacion | Complejidad temporal | Complejidad espacial |
| --- | --- | --- |
| Sumar desde `0` hasta `n` | `O(n)` | `O(n)` |
| Validar que `n` no sea negativo | `O(1)` | `O(1)` |

El tiempo es `O(n)` porque se realiza una llamada por cada valor entre `n` y `0`. La pila de llamadas ocupa `O(n)` espacio.

## Ejemplo de uso

Una llamada como la siguiente calcula la suma de `0` a `5`:

```java
long resultado = SumaRecursiva.sumarHastaUno(5); // 15
```

El programa ejecutable incluye este ejemplo mediante su metodo `main`.

## Estructura de archivos

- `SumaRecursiva.java`: contiene la clase `SumaRecursiva`, el metodo publico `sumarHastaUno` y un `main` con las pruebas solicitadas.
- `README.md`: documenta la estrategia, la complejidad, las pruebas y los comandos de ejecucion.

## Pruebas incluidas

El `main` prueba los siguientes valores:

- `5`, para un caso normal.
- `1`, para el menor valor positivo.
- `0`, para verificar el caso base.
- `10`, para otro caso normal.
- `-1`, para verificar el rechazo de valores negativos mediante `IllegalArgumentException`.

Estas pruebas cubren un caso normal, el menor positivo, el caso base y la validacion del limite inferior. La relacion verificada por la implementacion es `suma(n) = n + suma(n - 1)` hasta alcanzar `suma(0) = 0`.

## Casos borde contemplados

- `n = 0`: se devuelve `0` inmediatamente, sin llamadas recursivas adicionales.
- `n = 1`: se calcula `1 + suma(0)` y se devuelve `1`.
- `n < 0`: se rechaza antes de iniciar la recursion mediante `IllegalArgumentException`.
- Valores positivos grandes: el resultado se almacena en `long`, pero la cantidad de llamadas sigue creciendo linealmente y puede agotar la pila si `n` es demasiado grande.

## Como compilar y ejecutar

Desde la raiz del repositorio:

```powershell
cd Recursividad\Ejercicio_2
javac SumaRecursiva.java
java SumaRecursiva
```

## Salida esperada

```text
Suma hasta 5: 15
Suma hasta 1: 1
Suma hasta 0: 0
Suma hasta 10: 55
Validacion correcta: El numero no puede ser negativo.
```

## Decisiones de implementacion

- `SumaRecursiva.java`: se adopta sintaxis compatible con Java 17 o superior porque el proyecto no define una version de Java y se toma como referencia una version LTS moderna.

<!-- DECISION: denominar esta sección solo como limitaciones — Motivo: no quedan tareas pendientes de integración en el ejercicio. -->
## Limitaciones

- La solucion es recursiva por el objetivo del ejercicio; una implementacion iterativa reduciria el espacio auxiliar a `O(1)`.
- No se especifica en el proyecto una version exacta del JDK. Los comandos requieren que `javac` y `java` esten disponibles en el `PATH`.
- Para valores muy grandes, el tipo `long` puede desbordarse y la profundidad de la recursion puede provocar `StackOverflowError`; esos limites no se validan en el programa.
