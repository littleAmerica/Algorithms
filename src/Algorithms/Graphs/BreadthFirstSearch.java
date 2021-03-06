package Algorithms.Graphs;

import Algorithms.Graphs.Tools.Graph;
import Algorithms.Graphs.Tools.GraphProcessor;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: d.poberezhny
 * Date: 10.04.13
 * Time: 17:08
 * To change this template use File | Settings | File Templates.
 */
public class BreadthFirstSearch{
    boolean[] isDiscovered;
    boolean[] isProccessed;
    int[] parentVertex;

    Graph G;
    GraphProcessor graphProcessor;

    public BreadthFirstSearch(Graph G, int startV){
        this(G,startV,new GraphProcessor());
    }

    public BreadthFirstSearch(Graph G, int startV, GraphProcessor processor){
        this.G = G;
        isDiscovered = new boolean[G.V()];
        isProccessed = new boolean[G.V()];
        parentVertex = new int[G.V()];
        graphProcessor = processor;
        bfs(startV);
    }

    private void bfs(int start){
        isDiscovered[start] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        while(!queue.isEmpty()){
            int current = queue.remove();
            graphProcessor.processVertexEarly(current);
            if(isDiscovered[current])
                continue;
            for(Integer vertex: G.adj(current)){
                if(isProccessed[vertex])
                    continue;
                parentVertex[vertex] = current;
                graphProcessor.pocessEdge(current,vertex);
                queue.add(vertex);
                isDiscovered[vertex] = true;
            }
            graphProcessor.processVertexLate(current);
            isProccessed[start] = true;
        }
    }
}
