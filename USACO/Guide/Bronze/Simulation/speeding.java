// time spent: 24 min 0 sec

import java.util.*;
import java.io.*;

public class speeding {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("speeding.in"));
    int n = in.nextInt();
    int m = in.nextInt();

    int[] limits = new int[100];
    int[] speeds = new int[100];

    int ind = 0;

    for(int i = 0; i<n; i++){
      int length = in.nextInt();
      int limit = in.nextInt();
      for(int j = ind; j<ind+length; j++){
        limits[j] = limit;
      }
      ind += length;
    }

    ind = 0;

    for(int i = 0; i<m; i++){
      int length = in.nextInt();
      int speed = in.nextInt();
      for(int j = ind; j<ind+length; j++){
        speeds[j] = speed;
      }
      ind += length;
    }

    in.close();

    int result = 0;
    for(int i = 0; i<100; i++){
      result = Math.max(speeds[i]-limits[i], result);
    }
    PrintWriter out = new PrintWriter(new File("speeding.out"));
    out.println(result);
    System.out.println(result);
    out.close();
  }
}