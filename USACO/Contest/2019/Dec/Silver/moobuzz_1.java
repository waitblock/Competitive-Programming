// times out on cases 6-13

import java.io.*;
import java.util.*;

public class moobuzz_1 {
  public static void main(String[] args) throws Exception{
    Scanner in = new Scanner(new File("moobuzz.in"));
    int n = in.nextInt();
    in.close();
    int counter = 0;
    int current = 1;
    while(counter != n){ if(current % 3 != 0 && current % 5 != 0) counter++; current++; }
    int result = current-1;
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("moobuzz.out"));
    out.println(result);
    out.close();
  }
}
