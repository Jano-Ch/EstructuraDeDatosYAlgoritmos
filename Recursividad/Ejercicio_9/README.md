# Ejercicio 9: Palindromos

## Objetivo

Determinar recursivamente si una cadena se lee igual de izquierda a derecha y de derecha a izquierda.

## Estructura de datos utilizada

Se utiliza un `String` y dos indices enteros: `inicio` apunta al extremo izquierdo del tramo pendiente y `fin` al extremo derecho. No se crea una estructura auxiliar; cada llamada recursiva reduce el tramo analizado hacia el centro.

## Funcionamiento

La clase no declara `package` y expone el metodo estatico `public static boolean esPalindromo(String palabra)`.

1. Si `palabra` es `null`, se lanza `IllegalArgumentException`.
2. Se comparan los caracteres de los extremos mediante `charAt(inicio)` y `charAt(fin)`.
3. Si son distintos, el resultado es `false` inmediatamente.
4. Si son iguales, la recursion se reduce con `inicio + 1` y `fin - 1`.
5. Cuando `inicio >= fin`, los indices se encontraron o se cruzaron y se devuelve `true`.

La comparacion es literal: distingue mayusculas, minusculas, espacios y cualquier otro caracter. No se normaliza la cadena.

## Complejidad

Para una cadena de longitud `n`:

| Operacion | Complejidad | Justificacion |
| --- | --- | --- |
| Comparar una cadena | `O(n)` | Se revisa como maximo un par de caracteres por cada tramo, hasta recorrer la mitad de la cadena. |
| Pila de llamadas recursivas | `O(n)` | Se acumulan llamadas hasta alcanzar el centro; el numero maximo es proporcional a `n`. |

Una diferencia en los extremos puede terminar el algoritmo antes, pero no cambia la complejidad del peor caso.

## Estructura de archivos

- `Palindromo.java`: contiene la clase `Palindromo`, el metodo recursivo de verificacion y un `main` con ejemplos fijos.
- `README.md`: documenta el objetivo, el algoritmo, la complejidad y la forma de ejecucion.

## Compilar y ejecutar

Desde este directorio:

```text
javac Palindromo.java
java Palindromo
```

## Ejemplo de uso

La ejecucion incluida en `main` imprime resultados para una cadena palindroma, una no palindroma, una cadena de un caracter, una cadena vacia y el caso `null`:

```text
"reconocer" -> true
"algoritmo" -> false
"a" -> true
"" -> true
null -> IllegalArgumentException: La palabra no puede ser null
```

## Casos borde contemplados

- `null`: lanza `IllegalArgumentException` antes de iniciar la recursion.
- Cadena vacia: devuelve `true`, porque los indices iniciales se cruzan.
- Un solo caracter: devuelve `true`, porque los indices son iguales.
- Cadena de longitud par: devuelve `true` si todos los pares de extremos coinciden y termina cuando los indices se cruzan.
- Cadena de longitud impar: devuelve `true` si todos los pares de extremos coinciden y termina al alcanzar el caracter central.
- Caracteres distintos en los extremos: devuelve `false` sin seguir reduciendo la cadena.
- Mayusculas, minusculas, espacios y otros caracteres: se comparan literalmente, sin normalizacion.

## Decisiones de implementacion

No hay comentarios `DECISION` en los archivos de este ejercicio. La implementacion usa indices en lugar de crear subcadenas, mantiene la comparacion literal y representa el caso `null` mediante `IllegalArgumentException`, tal como refleja el contrato documentado en `Palindromo.java`.

<!-- DECISION: denominar esta sección solo como limitaciones — Motivo: no quedan tareas pendientes de integración en el ejercicio. -->
## Limitaciones

- El metodo no ofrece una variante que ignore mayusculas, espacios o signos; esos caracteres forman parte de la comparacion literal.
- `main` utiliza ejemplos fijos y no recibe cadenas desde la entrada estandar.
