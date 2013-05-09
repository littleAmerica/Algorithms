package Algorithms.Graphs;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: monco
 * Date: 04.05.13
 * Time: 12:33
 * To change this template use File | Settings | File Templates.
 */
public class TopologicalSort extends GraphProcessor{
    Graph graph;
    ArrayList<Integer> processedOrder = new ArrayList<Integer>();

    public TopologicalSort(Graph graph){
        this.graph = graph;
        assert graph.isDirected() : "Graph isn't directed";
        DepthFirstSearch dfs = new DepthFirstSearch(graph, this);
    }

    @Override
    protected void processVertexLate(int v) {
        processedOrder.add(v);
    }

    public Iterable<Integer> order(){
        return processedOrder;
    }
}
