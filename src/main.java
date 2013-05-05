import Graphs.SparseMultiGraph;
import Graphs.TopologicalSort;


import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: d.poberezhny
 * Date: 10.04.13
 * Time: 16:11
 * To change this template use File | Settings | File Templates.
 */
public class main{

    static public void main(String[] args){
        System.out.println();

        SparseMultiGraph graph = new SparseMultiGraph(13,true);
        String graphstr = readFile("resource/graph.txt");
        for(String elem: graphstr.split("\n")){
            String[] edge = elem.split("-");
            graph.add(Integer.parseInt(edge[0]),Integer.parseInt(edge[1]));
        }

        for(int i: new TopologicalSort(graph).order()){
            System.out.println(i);
        }
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
