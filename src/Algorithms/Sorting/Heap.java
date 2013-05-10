package Algorithms.Sorting;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: d.poberezhny
 * Date: 10.05.13
 * Time: 13:57
 * To change this template use File | Settings | File Templates.
 */
public class Heap {

    public static void makeHeap(Comparable[] array){
        for(int i = array.length / 2; i >= 0; i--){
            sink(array, i, array.length);
        }
    }

    public static void sort(Comparable[] array){
        makeHeap(array);
        System.out.println(Arrays.toString(array));
        for(int i = array.length - 1; i > 0; --i){
            swap(array, 0, i);
            sink(array, 0, i);
            System.out.println(Arrays.toString(array));
        }
    }

    private static void sink(Comparable[] array, int i, int N){
        int left = i * 2 + 1;
        if(!(left  <  N ))
            return;
        int right = left + 1;
        int biggest;
        if( !(right < N) || !(less(array,left,right)))
            biggest = left;
        else
            biggest = right;
        if((less(array,i,biggest))){
            swap(array, i, biggest);
            sink(array,biggest,N);
        }
    }
    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private static void swap(Object[] pq, int i, int j) {
        Object swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
}
