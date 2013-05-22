package Algorithms.Strings;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: d.poberezhny
 * Date: 21.05.13
 * Time: 19:17
 * To change this template use File | Settings | File Templates.
 */
public class MSD {
    private static int R = 256;

    public static void sort(String[] strings){
        sort(strings, 0, strings.length, 0);
    }
    private static void sort(String[] strings, int from, int to, int d){
        if(from >= to) return;

        int[] count = new int[R + 1];
        for(int i = from; i < to; ++i) {
            count[charAt(strings[i], d) + 2]++;
        }
        for(int i = 0; i < count.length - 1; ++i) {
            count[i+1] += count[i];
        }

        String[] aux = new String[strings.length];

        for(int i = from; i < to; ++i){
            aux[count[charAt(strings[i], d) + 1]++] = strings[i];
        }

        for(int i = from; i < to; i++)
            strings[i] = aux[i - from];

        for(int i = 0; i < count.length - 1; ++i)
            sort(strings, from + count[i], from + count[i+1], d + 1);
    }

    private static int charAt(String str, int d){
        return d < str.length() ? str.charAt(d) : -1;
    }

    public static void main(String[] args){

        String[] str = {"1","1311", "1112", "1113", "1123", "6546", "345345", "54325434","54353454","sdfsdfsd","1"};
        System.out.println(Arrays.toString(str));
        sort(str);
        System.out.println(Arrays.toString(str));
    }
}
