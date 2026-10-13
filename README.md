# Estructura de Datos y Algoritmos

Repositorio para el estudio, análisis e implementación de estructuras de datos y algoritmos en Java, basado en guías prácticas y ejercicios resueltos de la asignatura de Estructuras de Datos y Algoritmos.

## Lenguaje de programación

Las implementaciones y ejemplos del repositorio están desarrollados en Java.

## Temas incluidos

El repositorio actual contiene ejercicios y soluciones organizados por bloques temáticos:

- Análisis de algoritmos.
- Recursividad.
- Algoritmos de ordenamiento.
- Pilas y colas implementadas con arreglos.
- Pilas y colas implementadas con listas enlazadas.
- Listas enlazadas simples.

## Organización del repositorio

Cada tema se encuentra en una carpeta independiente. Dentro de cada una hay varios ejercicios, normalmente con clases Java y, en muchos casos, un README propio que explica el objetivo, la estrategia y la ejecución del ejercicio.

La estructura general del proyecto es la siguiente:

```text
.
├── .github/
│   └── agents/
├── Analisis_de_algoritmos/
│   ├── Ejercicio_1/
│   ├── Ejercicio_2/
│   ├── ...
│   └── Ejercicio_10/
├── Algoritmos_de_ordenamiento/
│   ├── Ejercicio01_BurbujaPasoAPaso/
│   ├── Ejercicio02_ComparacionBurbujaSeleccion/
│   ├── ...
│   └── Ejercicio10_RankingPuntajes/
├── Listas_enlazadas_simples/
│   ├── Ejercicio1/
│   ├── Ejercicio2/
│   ├── ...
│   └── Ejercicio_9/
├── Pilas_y_colas_con_arreglos/
│   ├── Ejercicio1/
│   ├── Ejercicio2/
│   ├── ...
│   └── Ejercicio_10/
├── Pilas_y_colas_con_listas_enlazadas/
│   ├── Ejercicio_1/
│   ├── Ejercicio_2/
│   ├── ...
│   └── Ejercicio_9/
├── Recursividad/
│   ├── Ejercicio_1/
│   ├── Ejercicio_2/
│   ├── ...
│   └── Ejercicio_10/
├── README.md
├── .gitignore
└── ...
```

## Uso del repositorio

Cada ejercicio puede ejecutarse de forma independiente desde su carpeta correspondiente. En la mayoría de los casos se compila con `javac` y se ejecuta con `java`:

```bash
cd <carpeta_del_ejercicio>
javac NombreArchivo.java
java NombreArchivo
```

Por ejemplo:

```bash
cd Analisis_de_algoritmos/Ejercicio_1
javac MinimoVector.java
java MinimoVector
```

## Estructura de cada ejercicio

Los ejercicios suelen seguir una organización similar:

```text
Tema/
└── Ejercicio/
    ├── Archivo.java
    ├── README.md (según el ejercicio)
    └── salida o ejemplos de ejecución
```

Algunos ejercicios incluyen documentación adicional con:

- objetivo del problema,
- estructura de datos utilizada,
- algoritmo propuesto,
- complejidad,
- casos borde,
- validaciones y ejemplos de ejecución.

## Ramas

- `main`: rama principal y estable del repositorio.
- `develop`: rama de integración para organizar cambios durante el desarrollo.
- `features/*`: ramas orientadas a la implementación de nuevos temas, guías o ejercicios.

Las nuevas soluciones y funcionalidades se desarrollan en ramas `features/*`, luego se integran en `develop`, y se elimina la rama. Cuando el contenido queda estable, se incorpora a `main`.

## Estado del proyecto

En desarrollo.

## Nota

El repositorio está pensado como una colección de ejercicios prácticos, por lo que la documentación y el código están distribuidos en distintos directorios según el tema. La revisión de cada README asociado ayuda a comprender el enunciado, la estrategia elegida y la validación del ejercicio.
