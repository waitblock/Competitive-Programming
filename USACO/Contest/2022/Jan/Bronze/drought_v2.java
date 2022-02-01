import java.util.*;

public class drought_v2 {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int iter = 0; iter<t; iter++){
      int n = in.nextInt();
      int[] hunger = new int[n];
      for(int i = 0; i<n; i++){
        hunger[i] = in.nextInt();
      }
      int result = 0;

      while(true){
        int temp = hunger[0];
        boolean allEqual = true;
        for(int i = 0; i<n; i++){
          if(hunger[i] != temp){
            allEqual = false;
            break;
          }
        }
        if(allEqual) break;

        int maxHunger = hunger[0];
        int maxIndex = 0;

        for(int i = 0; i<n; i++){
          if(hunger[i] > maxHunger){
            maxHunger = hunger[i];
            maxIndex = i;
          }
        }
        if(maxIndex == 0){
          hunger[0]--;
          hunger[1]--;
        }
        if(maxIndex == n-1){
          hunger[n-1]--;
          hunger[n-2]--;
        }
        else{
          if(hunger[maxIndex-1] < hunger[maxIndex+1]){
            hunger[maxIndex-1]--;
          }
          else{
            hunger[maxIndex+1]--;
          }
          hunger[maxIndex]--;
        }
        result++;
      }

      System.out.println(result);
    }
  }
}