package Algorithms.Graphs.MST;

import Algorithms.WeightedQuickUnion;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: d.poberezhny
 * Date: 07.05.13
 * Time: 18:36
 * To change this template use File | Settings | File Templates.
 */
public class Kruskal{

    private Queue<Edge> MST;
    private double weight;

    private PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    private WeightedQuickUnion quickUnion;

    public Kruskal(EdgeWeightedGraph G){
        quickUnion = new WeightedQuickUnion(G.V);
        MST = new ArrayDeque<Edge>(G.V - 1);
        findMST(G);
    }

    public double weight(){
        return weight;
    }

    public Iterable<Edge> mst(){
        return MST;
    }

    private void findMST(EdgeWeightedGraph G){
        for(Edge edge: G.edges()){
            pq.add(edge);
        }

        while( !pq.isEmpty() && MST.size() < G.V){
            Edge currentEdge = pq.poll();
            int v = currentEdge.either();
            int w = currentEdge.other(v);
            if(quickUnion.connected(w,v))
                continue;
            quickUnion.union(w,v);
            MST.add(currentEdge);
            weight += currentEdge.weight();
        }
    }
}
