import java.util.*;

public final class C {
  static int[][] grid;
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    grid = new int[n][n];
    for(int i = 0; i<n; i++){
      for(int j = 0; j<n; j++){
        grid[i][j] = in.nextInt();
      }
    }
    int rows = 0;
    int cols = 0;
    for(int i = 0; i<grid.length; i++){
      if(r(i) % 2 != 0) rows++;
    }
    for(int i = 0; i<grid[0].length; i++){
      if(c(i) % 2 != 0) cols++;
    }
    System.out.println(rows <= 1 && cols <= 1 ? "YES" : "NO");
  }
  static int r(int row){
    int result = 0;
    for(int i = 0; i<grid.length; i++){
      result += grid[row][i];
    }
    return result;
  }
  static int c(int col){
    int result = 0;
    for(int i = 0; i<grid.length; i++){
      result += grid[i][col];
    }
    return result;
  }
}