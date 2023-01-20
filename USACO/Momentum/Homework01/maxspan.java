import java.util.*;
import java.io.*;

public final class maxspan {
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
  static void solve(String filename) throws FileNotFoundException{
    Scanner in = new Scanner(new File(filename));
    int n = in.nextInt();
    int[] a = new int[n];
    for(int i = 0; i<n; i++){
      a[i] = in.nextInt();

    in.close();

    HashMap<Integer, Integer> first = new HashMap<>();

    for(int i = 0; i<n; i++){
      if(!first.keySet().contains(a[i])){
        first.put(a[i],i);
      }
    }

    int ans = Integer.MIN_VALUE;
    for(int i = 0; i<n; i++){
      ans = Math.max(ans, Math.abs(i-first.get(a[i]))+1);
    }
    System.out.println(ans);
  }
}