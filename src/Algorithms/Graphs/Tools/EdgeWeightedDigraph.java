package Algorithms.Graphs.Tools;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: monco
 * Date: 06.05.13
 * Time: 18:29
 * To change this template use File | Settings | File Templates.
 */
public class EdgeWeightedDigraph {
    private LinkedList<DirectedEdge>[] adj;
    private int V;
    private int E = 0;

    public EdgeWeightedDigraph(int V){
        if(V < 0) throw new IllegalArgumentException("Negative V");
        this.V = V;
        adj = (LinkedList<DirectedEdge>[])new LinkedList[V];
        for(int i = 0; i < V; ++i)
            adj[i] = new LinkedList<DirectedEdge>();
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges(){
        List<DirectedEdge> list = new ArrayList<DirectedEdge>(E/2);
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj(v)) {
                    list.add(e);
            }
        }
        return list;
    }

    public void add(DirectedEdge e){
        int i = e.from();
        adj[i].push(e);
        E++;
    }
}
