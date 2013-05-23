package Algorithms.Strings;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: d.poberezhny
 * Date: 10.05.13
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 */
public class Quick3String {

    static public void sort(String[] array)
    {
        qsort(array, 0, array.length, 0);
    }

    static private void qsort(String[] array, int from, int to, int d)
    {
        if((to - from) <= 1)
            return;
        int low = from;
        int high = to - 2;
        int key = to - 1;

        while (true){
            while(charAt(array[low], d) < charAt(array[key],d)) low++;
            while(charAt(array[key], d) < charAt(array[high], d)) high--;
            if(low < high)
                swap(array,low++,high--);
            else
                break;
        }
        swap(array,low + 1, key);
//        qsort(array,from,low);
//        qsort(array,low + 1, to);
    }

    private static boolean less(String p, String q){
        return p.compareTo(q) < 0;
    }

    private static void swap(Object[] pq, int i, int j) {
        Object swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    private static int charAt(String str, int d){
        return d < str.length() ? str.charAt(d) : -1;
    }

    public static void main(String[] strings)
    {
        String[] str = {"asd","qwe", "123", "qwe", "zxc", "fgh", "asd", "dfg","rty","cvb","rty"};
        System.out.println(Arrays.toString(str));
        sort(str);
        System.out.println(Arrays.toString(str));
    }
}
