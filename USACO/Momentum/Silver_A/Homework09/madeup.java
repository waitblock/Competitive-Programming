import java.util.*;

public final class madeup {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for(int i = 0; i<n; i++){
            a[i] = in.nextInt();
        }
        for(int i = 0; i<n; i++){
            b[i] = in.nextInt();
        }
        for(int i = 0; i<n; i++){
            c[i] = in.nextInt();
        }
        HashMap<Integer, Integer> val = new HashMap<>();
        for(int i = 0; i<n; i++){
            int temp = b[c[i]-1];
            int cnt = 1;
            if(val.get(temp) != null){
                cnt += val.get(temp);
            }
            val.put(temp, cnt);
        }
        // System.out.println(val);
        int result = 0;
        for(int i = 0; i<n; i++){
            if(val.get(a[i]) != null){
                result += val.get(a[i]);
            }
        }
        System.out.println(result);
    }
}
