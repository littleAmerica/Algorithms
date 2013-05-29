package Algorithms.Strings;

/**
 * Created with IntelliJ IDEA.
 * User: d.poberezhny
 * Date: 29.05.13
 * Time: 16:34
 * To change this template use File | Settings | File Templates.
 */
public class BoyerMoore {
    private static int R = 255;

    public static int search(String string, String pattern){
        int M = pattern.length();
        int N = string.length();

        int[] right = new int[R];

        for(int i = 0; i < R; ++i)
            right[i] = -1;
        for(int i = 0; i < M; ++i)
            right[pattern.charAt(i)] = i;

        int skip;
        for(int i = 0; i <= N - M; i += skip){
            skip = 0;
            for(int j = M - 1; j >= 0 ; --j){
                if( pattern.charAt(j) != string.charAt(i + j)){
                    skip = j - right[string.charAt(i + j)];
                    if(skip < 1)
                        skip = 1;
                    break;
                }
            }
            if(skip == 0)
                return i;
        }
        return N;
    }



    public static void main(String[] args){
        String s = "abacadabrabracabracadabrabrabracad";
        String p = "rabracad";
       int i = search(s, p);
        System.out.println(i);
    }
}
