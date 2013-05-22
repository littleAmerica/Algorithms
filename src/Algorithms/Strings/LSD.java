package Algorithms.Strings;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: d.poberezhny
 * Date: 21.05.13
 * Time: 19:17
 * To change this template use File | Settings | File Templates.
 */
public class LSD {
    private static int R = 256;

    public static void sort(String[] strings, int W){
        String[] aux = new String[strings.length];
        for(int d = W - 1; d > 0; --d){
            int[] count = new int[R + 1];
            for(int i = 0; i < strings.length; ++i) {
                count[strings[i].charAt(d) + 1]++;
            }

            for(int i = 0; i < count.length - 1; ++i) {
                count[i+1] += count[i];
            }

            for(int i = 0; i < strings.length; ++i){
                aux[count[strings[i].charAt(d)]++] = strings[i];
            }

            for(int i = 0; i < strings.length; i++)
                strings[i] = aux[i];
        }
    }

    public static void main(String[] args){

        String[] str = {"asd","qwe", "123", "qwe", "zxc", "fgh", "asd", "dfg","rty","cvb","rty"};
        System.out.println(Arrays.toString(str));
        sort(str, 3);
        System.out.println(Arrays.toString(str));
    }
}
