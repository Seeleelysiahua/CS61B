package deque;

import java.util.Iterator;

public class LinkedListDeque<Item> implements Deque<Item>, Iterable<Item> {
    private Node sentinel;
    private int size;

    private class Node {
        Item data;
        Node next;
        Node pre;

        private Node(Item d) {
            pre = null;
            data = d;
            next = null;
        }
    }

    public LinkedListDeque() {
        sentinel = new Node(null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void addLast(Item d) {
        Node node = new Node(d);
        node.pre = sentinel.pre;
        sentinel.pre.next = node;
        node.next = sentinel;
        sentinel.pre = node;
        size ++;
    }

    @Override
    public void addFirst(Item item) {
        Node node = new Node(item);
        node.pre = sentinel;
        node.next = sentinel.next;
        sentinel.next.pre = node;
        sentinel.next = node;
        size ++;
    }

    @Override
    public Item get(int index){
        if (index >= size || index < 0) {
            return null;
        }
        int i = 0;
        Node current = sentinel.next;
        while (i < index){
            current = current.next;
            i ++;
        }
        return current.data;
    }

    public Item getRecursive(int index){
        if (index >= size || index < 0){
            return null;
        }
        else {
            return getRecursiveHelper(index, sentinel.next);
        }
    }

    private Item getRecursiveHelper(int index, Node node){
        if (index == 0){
            return node.data;
        }
        else  {
            return getRecursiveHelper(index - 1, node.next);
        }
    }

    @Override
    public Item removeFirst(){
        if (size == 0){
            return null;
        }
        Node node = sentinel.next.next;
        Item data = sentinel.next.data;
        node.pre = sentinel;
        sentinel.next = node;
        size --;
        return data;
    }

    @Override
    public Item removeLast(){
        if (size == 0){
            return null;
        }
        Node node = sentinel.pre.pre;
        Item data = sentinel.pre.data;
        node.next = sentinel;
        sentinel.pre = node;
        size --;

        return data;
    }

    @Override
    public void printDeque(){
        Node current = sentinel.next;
        String result = "";

        while (current != sentinel){
            Item data = current.data;
            result += data.toString() + " ";
            current = current.next;

        }

        System.out.println(result);
    }


    public boolean equals(Object o){
        if (this == o) {
            return true;
        }

        if (o instanceof Deque<?> && size == ((Deque<?>)o).size()){
            for (int i = 0; i < size(); i++){
                if(!((Deque<?>) o).get(i).equals(this.get(i))){
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    public Iterator<Item> iterator() {
        return new getIterator();
    }

    private class getIterator implements Iterator<Item>{
        private int wizPos;
        private  Node current = sentinel;

        public getIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public Item next() {
            Item item = current.next.data;
            current = current.next;
            wizPos ++;
            return item;
        }
    }
}
