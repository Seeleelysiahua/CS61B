public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }

    public int size(){
        if (rest == null){
            return 1;
        }
        return 1 + this.rest.size();
    }

    public int iterativeSize(){
            int totalSize = 0;
            IntList p = this;
            while(p != null){
                totalSize += 1;
                p = p.rest;
            }
            return totalSize;
    }
    public int get(int n){
            if (n == 0){
                return first;
            }
            else{
                return this.rest.get(n - 1);
            }
    }

    public static void main(String[] args){
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        System.out.println(L.size());
        System.out.println(L.iterativeSize());
        System.out.println(L.get(1));
        System.out.println(L.get(0));

    }
}
