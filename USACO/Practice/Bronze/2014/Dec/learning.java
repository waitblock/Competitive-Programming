// time complexity: O(N*(B-A+1)) --- Linear NNS

import java.util.*;
import java.io.*;

public class learning {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("learning.in"));
    int n = in.nextInt();
    int a = in.nextInt();
    int b = in.nextInt();
    boolean[] hasSpots = new boolean[n];
    int[] weight = new int[n];
    for(int i = 0; i<n; i++){
      if(in.next().equals("S")) {
        hasSpots[i] = true;
      }
      else{
        hasSpots[i] = false;
      }
      weight[i] = in.nextInt();
    }
    in.close();
    // System.out.println(Arrays.toString(hasSpots));
    // System.out.println(Arrays.toString(weight));
    int result = 0;
    for(int i = a; i<=b; i++){
      int closestDist = Math.abs(i-weight[0]); // distance from closest point
      int closest = 0; // index of closest point
      for(int j = 1; j<n; j++){
        int dist = Math.abs(i-weight[j]);
        if(dist < closestDist){
          closestDist = dist;
          closest = j;
        }
      }
      // System.out.println(closestDist);
      // System.out.println(weight[closest]);
      for(int j = 0; j<n; j++){
        int dist = Math.abs(i-weight[j]);
        if(dist == closestDist){
          if(hasSpots[j]){
            closest = j;
          }
        }
      }
      if(hasSpots[closest]){
        // System.out.println(i);
        result++;
      }
    }
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("learning.out"));
    out.println(result);
    out.close();
  }
}