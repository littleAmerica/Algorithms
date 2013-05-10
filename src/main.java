import Algorithms.Sorting.Heap;


import java.io.*;
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
//        final int N = 10;
//        EdgeWeightedGraph graph = new EdgeWeightedGraph(250);
//        String graphstr = readFile("resource/EWG250.txt");
//        for(String elem: graphstr.split("\n")){
//            String[] edge = elem.split(" ");
//            graph.add(new Edge(Integer.parseInt(edge[0]),Integer.parseInt(edge[1]), Double.parseDouble(edge[2])));
//        }
//        long timeout= System.currentTimeMillis();
//        Prim prim = new Prim(graph);
//        System.out.println("prim " + prim.weight() + " " + (System.currentTimeMillis() - timeout)/1000.0);
//
//        timeout= System.currentTimeMillis();
//        Kruskal kruskal = new Kruskal(graph);
//        System.out.println("kruskal " + kruskal.weight() + " " + (System.currentTimeMillis() - timeout)/1000.0);
//
//        timeout= System.currentTimeMillis();
//        Boruvka boruvka = new Boruvka(graph);
//        System.out.println("boruvka " + boruvka.weight() + " " + (System.currentTimeMillis() - timeout)/1000.0);

        Integer[] array = {4,5,6,7,3,9,2,3,2,1,4,7,7,5,4,3,2,1,4,6,7,8,6,5,6,7,8,6,4,3,3,5,6,7,8,4,3,2,4,5,6,7,4,3,2,21,4};
        System.out.println(Arrays.toString(array));
        Heap.sort(array);
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
