package Algorithms.Graphs.MST;

/**
 * Created with IntelliJ IDEA.
 * User: monco
 * Date: 06.05.13
 * Time: 17:59
 * To change this template use File | Settings | File Templates.
 */
public class Edge implements Comparable<Edge> {
    private int w;
    private int v;
    private double weight;

    public Edge(int w, int v, double weight){
        this.w = w;
        this.v = v;
        this.weight = weight;
    }

    public double weight(){
        return weight;
    }

    public int either(){
        return v;
    }

    public int other(int vertex){
        if(vertex == v) return w;
        else if(vertex == w) return v;
        else throw new IllegalArgumentException("Illegal vertex in edge");
    }

    @Override
    public int compareTo(Edge other) {
        if(this.weight < other.weight()) return -1;
        else if(this.weight > other.weight()) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return w + " " + v + " :" + weight;
    }
}
