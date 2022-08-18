import java.util.*;
import java.io.*;

public final class tracing {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("tracing.in"));
    int n = in.nextInt();
    int t = in.nextInt();
    char[] infected_ = in.next().toCharArray();
    boolean[] infected = new boolean[n+1];
    for(int i = 1; i<=n; i++){
      if(infected_[i-1] == '1'){
        infected[i] = true;
      }
    }
    // Log of interactions
    int[] time = new int[t];
    int[] a = new int[t];
    int[] b = new int[t];
    for(int i = 0; i<t; i++){
      time[i] = in.nextInt();
      a[i] = in.nextInt();
      b[i] = in.nextInt();
    }
    int[] tempT = new int[t];
    int[] tempA = new int[t];
    int[] tempB = new int[t];
    for(int i = 0; i<t; i++){
      tempT[i] = time[i];
      tempA[i] = a[i];
      tempB[i] = b[i];
    }
    Arrays.sort(time);
    for(int i = 0; i<t; i++){
      a[i] = tempA[findIndex(tempT, time[i])];
      b[i] = tempB[findIndex(tempT, time[i])];
    }
    HashSet<Integer> validPZero = new HashSet<>();
    int minK = Integer.MAX_VALUE;
    int maxK = Integer.MIN_VALUE;
    for(int i = 1; i<=n; i++){ // i is the cow that is patient zero
      for(int j = 0; j<=t; j++){ // j is the k
        boolean[] inf = new boolean[n+1];
        int[] remainingInt = new int[n+1];
        inf[i] = true;
        for(int k = 0; k<=n; k++){
          remainingInt[k] = j;
        }
        for(int k = 0; k<t; k++){
          if(inf[a[k]] && !inf[b[k]] && remainingInt[a[k]] > 0){
            inf[b[k]] = true;
          }
          else if(!inf[a[k]] && inf[b[k]] && remainingInt[b[k]] > 0){
            inf[a[k]] = true;
          }
          if(inf[a[k]] || inf[b[k]]){
            remainingInt[a[k]]--;
            remainingInt[b[k]]--;
          }
        }
        boolean valid = true;
        for(int k = 1; k<=n; k++){
          if(inf[k] != infected[k]){
            valid = false;
            break;
          }
        }
        if(valid){
          validPZero.add(i);
          minK = Math.min(minK, j);
          maxK = Math.max(maxK, j);
        }
      }
    }
    String result = String.valueOf(validPZero.size()) + " " + String.valueOf(minK) + " ";
    if(maxK == t){
      result += "Infinity";
    }
    else{
      result += String.valueOf(maxK);
    }
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("tracing.out"));
    out.println(result);
    out.close();
  }
  static int findIndex(int[] arr, int k){
    for(int i = 0; i<arr.length; i++){
      if(arr[i] == k){
        return i;
      }
    }
    return -1;
  }
}
