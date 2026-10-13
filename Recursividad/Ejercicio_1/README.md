# Ejercicio 1: factorial recursivo

## Objetivo

Calcular el factorial de un numero entero utilizando recursividad.

Para un numero `n`, el factorial se define como:

```text
n! = n * (n - 1)!
```

El resultado se almacena en un `long`. Por ese motivo, el ejercicio acepta
valores entre `0` y `20`, ambos inclusive.

## Estrategia recursiva

El metodo `calcularFactorial` es recursivo porque se invoca a si mismo con un
problema mas pequeno: `numero - 1`.

- **Casos base:** para `0` y `1`, el resultado es `1`.
- **Reduccion:** para un valor mayor que `1`, se calcula
  `numero * calcularFactorial(numero - 1)`.
- **Validacion:** antes de recursar, se rechazan los valores menores que `0`
  o mayores que `20` mediante `IllegalArgumentException`.

## Complejidad

Sea `n` el numero recibido:

| Operacion | Complejidad temporal | Complejidad espacial |
| --- | --- | --- |
| Calcular el factorial | `O(n)` | `O(n)` |
| Validar el rango | `O(1)` | `O(1)` |

La complejidad temporal es `O(n)` porque se realiza una llamada por cada valor
desde `n` hasta el caso base. La complejidad espacial es `O(n)` debido a las
llamadas recursivas pendientes en la pila de ejecucion.

## Estructura de archivos

- `FactorialRecursivo.java`: contiene la clase, el metodo publico
  `calcularFactorial` y ejemplos en `main`.
- `README.md`: documenta la estrategia, complejidad, pruebas y ejecucion.

## Pruebas incluidas

El metodo `main` prueba los valores normales `0`, `1`, `5`, `10` y `20`, y
tambien verifica los casos fuera de rango `-1` y `21`. Los dos ultimos deben
lanzar `IllegalArgumentException`.

La compilacion y la ejecucion fueron verificadas correctamente por el
ejecutor.

## Ejemplo de uso

Una ejecucion de `main` produce resultados como los siguientes:

```text
0! = 1
1! = 1
5! = 120
10! = 3628800
20! = 2432902008176640000
Validacion correcta para -1: El numero debe estar entre 0 y 20.
Validacion correcta para 21: El numero debe estar entre 0 y 20.
```

El metodo publico tambien puede invocarse directamente, por ejemplo,
`FactorialRecursivo.calcularFactorial(5)` devuelve `120`.

## Casos borde contemplados

- `n = 0`: es un caso base y devuelve `1`.
- `n = 1`: es un caso base y devuelve `1`.
- `n = 20`: es el mayor valor aceptado y su factorial cabe en un `long`.
- `n < 0`: se rechaza con `IllegalArgumentException`.
- `n > 20`: se rechaza con `IllegalArgumentException`, porque `21!` no cabe
  en un `long`.

## Decisiones de implementacion

- Se usa un mensaje unico para los dos limites invalidos. Esta decision,
  marcada en `FactorialRecursivo.java`, mantiene explicita y consistente la
  regla de rango del ejercicio.

## Como compilar y ejecutar

Desde la raiz del repositorio:

```powershell
cd Recursividad\Ejercicio_1
javac FactorialRecursivo.java
java FactorialRecursivo
```

## Limitaciones

- No se aceptan valores negativos ni valores mayores que `20`.
- El limite superior evita el desbordamiento de `long`: `20!` cabe en ese
  tipo, pero `21!` no.
- Los ejemplos utilizan valores fijos y no solicitan datos por consola.
- No se incluyen pruebas automatizadas separadas; los casos normales y borde
  se ejercitan desde `main`.