# Ejercicio 8: Invertir un string

## Objetivo

Implementar `InvertirString.invertir(String texto)` usando recursividad, sin ciclos para resolver la inversión.

## Estructura de datos utilizada

Se utiliza un arreglo `char[]`, creado a partir del `String` recibido. El arreglo permite intercambiar los caracteres de los extremos sin crear una nueva cadena en cada llamada. La recursión se controla con los índices `inicio` y `fin`, que delimitan el tramo pendiente de invertir.

## Idea recursiva

El método trabaja sobre un arreglo de caracteres. En cada llamada:

1. Se intercambian el primer carácter y el último carácter del tramo actual.
2. Se reduce el problema avanzando el índice inicial y retrocediendo el índice final.
3. La llamada recursiva continúa con el tramo interior. La sucesión de intercambios deja reconstruido el texto invertido en el mismo arreglo.

La recursión termina cuando los índices se cruzan o apuntan al mismo carácter. Por eso, una cadena vacía y una cadena de un carácter son casos base: no necesitan intercambios.

El método conserva los espacios y los caracteres tal como aparecen en el arreglo. Si se recibe `null`, lanza `IllegalArgumentException`.

## Estructura de archivos

- `InvertirString.java`: contiene la clase `InvertirString`, el método público de inversión recursiva y un `main` con ejemplos fijos.
- `README.md`: explica el enfoque, la complejidad, los casos borde y las limitaciones.

## Pruebas incluidas

El `main` ejecuta ejemplos fijos para:

- palabras normales;
- cadena vacía;
- un solo carácter;
- una cadena con espacios al inicio, entre palabras y al final;
- un palíndromo.

Las palabras de prueba son `algoritmos`, `recursividad` y `reconocer`.

## Ejemplo de uso

Una llamada como `InvertirString.invertir("algoritmos")` devuelve `"somtirogla"`. El programa de ejemplo también muestra la inversión de `"recursividad"`, una cadena vacía, `"A"`, `"  hola mundo  "` y `"reconocer"`.

Para ejecutar:

```text
javac InvertirString.java
java InvertirString
```

## Complejidad

Para una cadena de longitud `n`, el tiempo es `O(n)`: cada carácter participa como máximo en un intercambio. El arreglo `char[]` requiere `O(n)` memoria y la pila de llamadas recursivas requiere `O(n)` en el peor caso.

| Operación | Complejidad temporal | Complejidad espacial |
|---|---:|---:|
| Convertir el texto a `char[]` | `O(n)` | `O(n)` |
| Invertir recursivamente | `O(n)` | `O(n)` por la pila |
| Construir el `String` resultado | `O(n)` | `O(n)` |
| Operación completa `invertir` | `O(n)` | `O(n)` |

Cada nivel procesa un par de extremos y reduce el tramo pendiente en dos posiciones; por eso hay un número lineal de niveles y operaciones.

## Casos borde contemplados

- `null`: se rechaza con `IllegalArgumentException` antes de crear el arreglo.
- Cadena vacía: los índices inicial y final quedan cruzados, por lo que no se realiza ningún intercambio y se devuelve otra cadena vacía.
- Un carácter: ambos índices apuntan al mismo elemento, por lo que queda sin cambios.
- Espacios: se conservan y se invierten junto con el resto de los caracteres.
- Palíndromo: se devuelve el mismo texto porque sus extremos coinciden simétricamente.

## Decisiones de implementación

- Se eligió el intercambio recursivo de extremos para practicar recursividad sin ciclos y evitar concatenaciones repetidas de `String`.
- Se usa `char[]` como estructura mutable de trabajo y se crea el `String` resultado al finalizar.
- La condición base `inicio >= fin` cubre simultáneamente cadenas vacías, de un carácter y tramos ya procesados.
- Los argumentos `null` se consideran inválidos y producen `IllegalArgumentException` con un mensaje explicativo.

## Limitaciones Unicode

Java representa un `String` como unidades UTF-16 y `char[]` trabaja con esas unidades, no con puntos de código Unicode completos ni grafemas visibles. Por eso, la inversión puede separar pares sustitutos, como algunos emojis, y también puede separar una letra de sus marcas combinantes. La implementación es adecuada para caracteres representables de forma independiente en `char`, pero no garantiza una inversión visual correcta para todo texto Unicode.
