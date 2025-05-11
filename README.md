## Practica 5 - Programación 2

Esta práctica consiste en **calcular el camino más corto entre dos vértices** mediante la implementación de un **[grafo](https://es.wikipedia.org/wiki/Grafo)**.

<div align="center">
    <img width="50%" src="docs/assets/grafo.jpg"/>
</div>

La técnica usada en este caso es **BFS** ([Breadth-first search](https://es.wikipedia.org/wiki/B%C3%BAsqueda_en_anchura)) o "**búsqueda en anchura**". Tambien se hace uso de [TDD](/src/src/test/java/practica5/AppTest.java) (desarrollo digido por pruebas).

> [Aquí](/src/src/main/java/practica5/Graph.java) se encuentra el **fichero principal** que contiene la implementación del grafo y, entre otros métodos, su método de **búsqueda**.

> Para los tests del camino mas corto, [aquí](/docs/pruebas/) se puede encontrar una representación de esos grafos.

### Uso

Para compilar el programa y ejecutarlo (incluye la ejecución de tests) :

```
make maven_run
```

Para ejecutar únicamente los tests :

```
make maven_test
```

Para generar documentación con **Javadoc** :

```
make maven_javadoc
```
> Esto generará un directorio "javadoc" en la raìz.


### Diagrama UML

<br>

<p align="center">
  <img src="http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/KhalidCEU/practica5_p2/refs/heads/main/docs/diagram.puml" alt="Class Diagram" width=30%>
</p>

### Licencia

Este proyecto está licenciado bajo la Licencia [Apache 2.0](/LICENSE)