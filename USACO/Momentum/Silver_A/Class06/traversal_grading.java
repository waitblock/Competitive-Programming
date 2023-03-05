import java.util.*;
import java.io.*;

public final class traversal_grading {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.print("Enter directory: ");
    String dir = in.next();
    while(true){
      System.out.print("Enter filename: ");
      String f = in.next();
      try{
        solve(dir+"/"+f);
      }
      catch(Exception e){
        e.printStackTrace(System.err);
      }
    }
  }
  static void solve(String filename) throws FileNotFoundException {
    Scanner in = new Scanner(new File(filename));
    long MOD = 1_000_000_007;
    int m = in.nextInt();
    int n = in.nextInt();
    int[][] matrix = new int[m][n];
    for(int i = 0; i<m; i++){
      for(int j = 0; j<n; j++){
        matrix[i][j] = in.nextInt();
      }
    }
    in.close();
    int iter = Math.max(m,n);
    int counter = 0;
    long result = 0;
    for(int i = 0; i<iter; i++){
      for(int j = 0; j<=i; j++){
        if(j >= n) break;
        if(i >= m) break;
        // System.out.print(matrix[i][j]);
        // System.out.print(" ");
        // System.out.println(String.valueOf(i) + " " + String.valueOf(j));
        result += ((long) counter * (long) matrix[i][j]);
        counter++;
      }
      for(int j = i-1; j>=0; j--){
        if(j >= m) break;
        if(i >= n) break;
        // System.out.print(matrix[j][i]);
        // System.out.print(" ");
        // System.out.println(String.valueOf(i) + " " + String.valueOf(j));
        result += ((long) counter * (long) matrix[j][i]);
        counter++;
      }
      // System.out.println();
      
    }
    System.out.println(result%MOD);
  }
}