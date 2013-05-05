package Graphs;

/**
 * Created with IntelliJ IDEA.
 * User: d.poberezhny
 * Date: 11.04.13
 * Time: 11:01
 * To change this template use File | Settings | File Templates.
 */
public class DepthFirstSearch{
    Graph graph;
    boolean[] isDiscovered;
    boolean[] isProccessed;
    int[] parentVertex;
    GraphProcessor graphProcessor;

    public DepthFirstSearch(Graph G, GraphProcessor processor){
        graph = G;
        isDiscovered = new boolean[graph.V()];
        isProccessed = new boolean[graph.V()];
        parentVertex = new int[graph.V()];
        graphProcessor = processor;
        for(int i = 0;i < graph.V(); ++i){
            if(!isDiscovered[i])
                dfs(i);

        }
    }

    private void dfs(int start){
        isDiscovered[start] = true;
        graphProcessor.processVertexEarly(start);

        for(int vertex: graph.adj(start)){
            if(isDiscovered[vertex])
                continue;
            parentVertex[vertex] = start;
            graphProcessor.pocessEdge(start, vertex);
            dfs(vertex);
        }
        isProccessed[start] = true;
        graphProcessor.processVertexLate(start);
    }
}
