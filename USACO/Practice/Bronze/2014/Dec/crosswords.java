import java.util.*;
import java.io.*;

public class crosswords {
  public static void main(String[] args) throws FileNotFoundException {
    // Scanner in = new Scanner(System.in);
    Scanner in = new Scanner(new File("crosswords.in"));
    int n = in.nextInt();
    int m = in.nextInt();
    in.nextLine();
    char[][] crossword = new char[n+2][m+2];
    for(int i = 0; i<n+2; i++){
      for(int j = 0; j<m+2; j++){
        crossword[i][j] = '#';
      }
    }
    for(int i = 0; i<n; i++){
      char[] temp = in.nextLine().toCharArray();
      for(int j = 0; j<m; j++){
        crossword[i+1][j+1] = temp[j];
      }
    }
    in.close();
    // for(int i = 0; i<n+2; i++) System.out.println(Arrays.toString(crossword[i]));
    ArrayList<Integer> resultX = new ArrayList<>();
    ArrayList<Integer> resultY = new ArrayList<>();
    for(int i = 1; i<n+1; i++){
      for(int j = 1; j<m+1; j++){
        if(crossword[i][j] == '#') continue;
        if(crossword[i-1][j] == '#' && crossword[i+1][j] == '.' && crossword[i+2][j] == '.'){
          resultX.add(i);
          resultY.add(j);
          continue;
        }
        if(crossword[i][j-1] == '#' && crossword[i][j+1] == '.' && crossword[i][j+2] == '.'){
          resultX.add(i);
          resultY.add(j);
          continue;
        }
      }
    }
    for(int i = 0; i<resultX.size(); i++){
      System.out.print(resultX.get(i));
      System.out.print(" ");
      System.out.print(resultY.get(i));
      System.out.println();
    }
    PrintWriter out = new PrintWriter(new File("crosswords.out"));
    out.println(resultX.size());
    for(int i = 0; i<resultX.size(); i++){
      out.print(resultX.get(i));
      out.print(" ");
      out.print(resultY.get(i));
      out.println();
    }
    out.close();
  }
}