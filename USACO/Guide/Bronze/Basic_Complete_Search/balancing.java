import java.util.*;
import java.io.*;

public class balancing {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("balancing.in"));
    int n = in.nextInt();
    int b = in.nextInt();
    int[][] points = new int[n][2];

    for(int i = 0; i<n; i++){
      points[i][0] = in.nextInt();
      points[i][1] = in.nextInt();
    }

    int result = Integer.MAX_VALUE;

    // for(int i = 0; i<b; i+=2){
    //   for(int j = 0; j<b; j+=2){
    //     // System.out.println(countM(points, i, j));
    //     result = Math.min(countM(points, i, j), result);
    //   }
    // }

    for(int i = 0; i<n; i++){
      for(int j = 0; j<n; j++){
        int x = points[i][0]+1;
        int y = points[j][1]+1;
        result = Math.min(countM(points, x, y), result);
      }
    }

    System.out.println(result);

    PrintWriter out = new PrintWriter(new File("balancing.out"));
    out.println(result);
    out.close();
  }

  static int countM(int[][] points, int a, int b){
    int[] count = new int[4];
    for(int i = 0; i<points.length; i++){
      int x = points[i][0];
      int y = points[i][1];

      if(x > a && y > b) count[0]++;
      if(x < a && y > b) count[1]++;
      if(x < a && y < b) count[2]++;
      if(x > a && y < b) count[3]++;
    }
    int result = 0;
    for(int i = 0; i<4; i++) result = Math.max(result, count[i]);
    return result;
  }
}