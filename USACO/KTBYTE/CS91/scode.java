import java.util.*;
import java.io.*;

public final class scode {

  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("scode.in"));
    String s = in.next();
    in.close();
    int result = solve(s)-1;
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("scode.out"));
    out.println(result);
    out.close();
  }
  static int solve(String s){
    int result = 1;
    int len = s.length();
    // base case
    if(len % 2 == 0 || len < 2) return 1;
    if(sb(s,0,len/2).equals(sb(s,len/2,len-1))){
      result += solve(sb(s,len/2,len));
    }
    if(sb(s,0,len/2).equals(sb(s,len/2+1,len))){
      result += solve(sb(s,len/2,len));
    }
    if(sb(s,0,len/2).equals(sb(s,len/2+1,len))){
      result += solve(sb(s,0,len/2+1));
    }
    if(sb(s,1,len/2+1).equals(sb(s,len/2+1,len))){
      result += solve(sb(s,0,len/2+1));
    }
    return result;
  }

  static final String sb(String s, int n1, int n2){
    return s.substring(n1, n2);
  }
}