import java.util.*;
import java.io.*;

public final class coprime_v2 {
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
    long[] a = new long[n];
    for(int i = 0; i<n; i++){
      a[i] = in.nextLong();
    }
    ArrayList<Long> s = new ArrayList<>();
    for(long l : a){
      long temp = l;
      while(s.size() > 0){
        long g = gcd(temp, s.get(s.size()-1));
        if(g <= 1) break;
        long last = s.remove(s.size()-1);
        temp = last * temp / g;
      }
      s.add(temp);
      // System.out.println(s);
    }
    long result = 0;
    for(long l : s) result += l;
    result %= MOD;
    System.out.println(result);
    in.close();
  }

  static long gcd(long a, long b){
    if(b==0) return a;
    return gcd(b,a%b);
  }
}