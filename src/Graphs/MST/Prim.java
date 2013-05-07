package Graphs.MST;

/**
 * Created with IntelliJ IDEA.
 * User: monco
 * Date: 06.05.13
 * Time: 22:31
 * To change this template use File | Settings | File Templates.
 */
public class Prim{
    private EdgeWeightedGraph G;
    private int V;
    private Edge[] MST;
    private boolean[] isMarked;

    public Prim(EdgeWeightedGraph G){
        this.G = G;
        this.V = G.V;
        isMarked = new boolean[G.V];
        MST = new Edge[V];
        for(int i = 0; i < V; ++i)
            if(!isMarked[i])
                prim(i);
    }

    private void prim(int w){

    }
}
