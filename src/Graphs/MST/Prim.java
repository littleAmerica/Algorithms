package Graphs.MST;

/**
 * Created with IntelliJ IDEA.
 * User: monco
 * Date: 06.05.13
 * Time: 22:31
 * To change this template use File | Settings | File Templates.
 */
public class Prim {
    private EdgeWeightedGraph G;
    private int V;
    private Edge[] MST;

    public Prim(EdgeWeightedGraph G){
        this.G = G;
        V = this.V;
        MST = new Edge[V];
    }
}
