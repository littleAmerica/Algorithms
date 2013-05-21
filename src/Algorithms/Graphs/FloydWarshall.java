package Algorithms.Graphs;

import Algorithms.Graphs.Tools.DirectedEdge;
import Algorithms.Graphs.Tools.Edge;
import Algorithms.Graphs.Tools.EdgeWeightedDigraph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: d.poberezhny
 * Date: 15.05.13
 * Time: 10:30
 * To change this template use File | Settings | File Templates.
 */
public class FloydWarshall {
    double[][] distTo;
    DirectedEdge[][] edgeTo;

    public FloydWarshall(EdgeWeightedDigraph G){
        distTo = new double[G.V()][G.V()];
        edgeTo = new DirectedEdge[G.V()][G.V()];

        for (int i = 0; i < G.V(); ++i)
            for (int j = 0; j < G.V(); ++j){
                distTo[i][j] = Double.MAX_VALUE;
            }

        for (DirectedEdge e: G.edges()){
            distTo[e.from()][e.to()] = e.weight();
            edgeTo[e.from()][e.to()] = e;
        }

        for(int i = 0; i < G.V(); ++i){
            distTo[i][i] = 0.0;
        }


        for (int k = 0; k < G.V(); ++k){
            System.out.println("\nk = " + k);
            for(int i = 0; i < G.V(); ++i)   {
                for (int j = 0; j < G.V(); ++j)
                    System.out.print(distTo[i][j] == Double.MAX_VALUE ? "X  " :distTo[i][j] + " ");
                System.out.println();
            }
            for (int i = 0; i < G.V(); ++i)   {
                for(int j = 0; j < G.V(); ++j) {
                    if(distTo[i][k] + distTo[k][j] < distTo[i][j]){
                        distTo[i][j] = distTo[i][k] + distTo[k][j];
                        edgeTo[i][j] = edgeTo[k][j];
                    }
                }
                if(distTo[i][i] < 0.0) throw new IllegalArgumentException("Negative cycle exist");
            }
        }

        for(int i = 0; i < G.V(); ++i)   {
            for (int j = 0; j < G.V(); ++j)
                System.out.print(distTo[i][j] == Double.MAX_VALUE ? " X " :distTo[i][j] + " ");
            System.out.println();
        }
    }

    public double distTo(int i, int j){
        return distTo[i][j];
    }

    public boolean isPathTo(int i, int j){
        return distTo[i][j] != Double.MAX_VALUE;
    }

    public Iterable<DirectedEdge> pathTo(int i, int j){
        Deque<DirectedEdge> deque = new LinkedList<DirectedEdge>();
        DirectedEdge e = edgeTo[i][j];
        while (e != null){
            deque.addLast(e);
            e = edgeTo[i][e.from()];
        }
        return deque;
    }
}
