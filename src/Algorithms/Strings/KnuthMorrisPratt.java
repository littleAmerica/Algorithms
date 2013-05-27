package Algorithms.Strings;

/**
 * Created with IntelliJ IDEA.
 * User: monco
 * Date: 27.05.13
 * Time: 0:00
 * To change this template use File | Settings | File Templates.
 */
public class KnuthMorrisPratt {
    private static int R = 255;

    public static int search(String string, String pattern){
        int M = pattern.length();
        int N = string.length();

        int[] dfa = new int[M];

        for(int i = 0; i < M; ++i){

        }



        return N;
    }


    public static void main(String[] args){
        System.out.println(search("AdsfsdfFDD","dsfsdf"));

    }

}
