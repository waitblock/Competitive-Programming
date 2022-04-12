import java.util.*;
import java.io.*;

public class pails {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("pails.in"));
    int x = in.nextInt();
    int y = in.nextInt();
    int m = in.nextInt();
    in.close();
    int result = 0;
    for(int i = 0; i<(m/x); i++){
      int leftOver = m-(x*i);
      // System.out.println(leftOver);
      int newTotal = (leftOver/y)*y+x*i;
      // System.out.println(newTotal);
      result = Math.max(result, newTotal);
    }
    for(int i = 0; i<(m/y); i++){
      int leftOver = m-(y*i);
      int newTotal = (leftOver/x)*x+y*i;
      // System.out.println(newTotal);
      result = Math.max(result, newTotal);
    }
    PrintWriter out = new PrintWriter(new File("pails.out"));
    out.println(result);
    System.out.println(result);
    out.close();
  }
}