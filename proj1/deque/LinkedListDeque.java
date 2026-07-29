package deque;

public class LinkedListDeque<Item> {
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

    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    public void addLast(Item d) {
        Node node = new Node(d);
        node.pre = sentinel.pre;
        sentinel.pre.next = node;
        node.next = sentinel;
        sentinel.pre = node;
        size ++;
    }

    public void addFirst(Item item) {
        Node node = new Node(item);
        node.pre = sentinel;
        node.next = sentinel.next;
        sentinel.next.pre = node;
        sentinel.next = node;
        size ++;
    }

    public int size(){
        return size;
    }

    public Item get(int index){
        if (index >= size){
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
        if (index >= size){
            return null;
        }
        else {
            return getRecursiveHelper(index, sentinel.next);
        }
    }

    public Item getRecursiveHelper(int index, Node node){
        if (index == 0){
            return node.data;
        }
        else  {
            return getRecursiveHelper(index - 1, node.next);
        }
    }


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


    public void printDeque(){
        Node current = sentinel.next;
        String result = "";

        while (current != sentinel){
            result += current.data + " ";
            current = current.next;

        }

        System.out.println(result);
        System.out.println();
    }


    public boolean equals(Object o){
        boolean ifequal = false;

        if (o instanceof LinkedListDeque && size == ((LinkedListDeque)o).size()){
            for (int i = 0; i < size(); i++){
                if (((LinkedListDeque<?>) o).get(i) == this.get(i)){
                    ifequal = true;
                }
                else {
                    ifequal = false;
                    break;
                }
            }
        }

        return ifequal;
    }
}
