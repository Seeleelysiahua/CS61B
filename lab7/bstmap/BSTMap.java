package bstmap;

import java.util.*;

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

    private class BSTIterator implements Iterator<K> {
        private ArrayDeque<BSTNode> callStack;

        private void pushLeft(BSTNode node) {
            while (node != null) {
                callStack.push(node);
                node = node.left;
            }
        }

        public BSTIterator() {
            callStack =  new ArrayDeque<BSTNode>();
            pushLeft(root);

       }

        public boolean hasNext() {
            return !callStack.isEmpty();
        }

        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            BSTNode node = callStack.pop();
            pushLeft(node.right);
            return node.key;
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

    private boolean containKeyHelper(K key, BSTNode node) {
        if (node == null) {
            return false;
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            return containKeyHelper(key, node.left);
        }

        if (cmp > 0) {
            return containKeyHelper(key, node.right);
        }

        return true;

    }

    private BSTNode findSuccessorHelper(BSTNode node) {
        if (node.left == null) {
            return node;
        }
        return findSuccessorHelper(node.left);
    }

    private BSTNode removeHelper(K key, BSTNode node) {
        if (node == null) {
            return null;
        }

        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = removeHelper(key, node.left);
        }
        else if (compare > 0) {
            node.right = removeHelper(key, node.right);
        }

        else {
            if (node.left == null && node.right == null) {
                size--;
                return null;
            }

            else if (node.left == null) {
                size --;
                return node.right;
            }

            else if (node.right == null) {
                size --;
                return node.left;
            }

            else{
                BSTNode successor = findSuccessorHelper(node.right);
                node.key = successor.key;
                node.value = successor.value;
                node.right = removeHelper(successor.key, node.right);
                return node;
            }

        }
        return node;
    }

    private void keySetHelper(Set<K> set, BSTNode node) {
        if (node == null) {
            return;
        }

        keySetHelper(set, node.left);
        keySetHelper(set, node.right);
        set.add(node.key);
    }

    public BSTMap() {
        clear();
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public boolean containsKey(K key) {
        return containKeyHelper(key, root);
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
        HashSet<K> set = new HashSet<>();
        keySetHelper(set, root);

        return set;
    }

    public V remove(K key) {
        V value = get(key);

        if (value == null) {
            return null;
        }

        root = removeHelper(key, root);
        return value;
    }

    public V remove(K key, V value) {
        if(value != null && containsKey(key) && value.equals(get(key))) {
            return remove(key);
        }
        return null;
    }

    public Iterator<K> iterator() {
        return new BSTIterator();
    }

    public void printInOrder() {
        printInOrderHelper(root);
    }

}
