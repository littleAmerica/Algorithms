import Algorithms.Graphs.DijkstraSPT;
import Algorithms.Graphs.Tools.DirectedEdge;
import Algorithms.Graphs.Tools.EdgeWeightedDigraph;
import Algorithms.Sorting.Merge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: d.poberezhny
 * Date: 10.04.13
 * Time: 16:11
 * To change this template use File | Settings | File Templates.
 */
public class main{

    static public void main(String[] args){
//        System.out.println();
        final int N = 250;
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(N);
        String graphstr = readFile("resource/EWD250.txt");
        for(String elem: graphstr.split("\n")){
            String[] edge = elem.split(" ");
            graph.add(new DirectedEdge(Integer.parseInt(edge[0]),Integer.parseInt(edge[1]), Double.parseDouble(edge[2])));
        }
//        DijkstraSPT dijkstraSPT = new DijkstraSPT(graph,0);
////        for(int i = 0; i < N; ++i)
////            System.out.println(dijkstraSPT.distTo(i));
//        for(DirectedEdge e: dijkstraSPT.pathTo(1)){
//            System.out.println(e);
//        }
        Integer[] array = {4,6,3,4,3,2,4,5,7,8,9,7,5,4,};
        Integer[] array2;
        System.out.println(Arrays.toString(array));
        Merge.sort(array);
        System.out.println(Arrays.toString(array));
    }



    static public String readFile(String filename)
    {
        BufferedReader br;
        try{
            br = new BufferedReader(new FileReader(filename));
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            try{
                br.close();
            }
            catch (IOException e)
            {
                System.out.println("ooops");
            }
        }

    }
}
