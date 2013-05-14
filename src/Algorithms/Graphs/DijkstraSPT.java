package Algorithms.Graphs;

import Algorithms.Graphs.Tools.DirectedEdge;
import Algorithms.Graphs.Tools.EdgeWeightedDigraph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: monco
 * Date: 11.05.13
 * Time: 18:17
 * To change this template use File | Settings | File Templates.
 */
public class DijkstraSPT {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private PriorityQueue<VertexMark> pq;


    public DijkstraSPT(EdgeWeightedDigraph G, int start){
        if(hasNegativeWeight(G))
            throw new IllegalArgumentException("Graph has negative weight");
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        for(int i = 0; i < G.V(); ++i)
            distTo[i] = Double.MAX_VALUE;
        distTo[start] = 0.0;

        pq = new PriorityQueue<VertexMark>();
        pq.add(new VertexMark(start,distTo[start]));
        while(!pq.isEmpty()){
            VertexMark smallest = pq.poll();
            int current = smallest.vertex;
            for(DirectedEdge edge: G.adj(current)){
                int to = edge.to();
                if(distTo[current] + edge.weight() < distTo[to]){
                    distTo[to] = distTo[current] + edge.weight();
                    edgeTo[to] = edge;
                    VertexMark next = new VertexMark(to,distTo[to]);
                    pq.remove(next);
                    pq.add(next);
                }
            }
        }
    }

    public boolean isPath(int v){
        return distTo[v] != Double.MAX_VALUE;
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


    private class VertexMark implements Comparable<VertexMark>{
        int vertex;
        double weight;

        @Override
        public boolean equals(Object obj) {
//            return super.equals(obj);    //To change body of overridden methods use File | Settings | File Templates.
            if(obj == null || !(obj instanceof VertexMark))
                return false;
            else
                return ((VertexMark) obj).vertex == vertex;
        }

        VertexMark(int vertex, double weight){
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(VertexMark o) {
            if(weight < o.weight) return -1;
            else if(weight > o.weight) return 1;
            else return 0;
        }
    }
}
