public class SLList {
    private IntNode sentinel;
    private int size;

    public class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    public SLList(int x){
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public SLList(){
        sentinel = new IntNode(61, null);
        size = 0;
    }

    public void addFirst(int x){
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public int getFirst(){
        return sentinel.next.item;
    }

    public void addLast(int x){
        IntNode p = sentinel.next;
        size += 1;

        while (p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    private static int size(IntNode p){
        if (p.next == null){
            return 1;
        }
        else{
            return 1 + size(p.next);
        }
    }

    public int size(){
        return size(sentinel.next);
    }

    public int fastSize(){
        return size;
    }

    public static void main(String[] args){
        SLList L = new SLList(10);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        System.out.println(L.size());
        SLList s1 = new SLList();
        s1.addLast(5);
        System.out.println(s1.fastSize() );
    }
}
