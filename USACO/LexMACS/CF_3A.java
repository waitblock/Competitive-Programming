import java.util.*;

public final class CF_3A {
  static int minSteps = 8;
  static ArrayList<String> moves = new ArrayList<>();
  static int endCol;
  static int endRow;

  public static void main(String[] args) {
    String[] l = {"a","b","c","d","e","f","g","h"};
    ArrayList<String> letters = new ArrayList<>();
    for(int i = 0; i<l.length; i++) letters.add(l[i]);
    Scanner in = new Scanner(System.in);
    String c1 = in.next();
    String c2 = in.next();
    int startCol = letters.indexOf(c1.substring(0,1));
    int startRow = 8-Integer.parseInt(c1.substring(1,2));
    endCol = letters.indexOf(c2.substring(0,1));
    endRow = 8-Integer.parseInt(c2.substring(1,2));
    ArrayList<String> al = new ArrayList<>();
    solve(startRow, startCol, 0, al);
    System.out.println(minSteps);
    // System.out.println(moves);
    for(String move : moves){
      System.out.println(move);
    }
  }

  static void solve(int curRow, int curCol, int steps, ArrayList<String> instrs){
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{1,-1},{-1,1},{1,1}}; // {r,c}
    String[] instr = {"D","U","R","L","LU","LD","RU","RD"};
    if(curRow == endRow && curCol == endCol){
      if(steps < minSteps){
        minSteps = steps;
        moves.clear();
        for(String move : instrs){
          moves.add(move);
        }
      }
      return;
    }
    if(steps == 7){
      // failed to find path; 7 is max number of steps
      return;
    }
    for(int i = 0; i<8; i++){
      int newRow = curRow + directions[i][0];
      int newCol = curCol + directions[i][1];
      instrs.add(instr[i]);
      solve(newRow, newCol, steps+1, instrs);
      instrs.remove(instrs.size()-1);
    }

    return;
  }
}