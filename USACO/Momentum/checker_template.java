import java.util.*;
import java.io.*;

public final class checker_template {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter directory: ");
    String dir = in.next();
    while(true){
      System.out.print("Enter test case name/number: ");
      String f = in.next();
      try{
        solve(dir+"/"+f+".in");
      }
      catch(Exception e){
        e.printStackTrace(System.err);
      }
      boolean pass = true;
      try{
        Scanner expected = new Scanner(new File(dir+"/"+f+".out"));
        Scanner output = new Scanner(new File("result.out"));
        while(output.hasNext()){
          String exp = expected.next();
          String out = output.next();
          if(!exp.equals(out)){
            pass = false;
            break;
          }
        }
      }
      catch(Exception e){
        e.printStackTrace(System.err);
        pass = false;
      }
      System.out.println(pass ? "PASS" : "FAIL");
    }
  }
  static void solve(String filename) throws FileNotFoundException {
    Scanner in = new Scanner(new File(filename));
    PrintWriter out = new PrintWriter(new File("result.out"));
    // code goes here
    in.close();
    out.close();
  }
}