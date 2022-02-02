// incomplete

import java.util.*;
import java.io.*;

public class censor{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("censor.in"));
    String s = in.nextLine();
    String t = in.nextLine();

    in.close();

    while(true){
      int ind = s.indexOf(t);
      if(ind == -1) break;

      s = s.substring(0, ind) + s.substring(ind+3, s.length());
    }

    System.out.println(s);

    PrintWriter out = new PrintWriter(new File("censor.out"));
    out.println(s);
    out.close();
  }
}