package Algorithms.Graphs;

import Algorithms.Graphs.Tools.Edge;
import Algorithms.Graphs.Tools.EdgeWeightedGraph;
import Algorithms.WeightedQuickUnion;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: monco
 * Date: 09.05.13
 * Time: 11:41
 * To change this template use File | Settings | File Templates.
 */
public class BoruvkaMST {

    private Queue<Edge> MST;
    private double weight;

    private PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    private WeightedQuickUnion quickUnion;

    public BoruvkaMST(EdgeWeightedGraph G){
        quickUnion = new WeightedQuickUnion(G.V());
        MST = new ArrayDeque<Edge>(G.V() - 1);
        findMST(G);

    }

    public double weight(){
        return weight;
    }

    public Iterable<Edge> mst(){
        return MST;
    }

    private void findMST(EdgeWeightedGraph G){
        int k = G.E();
        while(MST.size() < G.V() - 1 && k != 0){
            k /= 2;
            Edge[] shortest = new Edge[G.V()];
            for(Edge e: G.edges()){
                int q = e.either();
                int p = e.other(q);
                int w = quickUnion.find(q);
                int v = quickUnion.find(p);
                if(w == v)
                    continue; //same Tree
                if(shortest[w] == null || e.weight() < shortest[w].weight())
                    shortest[w] = e;
                if(shortest[v] == null || e.weight() < shortest[v].weight())
                    shortest[v] = e;
            }
            for(int i = 0; i < G.V(); ++i)
                if(shortest[i] != null){
                    int q = shortest[i].either();
                    int p = shortest[i].other(q);
                    if(!quickUnion.connected(p,q)){
                        MST.add(shortest[i]);
                        weight += shortest[i].weight();
                        quickUnion.union(p,q);
                    }
                }
        }

    }
}
