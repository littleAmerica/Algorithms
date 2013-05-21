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
        sort(strings, 0, strings.length - 1, 0);
    }
    private static void sort(String[] strings, int from, int to, int d){
        int[] count = new int[R];
        for(int i = from; i < to; ++i) {
            count[(int)strings[i].charAt(d) + 1]++;
            System.out.println(strings[i].charAt(d));
        }
        for(int i = 0; i < count.length - 1; ++i) {
            count[i+1] += count[i];
        }

        String[] aux = new String[strings.length];

        for(int i = from; i < to - 1; ++i){
            aux[count[(int)strings[i].charAt(d)]++] = strings[i];
        }

        System.out.println(Arrays.toString(aux));
    }

    public static void main(String[] args){
        String[] str = {"asd", "sdf", "345", "543", "oop"};
        sort(str);
    }
}
