package Algorithms.Strings;
import java.math.BigInteger;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: monco
 * Date: 26.05.13
 * Time: 17:12
 * To change this template use File | Settings | File Templates.
 */
public class RabinKarp {
    private static int R = 255;
    private static long Q = 997;//new BigInteger(31,new Random()).nextProbablePrime().longValue();

    public static int search(String string, String pattern){
        int M = pattern.length();
        int N = string.length();

        long patternHash = hash(pattern, 0, M);
        long strPartHash = hash(string, 0, M);

        long RM = 1;
        for(int i = 0; i < M - 1; ++i)
            RM *= R % Q;

        if(strPartHash == patternHash)
            return 0;

        for(int i = 0; i < N - M; ++i){
            strPartHash = ((strPartHash + Q - RM * string.charAt(i) % Q)* R % Q + string.charAt(i + M)) % Q;
            if(strPartHash == patternHash)
                return i + 1;
        }
        return N;
    }

    private static long hash(String str, int from, int to){
        long hash = 0;
        for(int i = from; i < to; ++i)
            hash = (hash * R  % Q + str.charAt(i)) % Q;
        return hash;
    }

    public static void main(String[] args){
        String s = "abacadabrabracabracadabrabrabracad";
        String p = "rabracad";
        int i = search(s, p);
        System.out.println(i);
    }

}
