package Algorithms.Graphs.MST;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: monco
 * Date: 06.05.13
 * Time: 22:31
 * To change this template use File | Settings | File Templates.
 */
public class Prim{
    private Queue<Edge> MST;
    private double weight;

    EdgeWeightedGraph G;
    private boolean[] isMarked;
    private PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

    public Prim(EdgeWeightedGraph G){
        this.G = G;
        isMarked = new boolean[G.V];
        MST = new ArrayDeque<Edge>();
        for(int i = 0; i < G.V; ++i)
            if(!isMarked[i])
                findMST(i);
    }

    public double weight(){
        return weight;
    }

    public Iterable<Edge> mst(){
        return MST;
    }

    private void findMST(int vertex){
        scan(vertex);
        while(!pq.isEmpty()){
            Edge currentEdge = pq.poll();

            int v = currentEdge.either();
            int marked = isMarked[v] ? v : currentEdge.other(v);
            int unmarked = !isMarked[v] ? v : currentEdge.other(v);
            if(isMarked[unmarked])
                continue;

            weight += currentEdge.weight();
            MST.add(currentEdge);
            scan(unmarked);
        }
    }

    private void scan(int v){
        isMarked[v] = true;
        for(Edge edge: G.adj(v))
            if(!isMarked[edge.other(v)])
                pq.add(edge);
    }
}
