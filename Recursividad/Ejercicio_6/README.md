# Ejercicio 6: Contar digitos

La clase `ContarDigitos` cuenta recursivamente la cantidad de digitos de un
entero positivo mediante el metodo `contarDigitos(int numero)`.

## Validacion

El metodo acepta estrictamente valores mayores que cero. Si recibe `0` o un
numero negativo, lanza `IllegalArgumentException`.

## Caso base

Cuando `numero < 10`, el metodo devuelve `1`, porque todo entero positivo de
una sola cifra tiene exactamente un digito.

## Paso recursivo

Para numeros de dos o mas cifras, la division entera `numero / 10` elimina el
ultimo digito decimal. Por eso se suma `1` por el digito eliminado y se vuelve
a contar los digitos del cociente:

```text
contarDigitos(numero) = 1 + contarDigitos(numero / 10)
```

La recursion finaliza cuando el cociente queda entre `1` y `9`, momento en el
que el caso base devuelve `1`.

## Retorno

El metodo devuelve un `int` con la cantidad de digitos decimales de `numero`.

## Pruebas incluidas

El `main` ejecuta los casos `7`, `42`, `1000`, `1` y `Integer.MAX_VALUE`, y
tambien verifica que `0` y `-1` sean rechazados.

## Complejidad

- Tiempo: `O(log10 n)`, porque cada llamada divide el numero por `10`.
- Espacio: `O(log10 n)`, por la cantidad de llamadas pendientes en la pila de
  recursion.

## Compilar y ejecutar

Desde la raiz del repositorio:

```bash
javac Recursividad/Ejercicio_6/ContarDigitos.java
java -cp Recursividad/Ejercicio_6 ContarDigitos
```