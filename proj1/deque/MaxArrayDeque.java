package deque;

import java.util.Comparator;
import java.util.Iterator;

public class MaxArrayDeque<Item> extends ArrayDeque<Item> {
    private Comparator<Item> comparator;


    public MaxArrayDeque(Comparator<Item> c) {
        super();
        comparator = c;
    }



    public Item max(){
        return helper(comparator);
    }

    public Item max(Comparator<Item> c){
        return helper(c);
    }

    private Item helper(Comparator<Item> c){
        if(isEmpty()){
            return null;
        }

        Item maxItem = this.get(0);

        for(int i = 1; i < size(); i++){
            if(c.compare(maxItem,this.get(i)) <= 0){
                maxItem = this.get(i);
            }
        }
        return maxItem;
    }

}
