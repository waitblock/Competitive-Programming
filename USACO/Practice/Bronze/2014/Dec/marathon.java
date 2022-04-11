import java.util.*;
import java.io.*;

public class marathon {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("marathon.in"));
    int n = in.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    for(int i = 0; i<n; i++){
      x[i] = in.nextInt();
      y[i] = in.nextInt();
    }
    in.close();
    int[] distances = new int[n-1];
    // distance[i] = distance from point i to point i+1
    for(int i = 0; i<n-1; i++){
      distances[i] = Math.abs(x[i]-x[i+1]) + Math.abs(y[i]-y[i+1]);
    }
    int result = Integer.MAX_VALUE;
    for(int i = 1; i<n-1; i++){
      int distance = 0;
      for(int j = 0; j<i-1; j++){
        distance += distances[j];
      }
      distance += Math.abs(x[i-1] - x[i+1]) + Math.abs(y[i-1] - y[i+1]);
      for(int j = i+1; j<n-1; j++){
        distance += distances[j];
      }
      result = Math.min(distance, result);
    }
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("marathon.out"));
    out.println(result);
    out.close();
  }
}