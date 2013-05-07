package Graphs.MST;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: monco
 * Date: 06.05.13
 * Time: 18:29
 * To change this template use File | Settings | File Templates.
 */
public class EdgeWeightedGraph {
    private LinkedList<Edge>[] adj;
    int V;
    int E = 0;
    double weight = 0;
    
    public EdgeWeightedGraph(int V){
        if(V < 0) throw new IllegalArgumentException("Negative V");
        this.V = V;
        adj = (LinkedList<Edge>[])new LinkedList[V];
        for(int i = 0; i < V; ++i)
            adj[i] = new LinkedList<Edge>();
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public void add(Edge e){
        int i = e.either();
        int j = e.other(i);
        assert i < V && j < V : "Graph.add(" + i + "," + j + ") Out of range";

        adj[i].push(e);
        adj[j].push(e);
        weight += e.weight();
        E++;
    }
}
