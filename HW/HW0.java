public class HW0{
    public static void main(String[] args){
        Triangle();
        drawTriangle(8);
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10};
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);
        System.out.println(max(numbers));
        System.out.println(maxFor(numbers));
        System.out.println(java.util.Arrays.toString(a));
    }
    public static void Triangle() {
        int n = 5;
        String s = "";
        while (n > 0) {
            s += "*";
            System.out.println(s);
            n = n - 1;
        }
    }
    public static void drawTriangle(int N){
        String sN = "";
        while (N > 0){
            sN += "*";
            System.out.println(sN);
            N -= 1;
        }
    }
    public static int max(int[] m){
        int maxNum = m[0];
        int index = 0;
        while (index < m.length){
            if(m[index] > maxNum){
                maxNum = m[index];
            }
            index += 1;
        }
        return maxNum;
    }
    public static int maxFor(int[] mF){
        int maxNumF = mF[0];
        for(int i = 1; i < mF.length; i += 1){
            if (mF[i] > maxNumF){
                maxNumF = mF[i];
            }
        }
        return maxNumF;
    }
    public static void windowPosSum(int[] a, int n){
        for(int i = 0; i < a.length; i += 1){
            if (a[i] <= 0){
                continue;
            }
            for(int j = i + 1; j < i + n + 1; j += 1){
                if (j >= a.length){
                    break;
                }
                else{
                    a[i] += a[j];
                }
            }
        }
    }
}