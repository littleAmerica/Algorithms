package Algorithms.Graphs;

import Algorithms.Graphs.Tools.DirectedEdge;
import Algorithms.Graphs.Tools.EdgeWeightedDigraph;
import com.sun.javafx.css.FontUnits;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: d.poberezhny
 * Date: 16.05.13
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
public class BellmanFordSP {
    double[] distTo;
    DirectedEdge[] edgeTo;

    public BellmanFordSP(EdgeWeightedDigraph G, int start){
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];

        for (int i = 0; i < G.V(); ++i)
            distTo[i] = Double.MAX_VALUE;
        distTo[start] = 0.0;

        int iterationCount = 0;
        boolean isOptimal = false;
        while(!isOptimal){
            isOptimal = relaxation(G);
            if(++iterationCount > G.V() - 1) throw new IllegalArgumentException("There is negative loop");
        }


    }

    public boolean isPath(int v){
        return distTo[v] != Double.MAX_VALUE;
    }

    private boolean relaxation(EdgeWeightedDigraph G){
        boolean isOptimal = true;
        for (DirectedEdge e: G.edges()){
            if(distTo[e.to()] > distTo(e.from()) + e.weight()){
                edgeTo[e.to()] = e;
                distTo[e.to()] = distTo(e.from()) + e.weight();
                isOptimal = false;
            }
        }
        return isOptimal;
    }

    public Iterable<DirectedEdge> pathTo(int v){
        if(!isPath(v))
            return null;
        Deque<DirectedEdge> path = new LinkedList<DirectedEdge>();
        DirectedEdge e = edgeTo[v];
        while(e != null){
            path.addFirst(e);
            e = edgeTo[e.from()];
        }
        return path;
    }

    public Iterable<DirectedEdge> pathToR(int v){
        if(!isPath(v))
            return null;
        Deque<DirectedEdge> path = new LinkedList<DirectedEdge>();
        DirectedEdge e = edgeTo[v];
        while(e != null){
            path.addLast(e);
            e = edgeTo[e.from()];
        }
        return path;
    }

    public double distTo(int v){
        return distTo[v];
    }

    private boolean hasNegativeWeight(EdgeWeightedDigraph G){
        for(DirectedEdge e: G.edges())
            if(e.weight() < 0.0)
                return false;
        return true;
    }

}
