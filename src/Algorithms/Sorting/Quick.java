package Algorithms.Sorting;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: d.poberezhny
 * Date: 10.05.13
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 */
public class Quick {

    static public void sort(Comparable[] array)
    {
        qsort(array,0,array.length);
    }

    static private void qsort(Comparable[] array, int from, int to)
    {
        if((to - from) <= 1)
            return;
        int low = from;
        int high = to - 2;
        int key = to - 1;

        while (true){
            while(less(array[low], array[key])) low++;
            while(less(array[key], array[high])) high--;
            if(low < high)
                swap(array,low++,high--);
            else
                break;
        }
        swap(array,low, key);
        qsort(array,from,low);
        qsort(array,low + 1, to);
    }

    private static boolean less(Comparable p, Comparable q){
        return p.compareTo(q) < 0;
    }

    private static void swap(Object[] pq, int i, int j) {
        Object swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    public static void main(String[] strings)
    {
        Integer[] str = {3,4,5,34,3,2,4,36,34,23,12,4,1,4,35,6,53,41,232,454,65,76,23,1,34,56,476,34,56};
        System.out.println(Arrays.toString(str));
        sort(str);
        System.out.println(Arrays.toString(str));
    }
}
