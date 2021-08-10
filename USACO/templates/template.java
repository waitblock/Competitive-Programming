// NOTE TO SELF: DO NOT USE THIS TEMPLATE DURING THE REAL USACO CONTEST

import java.util.*;
import java.io.*;

public class template {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("problem.in"));
    ArrayList<String> lines = new ArrayList<String>();
    while(in.hasNextLine()){
      lines.add(in.nextLine());
    }
    in.close();

    int result = 0;
    PrintWriter out = new PrintWriter(new File("problem.out"));
    out.println(result);
    out.close();
  }
}
