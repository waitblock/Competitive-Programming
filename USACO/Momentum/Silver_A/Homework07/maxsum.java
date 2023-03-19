import java.util.*;
import java.io.*;

public final class maxsum {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.print("Enter directory: ");
    String dir = in.next();
    while(true){
      System.out.print("Enter filename: ");
      String f = in.next();
      try{
        solve(dir+"/"+f);
      }
      catch(Exception e){
        e.printStackTrace(System.err);
      }
    }
  }
  static void solve(String filename) throws FileNotFoundException {
    Scanner in = new Scanner(new File(filename));
    PriorityQueue<Integer> p = new PriorityQueue<>();
    int n = in.nextInt();
    int k = in.nextInt();
    for(int i = 0; i<n; i++){
      p.add(in.nextInt());
    }
    while(k-- > 0){
      p.add(-p.poll());
    }
    long result = 0;
    for(int i = 0; i<n; i++){
      result += (long) p.poll();
    }
    System.out.println(result);
  }
}