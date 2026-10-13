# Ejercicio 1: mínimo de un vector

## Objetivo

Encontrar el valor mínimo de un vector de números enteros sin modificar el vector original.

## Estructura de datos utilizada

Se utiliza un arreglo (`int[]`) de Java. Los valores se almacenan en posiciones consecutivas y se recorren desde el primer elemento hasta el último.

Esta estructura es adecuada porque el problema recibe un vector y solo necesita consultar cada valor una vez para determinar cuál es el menor.

## Estrategias posibles

- **Recorrido iterativo:** examina cada elemento y conserva el menor encontrado. Tiene complejidad temporal `O(n)` y espacial `O(1)`.
- **Recursividad:** divide el problema comparando cada elemento con el mínimo del resto. Mantiene una complejidad temporal `O(n)`, pero utiliza `O(n)` de espacio por la pila de llamadas.
- **Ordenamiento previo:** ordena todo el vector y toma el primer elemento. Su complejidad habitual es `O(n log n)`, por lo que realiza trabajo innecesario para encontrar un único valor.
- **Divide y vencerás:** obtiene el mínimo de cada parte y luego los compara. Tiene complejidad temporal `O(n)` y, en una implementación recursiva, espacio `O(log n)`.

## Estrategia elegida

Se eligió el recorrido iterativo porque resuelve directamente el problema, visita cada elemento una única vez y utiliza memoria adicional constante. No es necesario ordenar el vector ni crear estructuras auxiliares.

El mínimo se inicializa con el primer elemento en lugar de utilizar `0` o un valor fijo. Así se obtienen resultados correctos cuando todos los elementos son positivos, todos son negativos o aparece `Integer.MIN_VALUE`.

## Complejidad

| Operación | Complejidad temporal | Complejidad espacial |
| --- | --- | --- |
| Recorrer el vector y encontrar el mínimo | `O(n)` | `O(1)` |
| Validar que el vector no sea `null` ni vacío | `O(1)` | `O(1)` |

La complejidad temporal del algoritmo principal es `O(n)` porque, en el peor caso, compara todos los elementos del vector. La complejidad espacial es `O(1)` porque solo mantiene la variable `minimo` y el índice del recorrido; el vector recibido no se copia ni se modifica.

## Estructura de archivos

- `MinimoVector.java`: contiene la clase `MinimoVector`, el método público `encontrarMinimo` y un método `main` con ejemplos de uso y validaciones.
- `MinimoVector.class`: archivo generado por la compilación; no forma parte del código fuente.

## Cómo compilar y ejecutar

Desde la raíz del repositorio:

```powershell
cd Analisis_de_algoritmos\Ejercicio_1
javac MinimoVector.java
java MinimoVector
```

## Ejemplo de uso

Para el vector `{8, -3, 12, 0, -9, 4}`, el programa ejecuta:

```java
int[] vector = {8, -3, 12, 0, -9, 4};
System.out.println(MinimoVector.encontrarMinimo(vector));
```

Salida:

```text
-9
```

La ejecución incluida en `main` también muestra el comportamiento para un único elemento, valores repetidos, un vector `null` y un vector vacío.

## Casos borde contemplados

- **Vector `null`:** se lanza `IllegalArgumentException` con el mensaje `El vector no puede ser null.`.
- **Vector vacío:** se lanza `IllegalArgumentException` con el mensaje `El vector no puede estar vacio.`.
- **Vector con un elemento:** se devuelve ese único elemento.
- **Valores negativos:** se comparan normalmente y se devuelve el menor.
- **Valores repetidos:** se devuelve correctamente el valor repetido cuando es el mínimo.
- **`Integer.MIN_VALUE`:** se devuelve correctamente al inicializar el mínimo con el primer elemento.
- **Vector original:** no se modifica durante el recorrido.

## Decisiones de implementación

No hay comentarios `DECISION` en el código fuente del ejercicio. Por lo tanto, no existen decisiones marcadas con esa etiqueta para transcribir. Las decisiones observables directamente en el código son:

- Se eligió un recorrido iterativo por su complejidad `O(n)` y uso de memoria `O(1)`.
- Se rechazaron los vectores `null` y vacíos mediante `IllegalArgumentException`.
- Se inicializó el mínimo con el primer elemento para cubrir correctamente todos los valores posibles de `int`.
- Se mantuvo el vector sin modificaciones.

## Informe final del ejecutador

La clase fue compilada y ejecutada correctamente con:

```powershell
Push-Location "Analisis_de_algoritmos\Ejercicio_1"; javac MinimoVector.java; if ($LASTEXITCODE -eq 0) { java MinimoVector }; Pop-Location
```

Salida obtenida:

```text
Minimo: -9
Minimo de un elemento: -2147483648
Minimo de valores repetidos: 5
Validacion correcta: El vector no puede ser null.
Validacion correcta: El vector no puede estar vacio.
```

También se realizó una comprobación estática del archivo y no se detectaron errores.

## Limitaciones y pendientes

- El método no calcula un mínimo para un vector vacío porque ese conjunto no tiene un valor mínimo definido; informa el problema mediante una excepción.
- El programa de demostración imprime los resultados en consola, pero no incluye una interfaz para ingresar vectores dinámicamente.
- No se incluyeron pruebas automatizadas separadas; los casos básicos y borde se ejercitan desde `main`.
