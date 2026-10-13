# Ejercicio 3: busqueda binaria en un vector ordenado

## Objetivo

Implementar en Java una busqueda binaria iterativa para buscar un elemento en
un vector de enteros ordenado ascendentemente y mostrar paso a paso la
evolucion de las variables de busqueda.

## Estrategia elegida

Se utiliza busqueda binaria porque el vector esta ordenado. En cada iteracion
se compara el elemento buscado con el valor ubicado en `medio` y se descarta
la mitad que no puede contenerlo. Por eso, el nucleo de la busqueda tiene
complejidad temporal `O(log n)`, mientras que una busqueda lineal puede
recorrer todo el vector y tiene complejidad `O(n)` en el peor caso.

La implementacion es iterativa y utiliza espacio adicional `O(1)`. Si hay
elementos repetidos, continua hacia la izquierda despues de encontrar una
coincidencia para devolver la primera aparicion.

## Complejidad

| Operacion | Complejidad temporal | Complejidad espacial |
| --- | --- | --- |
| Validar que el vector este ordenado | `O(n)` | `O(1)` |
| Busqueda binaria | `O(log n)` | `O(1)` |
| Metodo completo, incluyendo validacion | `O(n)` | `O(1)` |

La validacion se realiza porque la busqueda binaria solo es correcta si el
vector esta ordenado ascendentemente. Si el orden se garantiza externamente,
el algoritmo de busqueda propiamente dicho mantiene la complejidad `O(log n)`.

## Traza

En cada iteracion se muestran:

- `inicio`: primer indice del intervalo actual;
- `fin`: ultimo indice del intervalo actual;
- `medio`: indice central calculado sin riesgo de overflow;
- `valorMedio`: valor comparado con el elemento buscado;
- la decision de buscar a la izquierda, a la derecha o continuar hacia la
	izquierda para obtener la primera aparicion.

## Casos borde contemplados

- vector `null`: lanza `IllegalArgumentException`;
- vector vacio: lanza `IllegalArgumentException`;
- vector no ordenado ascendentemente: lanza `IllegalArgumentException`;
- vector con un elemento: devuelve su indice o `-1`;
- elemento al inicio, en el medio o al final;
- elemento inexistente: devuelve `-1`;
- elementos repetidos: devuelve la primera aparicion;
- valores extremos de `int`, incluido `Integer.MIN_VALUE`;
- el vector original no se modifica.

## Estructura de archivos

- `BusquedaBinaria.java`: contiene la busqueda binaria, la validacion del
	vector, la traza y los ejemplos de ejecucion.
- `README.md`: documenta la estrategia, la complejidad, las decisiones y la
	verificacion realizada.

## Como compilar y ejecutar

Desde la raiz del repositorio:

```powershell
Push-Location "Analisis_de_algoritmos\Ejercicio_3"; javac BusquedaBinaria.java; if ($LASTEXITCODE -eq 0) { java BusquedaBinaria }; Pop-Location
```

## Decisiones de implementacion

Las decisiones marcadas en el codigo son:

- `BusquedaBinaria.java`: exigir orden ascendente porque la busqueda binaria
	solo puede descartar mitades si el vector esta ordenado.
- `BusquedaBinaria.java`: usar sintaxis compatible con Java 17 o superior
	porque el proyecto no define una version de Java y se adopta una version
	LTS moderna.

Estas dos decisiones corresponden exactamente a los comentarios `// DECISION:`
ubicados en la primera linea del archivo y dentro de `validarVector`.

Otras decisiones observables en el codigo:

- se devuelve la primera aparicion de un elemento repetido;
- se devuelve `-1` si el elemento no existe;
- se calcula `medio` como `inicio + (fin - inicio) / 2`;
- se rechazan vectores `null`, vacios o desordenados;
- se muestra la traza durante cada busqueda;
- no se modifica el vector recibido.

## Informe final del ejecutador

La clase fue compilada y ejecutada correctamente con:

```powershell
Push-Location "Analisis_de_algoritmos\Ejercicio_3"; javac BusquedaBinaria.java; if ($LASTEXITCODE -eq 0) { java BusquedaBinaria }; Pop-Location
```

La ejecucion verifico los siguientes resultados:

```text
Busqueda al inicio: 0
Busqueda en el medio: 3
Busqueda al final: 6
Busqueda inexistente: -1
Primera coincidencia: 1
Busqueda en un elemento: 0
Validacion correcta: El vector no puede ser null.
Validacion correcta: El vector no puede estar vacio.
Validacion correcta: El vector debe estar ordenado ascendentemente.
```

La salida de traza tambien incluyo, para cada iteracion, lineas con el formato
`Traza: inicio=..., fin=..., medio=..., valorMedio=...` y una linea `Decision:`
que indica el siguiente intervalo elegido.

Ademas, la salida mostro en cada iteracion los valores de `inicio`, `fin`,
`medio`, `valorMedio` y la decision tomada. La compilacion y ejecucion
confirman la busqueda al inicio, medio y final, un elemento inexistente, la
primera coincidencia entre repetidos, un vector de un elemento y las tres
validaciones de entrada.

La clase y sus metodos publicos cuentan con Javadoc.

La compilacion genero `BusquedaBinaria.class`, un archivo derivado que no es
parte del codigo fuente.

## Limitaciones y pendientes

- La validacion del orden hace que el metodo completo tenga `O(n)` temporal;
	la busqueda binaria aislada mantiene `O(log n)`.
- No se incluyen pruebas automatizadas separadas; los casos se ejercitan
	desde `main`.
- La traza se imprime siempre durante la busqueda, por lo que una ejecucion
	con muchas consultas genera salida adicional.
