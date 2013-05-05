package Graphs;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: d.poberezhny
 * Date: 10.04.13
 * Time: 16:12
 * To change this template use File | Settings | File Templates.
 */

/**
 * @author Dimitry Poberezhny
 */
interface Graph {
    Iterable<Integer> adj(int v);
    void add(int i, int j);
    int V();
    int E();
    boolean isDirected();
}