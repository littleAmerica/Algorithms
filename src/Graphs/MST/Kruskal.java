package Graphs.MST;

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

    private EdgeWeightedGraph G;
    private int V;
    private boolean[] isMarked;
    private PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

    public Kruskal(EdgeWeightedGraph G){
        this.G = G;
        this.V = G.V;
        isMarked = new boolean[G.V];
        MST = new ArrayDeque<Edge>(V - 1);

        for(Edge edge: G.edges()){
            pq.add(edge);
        }

        while( !pq.isEmpty() && MST.size() < V){
            Edge currentEdge = pq.poll();
            int v = currentEdge.either();
            int w = currentEdge.other(v);
            if(isMarked[v] && isMarked[w])
                continue;
            isMarked[v] = true;
            isMarked[w] = true;
            MST.add(currentEdge);
            weight += currentEdge.weight();
        }
    }



    public double weight(){
        return weight;
    }

    public Iterable<Edge> mst(){
        return MST;
    }
}
