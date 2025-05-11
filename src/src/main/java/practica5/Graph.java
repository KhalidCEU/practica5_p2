package practica5;

import java.util.*;

public class Graph<V>{

    //Lista de adyacencia.
    private Map<V, Set<V>> adjacencyList = new HashMap<>();

    /******************************************************************
    * Añade el vértice ` v` al grafo
    *
    * @param v vértice a añ adir.
    * @return ` true` si no estaba anteriormente y ` false` en caso
    * contrario.
    ******************************************************************/
    public boolean addVertex(V v) {
        if (adjacencyList.containsKey(v)) {
            return false;
        }
        adjacencyList.put(v, new HashSet<>());
        return true;
    }

    /******************************************************************
    * Añ ade un arco entre los vértices ` v1` y ` v2` al grafo. En
    * caso de que no exista alguno de los vértices, lo añ ade
    * tambié n.
    *
    * @param v1 el origen del arco.
    * @param v2 el destino del arco.
    * @return ` true` si no existí a el arco y ` false` en caso contrario.
    ******************************************************************/
    public boolean addEdge(V v1, V v2){
        // Añade los vértices (por si acaso no existen aún)
        addVertex(v1);
        addVertex(v2);

        // Si ya existe el arco, no lo añadimos
        if (adjacencyList.get(v1).contains(v2)) {
            return false;
        }
        adjacencyList.get(v1).add(v2);
        return true;
    }

    /******************************************************************
    * Obtiene el conjunto de vértices adyacentes a ` v`.
    *
    * @param v vértice del que se obtienen los adyacentes.
    * @return conjunto de vértices adyacentes.
    ******************************************************************/
    public Set<V> obtainAdjacents(V v) throws Exception{
        if (!adjacencyList.containsKey(v)) {
            throw new Exception("El vértice no existe en el grafo");
        }

        // Devolvemos una COPIA para evitar modifs en el grafo original
        Set<V> adjacencyListCopy = new HashSet<>(adjacencyList.get(v));
        return adjacencyListCopy;
    }

    /******************************************************************
    * Comprueba si el grafo contiene el vértice dado.
    *
    * @param v vértice para el que se realiza la comprobació n.
    * @return ` true` si ` v` es un vértice del grafo.
    ******************************************************************/
    public boolean containsVertex(V v){
        return adjacencyList.containsKey(v);
    }

    /******************************************************************
    * Mé todo ` toString()` reescrito para la clase ` Grafo. java`.
    * @return una cadena de caracteres con la lista de
    * adyacencia.
    ******************************************************************/

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (V v : adjacencyList.keySet()) {
            sb.append(v).append(": ").append(adjacencyList.get(v)).append("\n");
        }
        return sb.toString();
    }


    /**
    * Obtiene, en caso de que exista, el camino má s corto entre
    * ` v1` y ` v2`. En caso contrario, devuelve ` null`.
    *
    * @param v1 el vértice origen.
    * @param v2 el vértice destino.
    * @return lista con la secuencia de vértices del camino má s corto
    * entre ` v1` y ` v2`
    */
    public List<V> shortestPath(V v1, V v2){

        // Si de los dos vertices no existen en la lista
        if (!adjacencyList.containsKey(v1) || !adjacencyList.containsKey(v2)) {
            return null;    // no hay camino
        }

        // Usamos BFS (busqueda en anchura)
        Queue<V> queue = new ArrayDeque<>();
        Map<V, V> prev = new HashMap<>(); // nodos anteriores (para reconstruir camino)
        Set<V> visited = new HashSet<>(); // nodos visitados (para no revisitarlo)

        queue.add(v1);
        visited.add(v1);

        while (!queue.isEmpty()) {

            // Tomamos el actual (primer elem. de la queue)
            V current = queue.poll();

            // Si el actual es el que buscamos
            if (current.equals(v2)) {
                // Reconstruimos el camino
                List<V> path = new ArrayList<>();

                for (V at = v2; at != null; at = prev.get(at)) {
                    path.add(0, at);
                }

                return path;
            }

            // Si no, buscamos todos los adyacentes (nodos vecinos) del nodo actual
            for (V neighbor : adjacencyList.get(current)) {
                // si no se ha visitado el vecino aun
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);           // se marca como visitado
                    prev.put(neighbor, current);     // se guarda de donde venimos (adyacente, actual)
                    queue.add(neighbor);            // se añade a la cola (para explorarlo mas tarde)
                }
            }
        }
        // Si no hay camino...
        return null;
    }
}