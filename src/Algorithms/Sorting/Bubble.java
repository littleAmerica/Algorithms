package Algorithms.Sorting;

/**
 * Created with IntelliJ IDEA.
 * User: monco
 * Date: 11.05.13
 * Time: 9:48
 * To change this template use File | Settings | File Templates.
 */
public class Bubble {

    static public void sort(Comparable[] array){
        for(int i = 0; i < array.length; ++i){
            for(int j = array.length - 1; j > i; --j){
                if(!less(array[j-1],array[j])){
                    swap(array, j-1, j);
                }
            }
        }
    }

    private static boolean less(Comparable p, Comparable q){
        return p.compareTo(q) < 0;
    }

    private static void swap(Object[] pq, int i, int j) {
        Object swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
}
