import java.util.*;
import java.io.*;

public class cowsignal {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("cowsignal.in"));
    PrintWriter out = new PrintWriter(new File("cowsignal.out"));

    int m = in.nextInt();
    int n = in.nextInt();
    int k = in.nextInt();
    in.nextLine();
    char[][] chars = new char[m][n];
    for(int i = 0; i<m; i++){
      String line = in.nextLine();
      chars[i] = line.toCharArray();
    }

    String[] result = new String[m*k];

    int count = 0;

    for(int i = 0; i<chars.length; i++){
      String str = "";
      for(int j = 0; j<n; j++){
        str += multChar(chars[i][j], k);
      }
      for(int j = 0; j<k; j++){
        result[count] = str;
        count++;
      }
    }

    for(int i = 0; i<result.length; i++){
      System.out.println(result[i]);
      out.println(result[i]);
    }

    in.close();
    out.close();
  }

  static String multChar(char str, int n){
    String result = "";
    for(int i = 0; i<n; i++){
      result += ("" + str);
    }
    return result;
  }
}
