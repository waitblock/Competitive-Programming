// 9 min 27 sec

import java.util.*;
import java.io.*;

public final class hps_v2 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("hps.in"));
    int n = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for(int i = 0; i<n; i++){
      a[i] = in.nextInt();
      b[i] = in.nextInt();
    }
    int[][] combinations = {{1,2,3}, {1,3,2}, {2,1,3},{2,3,1},{3,2,1},{3,1,2}};
    int maxWins = Integer.MIN_VALUE;;
    for(int i = 0; i<combinations.length; i++){
      int[] t = combinations[i];
      int c = 0;
      for(int j = 0; j<n; j++){
        if((a[j] == t[0] && b[j] == t[2]) || (a[j] == t[1] && b[j] == t[0]) || (a[j] == t[2] && b[j] == t[1])){
          c++;
        }
      }
      maxWins = Math.max(maxWins, c);
    }
    // System.out.println(maxWins);
    PrintWriter out = new PrintWriter(new File("hps.out"));
    out.println(maxWins);
    out.close();
    in.close();
  }
}

/*
H P S

H beats S
P beats H
S beats P
*/