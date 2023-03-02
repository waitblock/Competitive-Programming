import java.util.*;
import java.io.*;

public final class cowtip {
  public static void main(String[] args) throws FileNotFoundException {
      Scanner in = new Scanner(new File("cowtip.in"));
      PrintWriter out = new PrintWriter(new File("cowtip.out"));
      int n = in.nextInt();
      int[][] cows = new int[n][n];
      for(int i = 0; i<n; i++){
        char[] temp = in.next().toCharArray();
        for(int j = 0; j<n; j++){
          cows[i][j] = temp[j] == '1' ? 1 : 0;
        }
      }
      int result = 0;
      for(int i = n-1; i>=0; i--){
        for(int j = n-1; j>=0; j--){
          if(cows[i][j] == 1){
            flip(cows,i,j);
            result++;
          }
        }
      }
      // System.out.println(result);
      out.println(result);
      in.close();
      out.close();
  }
  static void flip(int[][] cows, int r, int c){
    for(int i = 0; i<=r; i++){
      for(int j = 0; j<=c; j++){
        cows[i][j] = 1-cows[i][j];
      }
    }
  }
}
