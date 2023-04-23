import java.util.*;
import java.io.*;

public final class coprime {
  static final long MOD = 1_000_000_007;

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
    int n = in.nextInt();
    int[] a = new int[n];
    for(int i = 0; i<n; i++){
      a[i] = in.nextInt();
    }
    Deque<Integer> d = new ArrayDeque<>();
    for(int i : a){
      while(true){
        int l = 1;
        if(!d.isEmpty()){
          l = d.getLast();
        }
        int g = gcd(l, i);
        if(g == 1) break;
        int lcm = i * d.removeLast() /g;
        i = lcm;
      }
      d.add(i);
    }
    // System.out.println(d);
    long result = 0;
    while(!d.isEmpty()){
      result += d.poll();
    }
    result %= MOD;
    System.out.println(result);
    in.close();
  }
  static int gcd(int a, int b){
    if(b==0) return a;
    return gcd(b,a%b);
  }
}