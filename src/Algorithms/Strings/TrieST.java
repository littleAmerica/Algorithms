package Algorithms.Strings;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 * User: d.poberezhny
 * Date: 24.05.13
 * Time: 10:47
 * To change this template use File | Settings | File Templates.
 */
public class TrieST<Value> {
    private static final int R = 256;
    private int size;
    private Node root;

    private static class Node{
        private Object value;
        private Node[] children = new Node[R];
    }

    public void put(String key, Value val){
        root = put(root, key, val, 0);
    }

    private Node put(Node n, String key, Value val, int d){
        if(n == null)
            n = new Node();

        if(d == key.length()){
            if(n.value == null)
                size++;
            n.value = val;
        }
        else {
            char ch = key.charAt(d);
            n.children[ch] = put(n.children[ch], key, val, d + 1);
        }
        return n;
    }

    public Value get(String key){
        Node node = get(root, key, 0);
        return node.value == null ? null : (Value)node.value;
    }

    private Node get(Node n, String key, int d){
        if(n == null)
            return null;
        if(d == key.length()){
           return n;
        }
        return get(n.children[key.charAt(d)], key, d + 1);
    }

    public boolean contains(String key){
        return get(key) != null;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return size;
    }

    public Iterable<String> keys(){
        Deque<String> deque = new ArrayDeque<String>(size);
        collect(root,"", deque);
        return deque;
    }

    private void collect(Node node, String str, Deque<String> deque){
        if(node == null)
            return;
        if(node.value != null)
            deque.addLast(str);
        for(char c = 0; c < R; ++c)
            collect(node.children[c], str + c, deque);
    }

    public void delete(String key){
        root = delete(root, key, 0);
    }

    private Node delete(Node n, String key, int d) {
        if(n == null)
            return n;
        if(d == key.length()){
            n.value = null;
        }
        else {
            delete(n.children[key.charAt(d)], key, d + 1);
        }

        if(n.value != null)
            return n;

        for(int i = 0; i < R; ++i)
            if(n.children[i] != null)
                return n;
        return null;
    }



    public static void main(String[] args){
        TrieST<Integer> trie = new TrieST<Integer>();
        trie.put("first",4);
        trie.put("firs",2);
        trie.put("second",8);
        trie.put("first",8);
        trie.put("put",9);

        trie.delete("put");
        for(String str : trie.keys())
            System.out.println(str);

        System.out.println(trie.get("first"));

    }
}
