package Algorithms.Sorting;

/**
 * Created with IntelliJ IDEA.
 * User: monco
 * Date: 11.05.13
 * Time: 8:37
 * To change this template use File | Settings | File Templates.
 */
public class Selection {
    static public void sort(Comparable[] array){
        for(int i = 0; i < array.length - 1; ++i){
            int min = i;
            for(int j = i; j < array.length; ++j){
                if(!less(array[min],array[j])){
                    min = j;
                }
            }
            swap(array,i,min);
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
