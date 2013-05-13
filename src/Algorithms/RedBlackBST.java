package Algorithms;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: d.poberezhny
 * Date: 12.04.13
 * Time: 15:36
 * To change this template use File | Settings | File Templates.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> implements SortedMap<Key, Value> {

    private static final boolean RED   = true;
    private static final boolean BLACK = false;

    private Node root;     // root of the BST

    // BST helper node data type
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private boolean color;
        private int N;

        public Node(Key key, Value val, boolean color, int N) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.N = N;
        }
    }


    //TODO refactored this method
    @Override
    public Value put(Key key, Value val) {
        Value old = get(key);
        root = put(root, key, val);
        root.color = BLACK;
        return null;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null){
            return new Node(key, val, RED, 1);
        }

        int cmp = key.compareTo(h.key);
        if      (cmp < 0) h.left  = put(h.left,  key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else              h.val   = val;

        if (isRed(h.right) && !isRed(h.left))      h = rotateLeft(h);
        if (isRed(h.left)  &&  isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left)  &&  isRed(h.right))     flipColors(h);
        h.N = size(h.left) + size(h.right) + 1;

        return h;
    }

    @Override
    public Value get(Object key){
//        if(key instanceof Key)
//            return get(root,(Key)key);
//        else
//            return null;
        try{
            return get(root,(Key)key);
        }
        catch (ClassCastException e){
            return null;
        }
    }

    private Value get(Node h, Key key){
        if(h == null)
            return null;

        int cmp = key.compareTo(h.key);
        if      (cmp < 0) return get(h.left, key);
        else if (cmp > 0) return get(h.right, key);
        else              return h.val;
    }

    private Node rotateRight(Node h) {
        assert (h != null) && isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateLeft(Node h) {
        assert (h != null) && isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private void flipColors(Node h) {
        assert (h != null) && (h.left != null) && (h.right != null);
        assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
                || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }


    private boolean isRed(Node x) {
        if (x == null) return false;
        return  (x.color == RED);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Key firstKey() {
        if(isEmpty())
            return null;
        Node current = root;
        while(current.left != null ){
            current = current.left;
        }
        return current.key;
    }

    @Override
    public int size() {
        return root.N;
    }

    @Override
    public Key lastKey() {
        if(isEmpty())
            return null;
        Node current = root;
        while(current.right != null ){
            current = current.right;
        }
        return current.key;
    }

    @Override
    public Set<Entry<Key, Value>> entrySet() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Comparator<? super Key> comparator() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public SortedMap<Key, Value> subMap(Key fromKey, Key toKey) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public SortedMap<Key, Value> headMap(Key toKey) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public SortedMap<Key, Value> tailMap(Key fromKey) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean containsKey(Object key) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean containsValue(Object value) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Value remove(Object key) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void putAll(Map<? extends Key, ? extends Value> m) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void clear() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<Key> keySet() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<Value> values() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}