package Algorithms.Sorting;

/**
 * Created with IntelliJ IDEA.
 * User: d.poberezhny
 * Date: 10.05.13
 * Time: 13:57
 * To change this template use File | Settings | File Templates.
 */
public class Heap {
    static private int BASE = 2;

    public static void makeHeap(Comparable[] array){
        for(int i = array.length / BASE; i >= 0; i--){
            sink(array, i, array.length);
        }
    }

    public static void makeHeap(Comparable[] array, int base){
        setBase(base);
        makeHeap(array);
    }

    public static void sort(Comparable[] array){
        makeHeap(array);
        for(int i = array.length - 1; i > 0; --i){
            swap(array, 0, i);
            sink(array, 0, i);
        }
    }

    public static void sort(Comparable[] array, int base){
        setBase(base);
        sort(array);
    }

    private static void sink(Comparable[] array, int k, int N){
        int child[] = new int[BASE];
        child[0] = k * 2 + 1;
        if(!(child[0] < N))
            return;
        int biggest = child[0];
        for(int i = 1; i < BASE; ++i)
            if((child[i] = child[i-1] + 1) < N)
                if(less(array[biggest],array[child[i]]))
                    biggest = child[i];
            else
                break;

        if((less(array[k],array[biggest]))){
            swap(array, k, biggest);
            sink(array,biggest,N);
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

    public static int base(){
        return BASE;
    }

    public static void setBase(int base){
        if(base < 2) throw new IllegalArgumentException("Heap base less 2");
        BASE = base;
    }

    //    old version BASE = 2
//    private static void sink(Comparable[] array, int i, int N){
//        int left = i * 2 + 1;
//        if(!(left  <  N ))
//            return;
//        int right = left + 1;
//        int biggest = left;
//        if( right < N && less(array,left,right))
//            biggest = right;
//
//        if((less(array,i,biggest))){
//            swap(array, i, biggest);
//            sink(array,biggest,N);
//        }
//    }
}
