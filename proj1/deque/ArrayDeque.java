package deque;

import java.util.Iterator;

public class ArrayDeque<Item> implements Deque<Item>, Iterable<Item> {
    private Item[] items;
    private int size;
    private double usageFactor;
    private  int nextFirst;
    private int nextLast;


    public ArrayDeque() {
        items =  (Item[]) new Object[8];
        size = 0;
        usageFactor = 0.25;
        nextFirst = 4;
        nextLast = 5;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize(int newSize) {
        Item[] newItems = (Item[]) new Object[newSize];

        for(int i = 0; i < size; i++){
            newItems[i] = this.get(i);
        }

        nextLast = size;
        items = newItems;
        nextFirst = items.length - 1;
    }

    @Override
    public void addLast(Item item) {
        if (size == items.length) {
            resize(items.length * 2);
        }

        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size ++;
    }

    @Override
    public void addFirst(Item item) {
        if (size == items.length) {
            resize(items.length * 2);
        }

        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size ++;
    }

    @Override
    public Item get(int index){
        if(index>= size || index < 0){
            return null;
        }

        return items[(nextFirst + 1 + index) % items.length];
    }

    @Override
    public Item removeFirst(){
        if(size == 0){
            return null;
        }

        if(size <= (items.length * usageFactor) && items.length >= 16){
            resize(items.length / 2);
        }

        Item item = items[(nextFirst + 1) % items.length];
        items[(nextFirst + 1) % items.length] = null;
        nextFirst = (nextFirst + 1) % items.length;
        size --;

        return item;
    }

    @Override
    public Item removeLast(){
        if(size == 0){
            return null;
        }

        if(size <= (items.length * usageFactor) && items.length >= 16){
            resize(items.length / 2);
        }

        Item item = items[(nextLast - 1 + items.length) % items.length];
        items[(nextLast - 1 + items.length) % items.length] = null;
        nextLast = (nextLast - 1 + items.length) % items.length;
        size --;

        return item;
    }

    @Override
    public void printDeque(){
        String result = "";
        for(int i = 0; i < size; i++){
            Item item = this.get(i);
            result += item.toString() + " ";
        }

        System.out.print(result);
        System.out.println();

    }

    public boolean equals(Object o){
        if(o == this) {
            return true;
        }

        if(o instanceof Deque<?> && ((Deque<?>) o).size() == size){
            for (int i = 0; i < size(); i++){
                if (! ((Deque<?>) o).get(i).equals(this.get(i))){
                    return  false;
                }
            }
            return true;
        }
        return false;
    }

    public Iterator<Item> iterator(){
        return new getIterator();
    }

    private class getIterator implements Iterator<Item>{
        int wozPos;

        public getIterator(){
            wozPos = 0;
        }

        public boolean hasNext(){
            return wozPos < size;
        }

        public Item next(){
            Item item = items[(nextFirst + 1 + wozPos) % items.length];
            wozPos ++;
            return item;
        }
    }
}
