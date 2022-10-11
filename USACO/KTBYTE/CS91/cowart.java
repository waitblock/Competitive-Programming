import java.util.*;
import java.io.*;

public final class cowart {
  static int n;
  static char[][] art;
  static boolean[][] visited;
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("cowart.in"));
    n = in.nextInt();
    art = new char[n][n];
    visited = new boolean[n][n];
    in.nextLine();
    for(int i = 0; i<n; i++){
      art[i] = in.nextLine().toCharArray();
    }
    in.close();
    int human = 0;
    for(int i = 0; i<n; i++){
      for(int j = 0; j<n; j++){
        if(!visited[i][j]){
          human++;
          floodFillHuman(i,j,art[i][j]);
        }
      }
    }
    System.out.println(human);
    int cow = 0;
    for(int i = 0; i<n; i++){
      for(int j = 0; j<n; j++){
        visited[i][j] = false;
      }
    }
    for(int i = 0; i<n; i++){
      for(int j = 0; j<n; j++){
        if(!visited[i][j]){
          cow++;
          floodFillCow(i,j,art[i][j]);
        }
      }
    }
    System.out.println(cow);
    PrintWriter out = new PrintWriter(new File("cowart.out"));
    out.print(human);
    out.print(" ");
    out.print(cow);
    out.close();
  }
  static void floodFillHuman(int r, int c, char color){
    if(r >= n || r < 0 || c >= n || c < 0) return;
    if(art[r][c] != color) return;
    if(visited[r][c]) return;
    visited[r][c] = true;
    floodFillHuman(r+1,c,art[r][c]);
    floodFillHuman(r-1,c,art[r][c]);
    floodFillHuman(r,c+1,art[r][c]);
    floodFillHuman(r,c-1,art[r][c]);
  }
  static void floodFillCow(int r, int c, char color){
    if(r >= n || r < 0 || c >= n || c < 0) return;
    if(art[r][c] != color){
      if(art[r][c] == 'G' && color == 'R' || art[r][c] == 'R' && color == 'G'); // do nothing
      else return;
    }
    if(visited[r][c]) return;
    visited[r][c] = true;
    floodFillCow(r+1,c,art[r][c]);
    floodFillCow(r-1,c,art[r][c]);
    floodFillCow(r,c+1,art[r][c]);
    floodFillCow(r,c-1,art[r][c]);
  }
}