# Ejercicio 7: Suma de digitos

## Descripcion

El metodo `sumarDigitos(int numero)` calcula recursivamente la suma de los digitos decimales de un numero entero no negativo.

Los numeros negativos se rechazan lanzando `IllegalArgumentException`.

## Funcionamiento

- **Caso base:** si `numero < 10`, devuelve `numero`. Esto incluye el caso `numero == 0`, que devuelve `0`.
- **Caso recursivo:** toma el ultimo digito con `numero % 10` y continua con el resto del numero mediante la division entera `numero / 10`:

  `numero % 10 + sumarDigitos(numero / 10)`

La division entera descarta la parte decimal. Por ejemplo, `12345 / 10` produce `123`.

La expresion combina el ultimo digito obtenido en cada llamada con la suma calculada recursivamente para los digitos restantes.

## Pruebas incluidas

El `main` prueba los valores fijos:

- `12345`, cuya suma es `15`.
- `7`, cuya suma es `7`.
- `1000`, cuya suma es `1`.
- `0`, caso base cuya suma es `0`.
- `Integer.MAX_VALUE`, cuya suma es `46`.
- `-1`, que provoca `IllegalArgumentException`.

## Complejidad

Si `d` es la cantidad de digitos del numero:

- Tiempo: `O(d)`, porque se procesa un digito por llamada.
- Espacio: `O(d)`, por la pila de llamadas recursivas.

## Compilacion y ejecucion

Desde esta carpeta:

```text
javac SumaDigitos.java
java SumaDigitos
```
