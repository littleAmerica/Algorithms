package Algorithms.Graphs;

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
public class Graph {

    private LinkedList<Integer> edgenodes[];
    private boolean isDirected;
    private int E;
    final private int V;

    public Graph(int V, boolean isDirected)
    {
        if(V <= 0) throw new IllegalArgumentException("Negative V");
        this.V = V;
        this.isDirected = isDirected;

        edgenodes = (LinkedList<Integer>[]) new LinkedList[V];
        for(int i = 0; i < V; ++i)
            edgenodes[i] = new LinkedList<Integer>();
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public boolean isDirected(){
        return isDirected;
    }

    public Iterable<Integer> adj(int v) {
        return edgenodes[v];
    }

    public void add(int i, int j){
        if(i > 0 && j > 0 && i < V && j < V )
            throw new IllegalArgumentException("Graph.add(" + i + "," + j + ") Out of range");
        add_elem(i,j);
        if(!isDirected)
            add_elem(j,i);
    }

    private void add_elem(int i, int j){
        if (edgenodes[i].contains(j))
            return;
        edgenodes[i].add(j);
        E++;
    }


}
