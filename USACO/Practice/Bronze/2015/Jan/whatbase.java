import java.util.*;
import java.io.*;

public class whatbase {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("whatbase.in"));
    PrintWriter out = new PrintWriter(new File("whatbase.out"));
    int k = in.nextInt();
    for(int i = 0; i<k; i++){
      int x = in.nextInt();
      int y = in.nextInt();
      int baseX = 10;
      int baseY = 10;
      while(baseX <= 15000 && baseY <= 15000){
        int tempX = convertDec(x, baseX);
        int tempY = convertDec(y, baseY);
        // System.out.println(baseX);
        // System.out.println(tempX);
        // System.out.println("---");
        // System.out.println(baseY);
        // System.out.println(tempY);
        // System.out.println("===");
        if(tempX > tempY){
          baseY++;
        }
        if(tempX < tempY){
          baseX++;
        }
        if(tempX == tempY){
          // System.out.println(String.valueOf(baseX) + " " + String.valueOf(baseY));
          out.println(String.valueOf(baseX) + " " + String.valueOf(baseY));
          break;
        }
      }
    }
    in.close();
    out.close();
  }
  static int convertDec(int n, int base){
    int result = 0;
    char[] a = String.valueOf(n).toCharArray();
    for(int i = 0; i<3; i++){
      String s = "";
      s += a[i];
      result += (Math.pow(base, 2-i)*Integer.parseInt(s));
    }
    return result;
  }
}