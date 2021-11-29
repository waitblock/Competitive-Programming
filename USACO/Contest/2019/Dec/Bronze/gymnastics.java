import java.util.*;
import java.io.*;

public class gymnastics {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("gymnastics.in"));
    int k = in.nextInt();
    int n = in.nextInt();
    // System.out.println(k);
    // System.out.println(n);
    int[][] cows = new int[k][n];
    for(int i = 0; i<k; i++){
      for(int j = 0; j<n; j++){
        cows[i][j] = in.nextInt();
      }
    }
    in.close();
    // System.out.println(cows.length);
    ArrayList<int[]> combinations = new ArrayList<>();
    for(int i = 1; i<=n; i++){
      for(int j = 1; j<=n; j++){
        int[] combination = {i,j};
        combinations.add(combination);
      }
    }
    // for(int i = 0; i<combinations.size(); i++){
    //   System.out.println(Arrays.toString(combinations.get(i)));
    // }
    int result = 0;
    for(int i = 0; i<combinations.size(); i++){
      boolean valid = true;
      for(int j = 0; j<cows.length; j++){
        // System.out.println(cows.length);
        // System.out.println(j);
        if(!check(combinations.get(i), cows[j])){

          // System.out.println(Arrays.toString(combinations.get(i))+" "+Arrays.toString(cows[j]));

          valid = false;
        }

      }
      if(valid){
        result++;
      }
    }
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("gymnastics.out"));
    out.println(result);
    out.close();
  }
  static boolean check(int[] combination, int[] line){
    if(indexOf(line, combination[0]) < indexOf(line, combination[1])){
      return true;
    }
    return false;
  }
  static int indexOf(int[] arr, int k){
    for(int i = 0; i<arr.length; i++){
      if(arr[i] == k){
        return i;
      }
    }
    return -1;
  }
}