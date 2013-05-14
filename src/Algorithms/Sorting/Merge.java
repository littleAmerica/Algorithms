package Algorithms.Sorting;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: d.poberezhny
 * Date: 14.05.13
 * Time: 10:05
 * To change this template use File | Settings | File Templates.
 */
public class Merge {
    static public void sort(Comparable[] array)
    {
        Comparable[] aux = new Comparable[array.length];
        mergesort(array, aux, 0, array.length);

    }

    static private void mergesort(Comparable[] array, Comparable[] aux, int from, int to)
    {
        int middle = from + (to - from + 1) / 2;

        if(to - from > 2){
            mergesort(array, aux, from, middle);
            mergesort(array, aux, middle, to);
        }
        merge(array, aux, from, middle, to);
    }

    static private void merge(Comparable[] array, Comparable[] aux, int from, int mid, int to){
        for(int i = from, j = mid, k = from; k < to; ++k){
            if(i == mid){
                while(k < to)
                    aux[k++] = array[j++];
                break;
            }
            if(j == to){
                while(k < to)
                    aux[k++] = array[i++];
                break;
            }
            aux[k] = less(array[i],array[j]) ? array[i++] : array[j++];
        }
        for(int i = from; i < to; ++i)
            array[i] = aux[i];

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
