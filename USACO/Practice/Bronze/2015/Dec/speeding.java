import java.util.*;
import java.io.*;

public class speeding {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("speeding.in"));
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] road = new int[n][2];
    int[][] cow = new int[m][2];
    for(int i = 0; i<n; i++){
      road[i][0] = in.nextInt();
      road[i][1] = in.nextInt();
    }
    for(int i = 0; i<m; i++){
      cow[i][0] = in.nextInt();
      cow[i][1] = in.nextInt();
    }
    in.close();
    int[] roadSpeed = new int[100];
    int[] cowSpeed = new int[100];
    int counter = 0;
    for(int i = 0; i<n; i++){
      for(int j = 0; j<road[i][0]; j++){
        roadSpeed[counter] = road[i][1];
        counter++;
      }
    }
    counter = 0;
    for(int i = 0; i<m; i++){
      for(int j = 0; j<cow[i][0]; j++){
        cowSpeed[counter] = cow[i][1];
        counter++;
      }
    }
    int result = 0;
    // System.out.println(Arrays.toString(roadSpeed));
    // System.out.println(Arrays.toString(cowSpeed));
    for(int i = 0; i<100; i++){
      if(cowSpeed[i] <= roadSpeed[i]) continue;
      result = Math.max(result, Math.abs(roadSpeed[i]-cowSpeed[i]));
    }
    PrintWriter out = new PrintWriter(new File("speeding.out"));
    out.println(result);
    // System.out.println(result);
    out.close();
  }
}