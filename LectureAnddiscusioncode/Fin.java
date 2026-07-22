class Fin{
    public static void main(String[] args){

    }
    public static int fin(int n){
        int current1 = 0;
        int current2 = 1;
        int current3 = 0;
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        else{
            for (int i = 1; i <= n; i += 1){
                current1 = fin(i - 2);
                current2 = fin(i - 1);
                current3 = current1 + current2;
            }
        return current3;
        }
    }
    //a way from discussion2
    public static int fin2(int n, int f1, int f2){
        if (n == 0){
            return f1;
        } else if (n == 1) {
        return f2;
        } else{
            return fin2(n - 1, f2, f1 + f2);
        }
    }
}