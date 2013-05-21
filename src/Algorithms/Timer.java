package Algorithms;

/**
 * Created with IntelliJ IDEA.
 * User: d.poberezhny
 * Date: 20.05.13
 * Time: 14:53
 * To change this template use File | Settings | File Templates.
 */
public class Timer {
    private long start;
    private String what;
    private long time;
    public Timer(String what){
        this.what = what;
    }

    public Timer start(){
        start = System.currentTimeMillis();
        return this;
    }

    public Timer pause(){
        time = System.currentTimeMillis() - start;
        return this;
    }

    public Timer println(){
        System.out.println(what + " " + time / 1000.0 );
        return this;
    }
}

