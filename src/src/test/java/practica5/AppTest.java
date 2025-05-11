package practica5;

import java.util.*;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{

    private Graph<Integer> grafo = new Graph<>();

    /********************************\
    /********** addVertex **********\
    /********************************\

    /* Test addVertex 1 */
    /* Esperado : true */
    public void testAddVertex() {
        assertTrue(grafo.addVertex(1));
    }

    /* Test addVertex 2 */
    /* Intentar añadir un vertice ya existente */
    /* Esperado : false */
    public void testAddVertex2() {
        grafo.addVertex(1);
        assertFalse(grafo.addVertex(1));
    }

    /* Test addVertex 3 */
    /* Prueba grafo de otro tipo que Integer */
    /* Esperado : true */
    public void testAddVertex3() {
        Graph<Character> grafo2 = new Graph<>();
        assertTrue(grafo2.addVertex('a'));
    }



    /********************************\
    /********** addEdge *************\
    /********************************\

    /* Test addEdge */
    /* Caso, creacion nuevo arco */
    /* Esperado : true */

    private Integer i1 = 1;
    private Integer i2 = 2;
    private Integer i3 = 3;

    public void testaddEdge() {
        grafo.addVertex(i1);
        grafo.addVertex(i2);
        assertTrue(grafo.addEdge(i1, i2));
    }

    /* Test addEdge  */
    /* Caso, añadido arco ya existente */
    /* Esperado : false */
    public void testaddEdge2() {
        grafo.addEdge(i1, i2); // la primera vez daría true
        assertFalse(grafo.addEdge(i1, i2)); // esta false
    }



    /********************************\
    /******* obtainAdjacents ********\
    /********************************\

    /* Test obtainAdjacents */
    /* Contiene adyacentes */
    /* Esperado : true (1 adyacente) */
    public void testObtainAdjacents() {
        grafo.addVertex(i1);
        grafo.addVertex(i2);
        grafo.addEdge(i1, i2);

        try {
            Set<Integer> adj = grafo.obtainAdjacents(i1);
            assertTrue(adj.contains(i2));       // contiene el vertice 2
            assertEquals(1, adj.size()); // // i1 tiene unicamente 1 adyacente (i2)
        } catch (Exception e) {
            fail("Excepcion: " + e.getMessage());
        }
    }

    /* Test obtainAdjacents 2 */
    /* Nos retorna el buen numero de adyacentes ?*/
    /* Esperado : true (3 adyacentes) */
    public void testObtainAdjacents2() {
        grafo.addVertex(i1);
        grafo.addVertex(i2);
        grafo.addVertex(i3);
        grafo.addEdge(i1, i2);
        grafo.addEdge(i1, i3);

        try {
            Set<Integer> adj = grafo.obtainAdjacents(i1);
            assertTrue(adj.contains(i2));       // contiene el vertice 2
            assertTrue(adj.contains(i3));       // contiene el vertice 3
            assertEquals(2, adj.size()); // // i1 tiene unicamente 2 adyacentes (i2 e i3)
        } catch (Exception e) {
            fail("Excepcion: " + e.getMessage());
        }
    }

    /* Test obtainAdjacents 3 */
    /* Nos retorna el buen numero de adyacentes ?*/
    /* Esperado : false (2 adyacentes)*/
    public void testObtainAdjacents3() {
        grafo.addVertex(i1);
        grafo.addVertex(i2);
        grafo.addVertex(i3);
        grafo.addEdge(i1, i2);
        grafo.addEdge(i1, i3);

        try {
            Set<Integer> adj = grafo.obtainAdjacents(i1);
            assertTrue(adj.contains(i2));       // contiene el vertice 2
            assertTrue(adj.contains(i3));       // contiene el vertice 3
            assertFalse(0 == adj.size());       // no tiene 0 adyacentes, deberia fallar
        } catch (Exception e) {
            fail("Excepcion: " + e.getMessage());
        }
    }


    /********************************\
    /******** containsVertex ********\
    /********************************\

    /* Test containsVertex */
    /* Caso normal, contiene un vertice añadido */
    /* Esperado : true */
    public void testContainsVertex() {
        grafo.addVertex(i1);
        assertTrue(grafo.containsVertex(i1));
    }


    /* Test containsVertex 2 */
    /* No contiene un vertice no añadido */
    /* Esperado : false */
    public void testContainsVertex2() {
        assertFalse(grafo.containsVertex(i2));
    }


    /* Test containsVertex 3 */
    /* Añadido de vertices automatico, mediante addEdge */
    /* addEdge debería añadirnos los 2 vertices si no existen */
    /* Esperado : true */
    public void testContainsVertex3() {
        grafo.addEdge(i1, i2);
        assertTrue(grafo.containsVertex(i1));
        assertTrue(grafo.containsVertex(i2));
    }



    /********************************\
    /********** shortestPath ********\
    /********************************\

    /* Test camino mas corto */
    public void testShortestPathFindsAPath() {
        System.out.println("\nTest shortestPathFindsAPath");
        System.out.println("----------------------------");

        Graph<Integer> g = new Graph<>();
        g.addEdge(1, 2);
        g.addEdge(1, 5);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(5, 4);

        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(1);
        expectedPath.add(5);
        expectedPath.add(4);

        assertEquals(expectedPath, g.shortestPath(1, 4));
    }

    /* Test camino mas corto 2 */
    /* No hay relacione ntre 4 y 7 */
    /* Esperado : null */
    public void testShortestPathFindsAPath2() {

        Graph<Integer> g = new Graph<>();
        g.addEdge(1, 3);
        g.addEdge(1, 7);
        g.addEdge(3, 4);
        g.addEdge(7, 8);
        g.addEdge(8, 9);


        assertEquals(null, g.shortestPath(4, 7));
    }

    /* Test camino mas corto 3 */
    /* Esperado : true (el camino mas corto entre 4 y 11 */
    /*                  aqui es 4 -> 8 -> 3 -> 11  */
    public void testShortestPathFindsAPath3() {

        Graph<Integer> g = new Graph<>();
        g.addEdge(4, 8);
        g.addEdge(4, 6);
        g.addEdge(6, 9);
        g.addEdge(6, 10);
        g.addEdge(6, 5);
        g.addEdge(8, 6);
        g.addEdge(8, 3);
        g.addEdge(3, 11);

        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(4);
        expectedPath.add(8);
        expectedPath.add(3);
        expectedPath.add(11);

        assertEquals(expectedPath, g.shortestPath(4, 11));
    }
}
