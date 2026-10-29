package hashmap;

import java.util.*;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* Instance Variables */
    private Collection<Node>[] buckets;
    // You should probably define some more!
    private int size;
    private double loadFactor;
    private Set<K> keys = new HashSet<>();

    /** Constructors */
    public MyHashMap() {
        this(16);
    }

    public MyHashMap(int initialSize) {
        this(initialSize, 0.75);
    }

    /**
     * MyHashMap constructor that creates a backing array of initialSize.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialSize initial size of backing array
     * @param maxLoad maximum load factor
     */
    public MyHashMap(int initialSize, double maxLoad) {
        size = 0;
        buckets = createTable(initialSize);
        loadFactor = maxLoad;
    }

    /**
     * Returns a new node to be placed in a hash table bucket
     */
    private Node createNode(K key, V value) {
        return new Node(key, value);
    }

    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *
     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        return new ArrayList<Node>();
    }

    /**
     * Returns a table to back our hash table. As per the comment
     * above, this table can be an array of Collection objects
     *
     * BE SURE TO CALL THIS FACTORY METHOD WHEN CREATING A TABLE SO
     * THAT ALL BUCKET TYPES ARE OF JAVA.UTIL.COLLECTION
     *
     * @param tableSize the size of the table to create
     */
    private Collection<Node>[] createTable(int tableSize) {
        Collection<Node>[] buckets = new Collection[tableSize];
        for (int i = 0; i < tableSize; i++) {
            buckets[i] = createBucket();
        }
        return buckets;
    }

    private int getBucketIndex(K key) {
        int hash = key.hashCode();
        int index = Math.floorMod(hash, buckets.length);
        return index;
    }

    private Node getNode(K key) {
        int index = getBucketIndex(key);
        for (Node node : buckets[index]) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    private void resize() {
        Collection<Node>[] oldBuckets = buckets;
        buckets = createTable(oldBuckets.length * 2);

        for (Collection<Node> bucket : oldBuckets) {
            for (Node node : bucket) {
                buckets[getBucketIndex(node.key)].add(node);
            }
        }
    }

    // TODO: Implement the methods of the Map61B Interface below
    // Your code won't compile until you do so!
    public void clear() {
        buckets = createTable(16);
        size = 0;
        keys.clear();
    }

    public int size() {
        return size;
    }

    public boolean containsKey(K key) {
        return getNode(key) != null;
    }

    public V get(K key) {
        Node node = getNode(key);
        if (node == null) {
            return null;
        }
        return node.value;
    }

    public void put(K key, V value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            return;
        }
        int index = getBucketIndex(key);
        node = createNode(key, value);
        buckets[index].add(node);
        keys.add(node.key);
        size++;
        if (size >= (loadFactor * buckets.length)) {
            resize();
        }
    }

    public V remove(K key) {
        Node node = getNode(key);
        if (node == null) {
            return null;
        }

        int index = getBucketIndex(key);
        buckets[index].remove(node);
        keys.remove(key);
        size--;
        return node.value;

    }

    public V remove(K key, V value) {
        Node node = getNode(key);
        if (node != null && node.value.equals(value)){
            return remove(key);
        }
        return null;
    }

    public Set<K> keySet() {
        return keys;
    }

    public Iterator<K> iterator() {
        return keys.iterator();
    }

}
