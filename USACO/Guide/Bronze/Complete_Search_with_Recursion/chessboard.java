import java.util.*;
import java.io.*;

public final class chessboard {
  static int result = 0;
  static boolean[] column = new boolean[8];
  static boolean[] diag1 = new boolean[15];
  static boolean[] diag2 = new boolean[15];
  static char[][] grid = new char[8][8];
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    for(int i = 0; i<8; i++){
      grid[i] = in.nextLine().toCharArray();
    }
    search(0);
    PrintWriter out = new PrintWriter(System.out);
    out.println(result);
    in.close();
    out.close();
  }
  static void search(int y){
    if(y == 8){
      result++;
      return;
    }
    for(int x = 0; x<8; x++){
      if(column[x] || diag1[x+y] || diag2[x-y+7] || grid[y][x] == '*') continue;
      column[x] = diag1[x+y] = diag2[x-y+7] = true;
      search(y+1);
      column[x] = diag1[x+y] = diag2[x-y+7] = false;
    }
  }
}