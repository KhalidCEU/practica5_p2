## Practica 5 - Programación 2


Esta practica consiste **calcular del camino más corto entre dos vértices** (mediante implementación de un **[grafo](https://es.wikipedia.org/wiki/Grafo)**)

<div align="center">
    <img width="60%" src="docs/assets/grafo.jpg"/>
</div>

La técnica usada en este caso es **BFS** ([Breadth-first search](https://es.wikipedia.org/wiki/B%C3%BAsqueda_en_anchura)) o "**búsqueda en anchura**". Tambien se hace uso de [TDD](/src/src/test/java/practica5/AppTest.java) (desarrollo digido por pruebas).

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