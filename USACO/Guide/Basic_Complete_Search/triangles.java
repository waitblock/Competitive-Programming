import java.util.*;
import java.io.*;

public class triangles {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("triangles.in"));

    int n = in.nextInt();
    int[][] points = new int[n][2];

    for(int i = 0; i<n; i++){
      points[i][0] = in.nextInt();
      points[i][1] = in.nextInt();
    }

    int result = 0;

    for(int i = 0; i<n-2; i++){
      for(int j = i+1; j<n-1; j++){
        for(int k = j+1; k<n; k++){
          // System.out.println(Arrays.toString(points[i]));
          // System.out.println(Arrays.toString(points[j]));
          // System.out.println(Arrays.toString(points[k]));
          // System.out.println(area(points[i], points[j], points[k]));
          // System.out.println(valid(points[i], points[j], points[k]));
          // System.out.println("---");
          if(valid(points[i], points[j], points[k])){
            result = Math.max(area(points[i], points[j], points[k]), result);
          }
        }
      }
    }

    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("triangles.out"));
    out.println(result);
    out.close();
  }

  static int area(int[] c1, int[] c2, int[] c3){
    int ax = c1[0];
    int ay = c1[1];
    int bx = c2[0];
    int by = c2[1];
    int cx = c3[0];
    int cy = c3[1];

    return Math.abs((ax-cx) * (by-ay) - (ax-bx) * (cy-ay));
  }

  static boolean valid(int[] c1, int[] c2, int[] c3){
    int ax = c1[0];
    int ay = c1[1];
    int bx = c2[0];
    int by = c2[1];
    int cx = c3[0];
    int cy = c3[1];

    return (ax == bx || ax == cx || bx == cx) && (ay == by || ay == cy || by == cy);
  }
}