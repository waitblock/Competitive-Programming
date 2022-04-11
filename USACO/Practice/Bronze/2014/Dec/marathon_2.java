import java.util.*;
import java.io.*;

public class marathon_2 {
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
    int[] distances = new int[n];
    distances[0] = 0;
    // distances[i] = total distance from point 0 to point i
    int[] revDistances = new int[n];
    revDistances[n-1] = 0;
    int totalDistance = 0;
    for(int i = 0; i<n-1; i++){
      totalDistance += Math.abs(x[i]-x[i+1]) + Math.abs(y[i]-y[i+1]);
      distances[i+1] = totalDistance;
    }
    int totalRevDistance = 0;
    // int inc = 0;
    for(int i = n-1; i>0; i--){
      System.out.println(x[i]);
      totalRevDistance += Math.abs(x[i]-x[i-1]) + Math.abs(y[i]-y[i-1]);
      // revDistances[inc] = totalRevDistance;
      // inc++;
      revDistances[i-1] = totalRevDistance;
    }
    System.out.println(Arrays.toString(distances));
    System.out.println(Arrays.toString(revDistances));
    // System.out.println(totalDistance);
    int result = Integer.MAX_VALUE;
    for(int i = 1; i<n-1; i++){
      int distance = distances[i-1] + revDistances[i+1];
      distance += Math.abs(x[i-1] - x[i+1]) + Math.abs(y[i-1] - y[i+1]);
      result = Math.min(distance, result);
    }
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("marathon.out"));
    out.println(result);
    out.close();
  }
}