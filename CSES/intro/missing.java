import java.util.*;
 
public class missing {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum1 = 0; // sum1 is the sum of the numbers given
        int sum2 = 0;
        for(int i = 0; i<n-1; i++){
            sum1 += in.nextInt();
            sum2 += i+1;
        }
        sum2 += n;
        System.out.println(sum2-sum1);
    }
}
