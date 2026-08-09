package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private BSTNode root;
    private int size;

    private class BSTNode {
        private K key;
        private V value;
        private BSTNode left;
        private BSTNode right;

        public BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }

    private BSTNode putHelper(K key, V value, BSTNode node) {
        if (node == null) {
            size++;
            return new BSTNode(key, value);
        }

        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = putHelper(key, value, node.left);
        }

        else if (compare > 0) {
            node.right = putHelper(key, value, node.right);
        }

        else {
            node.value = value;
        }
        return node;
    }

    private V getHelper(K key, BSTNode node) {
        if(node == null){
            return null;
        }

        int compare = key.compareTo(node.key);

        if (compare < 0) {
            return getHelper(key, node.left);
        }
        else if (compare > 0) {
            return getHelper(key, node.right);
        }
        else {
            return node.value;
        }
    }

    private void printInOrderHelper(BSTNode node) {
        if (node == null) {
            return;
        }

        printInOrderHelper(node.left);
        System.out.print(node.key + " ");
        printInOrderHelper(node.right);

    }

    private boolean conrainKeyHelper(K key, BSTNode node) {
        if (node == null) {
            return false;
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            return conrainKeyHelper(key, node.left);
        }

        if (cmp > 0) {
            return conrainKeyHelper(key, node.right);
        }

        return true;

    }

    public BSTMap() {
        clear();
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public boolean containsKey(K key) {
        return conrainKeyHelper(key, root);
    }

    public V get(K key) {
        return getHelper(key, root);
    }

    public int size() {
        return size;
    }

    public void put(K key, V value) {
       root = putHelper(key, value, root);
    }

    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    public void printInOrder() {
        printInOrderHelper(root);
    }

}
