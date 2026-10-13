# Ejercicio 5: contar ocurrencias

## Objetivo

Contar cuantas veces aparece un valor determinado dentro de un vector de
enteros, sin modificar el vector original.

## Estructura de datos utilizada

Se utiliza un arreglo de enteros de Java (`int[]`). Los elementos se almacenan
en posiciones consecutivas y se recorren desde la primera hasta la ultima
posicion. Esta estructura es la recibida por el metodo y resulta suficiente
porque el problema solo necesita consultar cada valor y acumular las
coincidencias.

## Estrategia elegida

Se utiliza un recorrido lineal iterativo. El algoritmo examina cada posicion
del vector y aumenta un contador cada vez que encuentra el valor buscado.

El recorrido debe ser completo: encontrar una coincidencia no permite detener
el algoritmo, porque puede haber otras apariciones en posiciones posteriores.
Por ejemplo, si el valor aparece en la primera posicion, todavia puede volver
a aparecer en cualquier otra posicion del vector.

## Analisis de complejidad

Sea `n` la cantidad de elementos del vector:

| Caso | Posiciones examinadas | Complejidad temporal |
| --- | --- | --- |
| Mejor caso | `n` | `O(n)` |
| Peor caso | `n` | `O(n)` |
| Caso promedio | `n` | `O(n)` |

La complejidad temporal siempre es `O(n)` porque el algoritmo necesita revisar
todas las posiciones para garantizar que ninguna ocurrencia quede sin contar.
La complejidad espacial adicional es `O(1)`, ya que solo se utilizan el
contador y la variable del recorrido. El vector recibido no se copia ni se
modifica.

## Estructura de archivos

- `ContarOcurrenciasVector.java`: contiene la clase `ContarOcurrenciasVector`,
  el metodo publico `contarOcurrencias`, las validaciones y los ejemplos de
  ejecucion.
- `README.md`: documenta el objetivo, la estrategia, la complejidad, los casos
  contemplados y la ejecucion del ejercicio.

## Casos contemplados

- **Vector `null`:** se lanza `IllegalArgumentException` con el mensaje `El
  vector no puede ser null.`.
- **Vector vacio:** se lanza `IllegalArgumentException` con el mensaje `El
  vector no puede estar vacio.`.
- **Valor inexistente:** se devuelve `0`.
- **Valor repetido:** se cuentan todas sus apariciones.
- **Vector con un elemento:** se devuelve `1` si coincide y `0` si no coincide.
- **Valores negativos y extremos de `int`:** se comparan correctamente.
- **Vector original:** no se modifica durante el recorrido.

## Ejemplo de uso

Para el vector `{8, -3, 12, 0, -3, 4, -3}`, el programa cuenta las
apariciones de `-3`:

```java
int[] vector = {8, -3, 12, 0, -3, 4, -3};
int cantidad = ContarOcurrenciasVector.contarOcurrencias(vector, -3);
```

El resultado es `3`. Aunque la primera coincidencia aparece al comienzo, el
algoritmo continua hasta el final para contar las dos coincidencias restantes.

## Como compilar y ejecutar

Desde la raiz del repositorio:

```powershell
cd Analisis_de_algoritmos\Ejercicio_5
javac ContarOcurrenciasVector.java
java ContarOcurrenciasVector
```

La ejecucion validada produjo:

```text
Ocurrencias de -3: 3
Ocurrencias de 8: 1
Valor inexistente: 0
Todas las posiciones coinciden: 3
Vector de un elemento: 1
Validacion correcta: El vector no puede ser null.
Validacion correcta: El vector no puede estar vacio.
```

## Decisiones de implementacion

No hay comentarios `DECISION` en el codigo fuente de este ejercicio. Por lo
tanto, no existen decisiones marcadas con esa etiqueta para transcribir.

Las decisiones observables directamente en el codigo son:

- Se eligio un recorrido lineal completo porque una coincidencia no permite
  descartar otras apariciones posteriores.
- Se utiliza un contador entero que aumenta por cada coincidencia.
- Se rechazan los vectores `null` y vacios mediante
  `IllegalArgumentException`.
- Se conserva el vector original sin ordenarlo, copiarlo ni modificarlo.
- Se utiliza `int[]` y se compara cada elemento con `==`, lo que permite
  trabajar con valores negativos y extremos de `int`.

## Informe final del ejecutador

La clase fue compilada y ejecutada correctamente con:

```powershell
Push-Location "Analisis_de_algoritmos\Ejercicio_5"; javac ContarOcurrenciasVector.java; if ($LASTEXITCODE -eq 0) { java ContarOcurrenciasVector }; Pop-Location
```

La ejecucion verifico el conteo de un valor repetido, un valor presente una
sola vez, un valor inexistente, un vector cuyos elementos coinciden, un vector
de un elemento y las validaciones para `null` y vector vacio.

## Limitaciones y pendientes

- El programa de demostracion utiliza vectores definidos en el codigo y no
  recibe datos mediante una interfaz interactiva.
- No se incluyen pruebas automatizadas separadas; los casos normales y borde
  se ejercitan desde `main`.
- Para cada consulta sobre un vector se realiza un recorrido completo. El
  codigo no construye una estructura auxiliar para responder muchas consultas,
  porque el ejercicio solicita contar las ocurrencias mediante el recorrido
  del vector.