package Algorithms.Graphs;

import Algorithms.Graphs.Tools.DirectedEdge;
import Algorithms.Graphs.Tools.EdgeWeightedDigraph;

import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.TreeMap;

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
//    private PriorityQueue<VertexWrapper> pq;
    SortedMap<Double,Integer> sortedMap;


    public DijkstraSPT(EdgeWeightedDigraph G, int start){
        distTo = new double[G.V()];
        for(int i = 0; i < G.V(); ++i)
            distTo[i] = Double.MAX_VALUE;
        distTo[start] = 0.0;


        sortedMap = new TreeMap<Double, Integer>();
        sortedMap.put(distTo[start], start);
        while(!sortedMap.isEmpty()){

        }

//        pq = new PriorityQueue<VertexWrapper>();
//        pq.add(new VertexWrapper(start,distTo[start]));
//        while(!pq.isEmpty()){
//            VertexWrapper vw = pq.poll();
//            int v = vw.vertex;
//            for(DirectedEdge e: G.adj(v)){
//                int to = e.to();
//                if(distTo[v] + e.weight() < distTo[to]){
//                    distTo[to] = distTo[v] + e.weight();
//                }
//            }
//        }


    }

    public boolean isPath(int v){
        return distTo[v] != Double.MAX_VALUE;
    }

    public Iterable<DirectedEdge> shortPathTo(int v){
        if(isPath(v))
            return null;
        return null;
    }
}
