package Algorithms.Graphs.Tools;

/**
 * Created with IntelliJ IDEA.
 * User: monco
 * Date: 11.05.13
 * Time: 14:56
 * To change this template use File | Settings | File Templates.
 */
public class DirectedEdge implements Comparable<DirectedEdge> {

    private int from;
    private int to;
    private double weight;

    public DirectedEdge(int from, int to, double weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public double weight(){
        return weight;
    }

    public int from(){
        return from;
    }

    public int to(){
        return to;
    }

    @Override
    public int compareTo(DirectedEdge other) {
        if(this.weight < other.weight()) return -1;
        else if(this.weight > other.weight()) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return from + "->" + to + " w: " + weight;
    }

}
