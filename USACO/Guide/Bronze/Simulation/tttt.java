import java.util.*;
import java.io.*;

public class tttt{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("tttt.in"));
    String[][] board = new String[3][3];
    for(int i = 0; i<3; i++){
      char[] temp = in.nextLine().toCharArray();
      for(int j = 0; j<3; j++){
        board[i][j] = "" + temp[j];
      }
    }

    in.close();

    HashSet<String> oneWin = new HashSet<>();
    HashSet<ArrayList<String>> twoWin = new HashSet<>();

    // check verticals and horizontals
    for(int i = 0; i<3; i++){
      HashSet<String> horizontal = new HashSet<>();
      HashSet<String> vertical = new HashSet<>();
      for(int j = 0; j<3; j++){
        horizontal.add(board[i][j]);
      }
      for(int j = 0; j<3; j++){
        vertical.add(board[j][i]);
      }
      if(horizontal.size() == 1){
        oneWin.add(new ArrayList<String>(horizontal).get(0));
      }
      if(horizontal.size() == 2){
        ArrayList<String> temp = new ArrayList<String>(horizontal);
        Collections.sort(temp);
        twoWin.add(temp);
      }
      if(vertical.size() == 1){
        oneWin.add(new ArrayList<String>(vertical).get(0));
      }
      if(vertical.size() == 2){
        ArrayList<String> temp = new ArrayList<String>(vertical);
        Collections.sort(temp);
        twoWin.add(temp);
      }
    }

    // check diagonals
    HashSet<String> set = new HashSet<>();

    set.add(board[0][0]);
    set.add(board[1][1]);
    set.add(board[2][2]);

    if(set.size() == 1){
      oneWin.add(new ArrayList<String>(set).get(0));
    }
    if(set.size() == 2){
      ArrayList<String> temp = new ArrayList<String>(set);
      Collections.sort(temp);
      twoWin.add(temp);
    }

    set.clear();

    set.add(board[0][2]);
    set.add(board[1][1]);
    set.add(board[2][0]);

    if(set.size() == 1){
      oneWin.add(new ArrayList<String>(set).get(0));
    }
    if(set.size() == 2){
      ArrayList<String> temp = new ArrayList<String>(set);
      Collections.sort(temp);
      twoWin.add(temp);
    }

    System.out.println(oneWin.size());
    System.out.println(twoWin.size());

    PrintWriter out = new PrintWriter(new File("tttt.out"));
    out.println(oneWin.size());
    out.println(twoWin.size());
    out.close();
  }
}

/*
Board:

1 2 3
4 5 6
7 8 9

(0,0) (0,1) (0,2)
(1,0) (1,1) (1,2)
(2,0) (2,1) (2,2)

possible ways to win:
1-4-7
2-5-8
3-6-9

1-2-3
4-5-6
7-8-9

1-5-9
3-5-7
*/