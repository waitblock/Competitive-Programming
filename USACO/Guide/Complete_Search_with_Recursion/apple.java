import java.util.*;
import java.io.*;

public final class apple {
  static int n;
  static int[] weights;
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    weights = new int[n];
    for(int i = 0; i<n; i++){
      weights[i] = in.nextInt();
    }
    in.close();
    PrintWriter out = new PrintWriter(System.out);
    out.println(solve(0,0,0));
    out.close();
  }

  static long solve(int index, long sum1, long sum2){
    if(index == n){
      return Math.abs(sum1-sum2);
    }
    return Math.min(solve(index + 1, sum1 + weights[index], sum2),solve(index + 1, sum1, sum2 + weights[index]));
  }
}
