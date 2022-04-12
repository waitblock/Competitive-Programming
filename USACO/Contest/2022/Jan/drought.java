import java.util.*;

public class drought {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    for(int iter = 0; iter<t; iter++){
      int n = in.nextInt();
      int[] cows = new int[n];
      for(int i = 0; i<n; i++){
        cows[i] = in.nextInt();
      }
      System.out.println(Arrays.toString(cows));
      int result = 0;
      while(true){
        int temp = cows[0];
        boolean allEqual = false;
        for(int i = 0; i<n; i++){
          // System.out.println(cows[i]);
          if(cows[i] != temp){
            allEqual = false;
            break;
          }
        }

        if(allEqual) break;

        int[] pairSum = new int[n-1]; // index 0 = i0+i1, index 1 = i1+i2, and so on
        for(int i = 0; i<n-1; i++){
          pairSum[i] = cows[i]+cows[i+1];
        }

        // System.out.println(Arrays.toString(pairSum));

        int max = Integer.MIN_VALUE;
        int maxInd = 0;

        for(int i = 0; i<n-1; i++){
          int current = pairSum[i];
          if(current > max){
            max = current;
            maxInd = i;
          }
        }
        cows[maxInd]--;
        cows[maxInd+1]--;
        result++;
        System.out.println(Arrays.toString(cows));
      }
      System.out.println(result);
    }
  }
}