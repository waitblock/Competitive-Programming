import java.util.*;

public final class rangesum {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        long[] prefix = new long[n+1];
        long sum = 0;
        for(int i = 1; i<=n; i++){
            sum += in.nextInt();
            prefix[i] = sum;
        }
        // System.out.println(Arrays.toString(prefix));
        for(int i = 0; i<q; i++){
            int l1 = in.nextInt();
            int l2 = in.nextInt();
            System.out.println(prefix[l2]-prefix[l1]);
        }
        in.close();
    }
}
