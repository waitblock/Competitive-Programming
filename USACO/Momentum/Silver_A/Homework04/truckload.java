import java.util.*;
import java.io.*;

public final class template {
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
    int m = in.nextInt();
    long[] units = new long[n];
    long[] price = new long[n];
    long[] capacity = new long[m];
    for(int i = 0; i<n; i++){
        units[i] = in.nextLong();
        price[i] = in.nextLong();
    }
    for(int i = 0; i<m; i++){
        capacity[i] = in.nextLong();
    }
    in.close();
    long[] load = new long[m];
    long[] truckPrice = new long[m];
    
    int p = 0;
    int c = 0;
    while(true){
        if(p >= n || c >= m) break;
        long req = capacity[c]-load[c];
        long remaining = Math.max(0,units[p]-req);
        long fulfilled = units[p]-remaining;
        load[c] += fulfilled;
        truckPrice[c] += (fulfilled * price[p]);
        units[p] = remaining;
        if(capacity[c] == load[c]){
            c++;
        }
        if(units[p] == 0){
            p++;
        }
    }

    long result = 0;
    for(int i = 0; i<m; i++){
        result += truckPrice[i];
    }
    System.out.println(result);
  }
}