// tle 8-12, 14-15

import java.util.*;
import java.io.*;

public class censor{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("censor.in"));
    String s = in.nextLine();
    String t = in.nextLine();

    in.close();

    String result = "";

    // System.out.println(t.length());
    for(int i = 0; i<s.length(); i++){
      result += s.charAt(i);
      // System.out.println(result);
      if(result.length() >= t.length()){
        // System.out.println(result.substring(result.length()-t.length(), result.length()));
        if(result.substring(result.length()-t.length(), result.length()).equals(t)){
          result = result.substring(0,result.length()-t.length());
          // System.out.println(result.substring(0,result.length()-t.length()));
        }
      }
    }

    System.out.println(result);

    PrintWriter out = new PrintWriter(new File("censor.out"));
    out.println(result);
    out.close();
  }
}