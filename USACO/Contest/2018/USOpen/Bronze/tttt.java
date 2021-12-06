import java.util.*;
import java.io.*;

public class tttt {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("tttt.in"));
    char[][] board = new char[3][3];
    for(int i = 0; i<3; i++){
      board[i] = in.nextLine().toCharArray();
    }
    in.close();

    for(int i = 0; i<3; i++){
      System.out.println(Arrays.toString(board[i]));
    }
    System.out.println("---");

    TreeSet<Character> cows_ = new TreeSet<>();
    for(int i = 0; i<3; i++){
      for(int j = 0; j<3; j++){
        cows_.add(board[i][j]);
      }
    }
    ArrayList<Character> cows = new ArrayList<>(cows_);
    // System.out.println(cows);

    int oneCow = 0;
    for(int i = 0; i<cows.size(); i++){
      if(possibleWin1(cows.get(i), board)){
        oneCow++;
      }
    }

    ArrayList<char[]> cowPairs = new ArrayList<>();
    for(int i = 0; i<cows.size(); i++){
      for(int j = i+1; j<cows.size(); j++){
        char[] temp = {cows.get(i), cows.get(j)};
        cowPairs.add(temp);
      }
    }
    // for(int i = 0; i<cowPairs.size(); i++){
    //   System.out.println(cowPairs.get(i));
    // }

    int twoCow = 0;
    for(int i = 0; i<cowPairs.size(); i++){
      if(possibleWin2(cowPairs.get(i), board)){
        twoCow++;
      }
    }

    System.out.println(oneCow);
    System.out.println(twoCow);
    PrintWriter out = new PrintWriter(new File("tttt.out"));
    out.println(oneCow);
    out.println(twoCow);
    out.close();
  }

  static boolean possibleWin1(char p, char[][] board){
    for(int i = 0; i<3; i++){
      if(board[i][0] == p && board[i][1] == p && board[i][2] == p){
        return true;
      }
    }
    for(int i = 0; i<3; i++){
      if(board[0][i] == p && board[1][i] == p && board[2][i] == p){
        return true;
      }
    }
    if(board[0][0] == p && board[1][1] == p && board[2][2] == p){
      return true;
    }
    if(board[0][2] == p && board[1][1] == p && board[2][0] == p){
      return true;
    }
    return false;
  }

  static boolean possibleWin2(char[] pair, char[][] board){
    char p1 = pair[0];
    char p2 = pair[1];
    for(int i = 0; i<3; i++){
      if((board[i][0] == p1 || board[i][0] == p2) && (board[i][1] == p1 || board[i][1] == p2) && (board[i][2] == p1 || board[i][2] == p2)){
        if(board[i][0] == p1 && board[i][1] == p1 && board[i][2] == p1){
          continue;
        }
        if(board[i][0] == p2 && board[i][1] == p2 && board[i][2] == p2){
          continue;
        }
        return true;
      }
    }
    for(int i = 0; i<3; i++){
      if((board[0][i] == p1 || board[0][i] == p2) && (board[1][i] == p1 || board[1][i] == p2) && (board[2][i] == p1 || board[2][i] == p2)){
        if(board[0][i] == p1 && board[1][i] == p1 && board[2][i] == p1){
          continue;
        }
        if(board[0][i] == p2 && board[1][i] == p2 && board[2][i] == p2){
          continue;
        }
        return true;
      }
    }
    for(int i = 0; i<1; i++){
      if((board[0][0] == p1 || board[0][0] == p2) && (board[1][1] == p1 || board[1][1] == p2) && (board[2][2] == p1 || board[2][2] == p2)){
        if(board[0][0] == p1 && board[1][1] == p1 && board[2][2] == p1){
          break;
        }
        if(board[0][0] == p2 && board[1][2] == p2 && board[2][2] == p2){
          break;
        }
        return true;
      }
    }
    for(int i = 0; i<1; i++){
      if((board[0][2] == p1 || board [0][2] == p2) && (board[1][1] == p1 || board[1][1] == p2) && (board[2][0] == p1 || board[2][0] == p2)){
        if(board[0][2] == p1 && board[1][1] == p1 && board[2][0] == p1){
          break;
        }
        if(board[0][2] == p2 && board[1][1] == p2 && board[2][0] == p2){
          break;
        }
        return true;
      }
    }
    return false;
  }
}