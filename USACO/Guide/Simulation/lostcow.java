// Time taken: 34 min 59 sec

import java.util.*;
import java.io.*;

public class lostcow {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("lostcow.in"));
    int x = in.nextInt();
    int y = in.nextInt();
    in.close();

    int result = 0;
    int modifier = 1;
    while(true){
      int target = x+modifier;
      if(y >= x && y <= target && modifier >= 0 || y <= x && y >= target && modifier <= 0){
          result += Math.abs(y-x);
          break;
      }
      result += Math.abs(modifier)*2;
      modifier *= -2;
    }
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("lostcow.out"));
    out.println(result);
    out.close();
  }
}