# Ejercicio 7: invertir un vector

## Objetivo

Invertir el orden de los elementos de un vector de enteros mediante dos
estrategias: un vector auxiliar y una modificacion in-place.

## Estructura de datos utilizada

Se utiliza un arreglo (`int[]`) de longitud `n`. La version auxiliar crea otro
arreglo del mismo tamano y coloca en cada posicion el elemento correspondiente
del final del vector original. La version in-place trabaja sobre el mismo
arreglo, intercambiando los elementos de posiciones simetricas.

## Estrategias

### Vector auxiliar

`invertirConVectorAuxiliar` crea un vector nuevo del mismo tamano y copia en
cada posicion el elemento correspondiente contado desde el final del vector
original. El vector original queda sin modificaciones.

Sus ventajas son que conserva los datos de entrada y que el resultado queda
separado del original. Su desventaja es el uso de memoria adicional
proporcional al tamano del vector.

### In-place

`invertirEnElMismoVector` utiliza dos indices, uno al comienzo y otro al final,
y una variable temporal. Intercambia los elementos de ambos extremos y acerca
los indices hasta encontrarse. Modifica el vector recibido y no crea otro
vector.

Su ventaja principal es el uso constante de memoria adicional. Su desventaja
es que destruye el orden original, por lo que se debe conservar una copia
antes de invocarlo si los datos originales son necesarios.

## Complejidad

Sea `n` la cantidad de elementos del vector:

| Estrategia | Tiempo | Espacio adicional | Modifica el original |
| --- | --- | --- | --- |
| Vector auxiliar | `O(n)` | `O(n)` | No |
| In-place | `O(n)` | `O(1)` | Si |

Ambas estrategias recorren como maximo todas las posiciones del vector. La
version in-place realiza aproximadamente `n / 2` intercambios, pero su orden de
complejidad sigue siendo `O(n)`.

## Ejemplo de uso

Para un vector `{1, 2, 3, 4}`:

- `invertirConVectorAuxiliar` devuelve `{4, 3, 2, 1}` y conserva `{1, 2, 3, 4}`.
- `invertirEnElMismoVector` transforma el vector recibido en `{4, 3, 2, 1}`.

El programa de demostracion se ejecuta mediante `main` y muestra el resultado
de cada caso verificado.

## Casos borde contemplados

- Vector normal.
- Vector vacio, que se acepta y permanece vacio.
- Vector de un elemento.
- Cantidad par de elementos.
- Cantidad impar de elementos.
- Elementos repetidos.
- Valores negativos.
- Vector `null`, que produce `IllegalArgumentException` en ambas estrategias.

El `main` utiliza vectores independientes para cada estrategia y verifica que
la version auxiliar cree un nuevo vector sin modificar el original. Tambien
comprueba que la version in-place modifique correctamente su propio vector.

## Decisiones de implementacion

No hay comentarios `DECISION` en los archivos de este ejercicio. Las
decisiones observables en la implementacion son:

- La estrategia auxiliar devuelve un vector nuevo para preservar el original,
  a cambio de usar `O(n)` de espacio adicional.
- La estrategia in-place usa dos indices y una variable temporal para reducir
  el espacio adicional a `O(1)`, aceptando la mutacion del vector recibido.
- `null` se considera una entrada invalida y provoca
  `IllegalArgumentException`; un vector vacio es valido.

## Limitaciones y pendientes

- Las implementaciones trabajan exclusivamente con vectores de enteros
  (`int[]`).
- La estrategia in-place no conserva el orden original; es necesario copiar
  el vector antes de usarla si luego se necesitan los datos sin invertir.
- No quedan pendientes indicados para este ejercicio.

## Estructura de archivos

- `InvertirVector.java`: contiene las dos implementaciones, validaciones y
  pruebas de demostracion.
- `README.md`: documenta las estrategias, efectos sobre el original,
  ventajas, desventajas, complejidades y ejecucion.

## Como compilar y ejecutar

Desde la raiz del repositorio:

```powershell
cd Analisis_de_algoritmos\Ejercicio_7
javac InvertirVector.java
java InvertirVector
```

La ejecucion correcta muestra una linea para cada caso, dos validaciones de
`null` y el mensaje final `Todos los casos fueron verificados correctamente.`.