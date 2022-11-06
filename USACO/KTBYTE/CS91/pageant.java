import java.util.*;
import java.io.*;

public final class pageant {
  static char[][] grid;
  static int n, m;
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("pageant.in"));
    n = in.nextInt();
    m = in.nextInt();
    grid = new char[n][m];
    for(int i = 0; i<n; i++){
      grid[i] = in.next().toCharArray();
    }
    int spot = 0;
    for(int i = 0; i<n; i++){
      for(int j = 0; j<m; j++){
        if(grid[i][j] != 'X') continue;
        spot++;
        char cSpot = String.valueOf(spot).charAt(0);
        floodFillSpot(i,j,cSpot);
      }
    }
    int result = Integer.MAX_VALUE;
    for(int i = 0; i<n; i++){
      for(int j = 0; j<m; j++){
        if(grid[i][j] == '1'){
          for(int k = 0; k<n; k++){
            for(int l = 0; l<m; l++){
              if(grid[k][l] == '2') result = Math.min(result, Math.abs(l-j)+Math.abs(k-i));
            }
          }
        }
      }
    }
    result--;
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("pageant.out"));
    out.println(result);
    out.close();
    in.close();
  }
  static void floodFillSpot(int x, int y, char spot){
    if (grid[x][y] != 'X') return;
    grid[x][y] = spot;
    if (x > 0) floodFillSpot(x-1,y,spot);
    if (y > 0) floodFillSpot(x,y-1,spot);
    if (x < n-1) floodFillSpot(x+1,y,spot);
    if (y < m-1) floodFillSpot(x,y+1,spot);
  }
}