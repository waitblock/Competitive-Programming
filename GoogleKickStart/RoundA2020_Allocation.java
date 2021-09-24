import java.util.*;

public class RoundA2020_Allocation {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int i = 1; i <= t; i++){
      int n = in.nextInt();
      int b = in.nextInt();
      int[] arr = new int[n];
      int result = 0;
      for(int j = 0; j < n; j++){
        arr[j] = in.nextInt();
      }
      Arrays.sort(arr);
      for(int j = 0; j < n; j++){
        if(b >= arr[j]){
          b -= arr[j];
          result++;
        }
      }
      System.out.println("Case #" + String.valueOf(i) + ": " + String.valueOf(result));
    }
  }
}
