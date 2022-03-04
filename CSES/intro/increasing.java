import java.util.*;
 
public class increasing {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = in.nextInt();
        }
        in.close();
        long result = 0;
        for(int i = 1; i<n; i++){
            long d = arr[i-1]-arr[i];
            if(arr[i-1] > arr[i]){
                arr[i] += d;
                result += d;
            }
        }
        System.out.println(result);
    }
}
