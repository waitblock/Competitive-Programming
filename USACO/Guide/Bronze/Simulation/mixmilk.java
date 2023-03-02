// Time taken: 18 min 31 sec

import java.util.*;
import java.io.*;

public class mixmilk {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("mixmilk.in"));
    int[][] buckets = new int[3][2];
    for(int i = 0; i<3; i++){
      buckets[i][0] = in.nextInt();
      buckets[i][1] = in.nextInt();
    }
    in.close();
    for(int cnt = 0; cnt<100; cnt++){
      int nextIndex = (cnt+1)%3;
      int i = cnt%3;
      int remaining = buckets[nextIndex][0] - buckets[nextIndex][1];
      if (remaining >= buckets[i][1]){
        buckets[nextIndex][1] += buckets[i][1];
        buckets[i][1] = 0;
      }
      else if(remaining < buckets[i][1]){
        buckets[nextIndex][1] = buckets[nextIndex][0];
        buckets[i][1] -= remaining;
      }
    }
    PrintWriter out = new PrintWriter(new File("mixmilk.out"));
    for(int i = 0; i<3; i++){
      out.println(buckets[i][1]);
      System.out.println(buckets[i][1]);
    }
    out.close();
  }
}