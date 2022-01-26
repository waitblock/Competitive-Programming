import java.util.*;
import java.io.*;

public class blist {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("blist.in"));
    int n = in.nextInt();
    int[][] store = new int[n][3];
    for(int i = 0; i<n; i++){
      for(int j = 0; j<3; j++){
        store[i][j] = in.nextInt();
      }
    }
    in.close();
    int[] count = new int[1001];
    for(int i = 0; i<n; i++){
      int start = store[i][0];
      int end = store[i][1];
      int buckets = store[i][2];
      for(int j = start; j<end; j++){
        count[j] += buckets;
      }
    }

    int result = -Integer.MAX_VALUE;

    for(int i = 0; i<1001; i++){
      if(count[i] > result){
        result = count[i];
      }
    }
    PrintWriter out = new PrintWriter(new File("blist.out"));
    out.println(result);
    System.out.println(result);
    out.close();
  }
}