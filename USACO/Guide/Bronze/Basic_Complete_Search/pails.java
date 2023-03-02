import java.util.*;
import java.io.*;

public class pails{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("pails.in"));
    int x = in.nextInt();
    int y = in.nextInt();
    int m = in.nextInt();

    in.close();

    int result = Integer.MIN_VALUE;

    for(int i = 0; i<m%x; i++){
      int remaining = m-x*i;
      // System.out.println(x*i);
      int multi_y = (int) remaining/y;
      if(multi_y < 0) continue;
      int total = multi_y * y + x*i;
      // System.out.println(total);
      // System.out.println("--");
      if(total > result && total <= m){
        result = total;
      }
    }

    for(int i = 0; i<m%y; i++){
      int remaining = m-y*i;
      int multi_x = (int) remaining / x;
      if(multi_x < 0) continue;
      int total = multi_x * x + y*i;
      if(total > result && total <= m){
        result = total;
      }
    }

    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("pails.out"));
    out.println(result);
    out.close();
  }
}