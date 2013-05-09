package Algorithms;

/**
 * Created with IntelliJ IDEA.
 * User: monco
 * Date: 07.05.13
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
public class WeightedQuickUnion {
    private int[] weights;
    private int[] id;
    private int count;

    public WeightedQuickUnion(int N){
        if( N < 0) throw new IllegalArgumentException("Negative N");

        count = N;
        id = new int[N];
        weights = new int[N];
        for(int i = 0; i < N; ++i){
            id[i] = i;
            weights[i] = 1;
        }


    }

    public boolean connected(int i, int j){
        return find(i) == find(j);
    }

    public void union(int i, int j){
        int w = find(i);
        int v = find(j);
        if( w == v)
            return;
        if (weights[w] < weights[v]){
            id[w] = v;
            weights[v] += weights[w];
        }
        else {
            id[v] = w;
            weights[w] += weights[v];
        }
        count--;

        System.out.println("    " + i + "  " + j);
        System.out.println(count());

        for(int k = 0; k < id.length; k++)
            System.out.println(k + " " + find(k));
    }

    public int count(){
        return count;
    }

    public int find(int i){
        return i == id[i] ? i : find(id[i]);
    }

}
