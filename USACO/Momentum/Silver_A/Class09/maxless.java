import java.util.*;
import java.io.*;

public final class maxless {
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
    int n = in.nextInt();
    int[] a = new int[n];
    TreeMap<Integer, Integer> freq = new TreeMap<>();
    for(int i = 0; i<n; i++){
      a[i] = in.nextInt();
      int temp = 1;
      if(freq.get(a[i]) != null){
        temp += freq.get(a[i]);
      }
      freq.put(a[i],temp);
      if(i == 0) continue;
      if(freq.lowerKey(a[i]) == null){
        out.println(-1);
        continue;
      }
      out.print(freq.lowerKey(a[i]));
      out.print(" ");
      out.println(freq.get(freq.lowerKey(a[i])));
    }
    in.close();
    out.close();
  }
}