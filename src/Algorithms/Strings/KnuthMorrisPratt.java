package Algorithms.Strings;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: monco
 * Date: 27.05.13
 * Time: 0:00
 * To change this template use File | Settings | File Templates.
 */
public class KnuthMorrisPratt {
    private static int R = 255;

    public static int search(String text, String pattern){
        int M = pattern.length();
        int N = text.length();

        int[] z = Z(pattern);

        int pos = 0;

        for(int i = 0; i < N; ++i){
            char c = text.charAt(i);
            if(pattern.charAt(pos) == c)
                pos++;
            else {
                while (pos > 0 && pattern.charAt(pos) != c)
                    pos = z[pos - 1];
            }
            if (pos == pattern.length())
                return i - M + 1;
        }
        return N;
    }

    public static int[] Z(String str) {
        int[]  z = new int[str.length()];
        z[0] = 0;
        for (int i = 1; i < z.length;++i) {
            int pos = z[i-1];
            while (pos > 0 && str.charAt(pos) != str.charAt(i))
                pos = z[pos-1];
            z[i] = pos + (str.charAt(pos) == str.charAt(i) ? 1 : 0);
        }
        return z;
    }

    public static void main(String[] args){
        String s = "abacadabrabracabracadabrabrabracad";
        String p = "rabrabracad";
        int i = search(s, p);
        System.out.println(i);
        //Z("abacacabacab");
    }

}
