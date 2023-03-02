import java.util.*;
import java.io.*;

public final class taming {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("taming.in"));
    int n = in.nextInt();
    int[] log = new int[n];
    for(int i = 0; i<n; i++){
      log[i] = in.nextInt();
    }
    in.close();
    PrintWriter out = new PrintWriter(new File("taming.out"));
    if(log[0] > 0){
      System.out.println("-1");
      out.println(-1);
      out.close();
      System.exit(0);
    }
    log[0] = 0;

    for(int i = n-1; i>=0; i--){
      // System.out.println(log[i]);
      if(log[i] > 0){
        int counter = log[i]-1;
        for(int j = i-1; j>=i-log[i]; j--){
          if(log[j] != -1 && log[j] != counter){
            System.out.println("-1");
            out.println(-1);
            out.close();
            System.exit(0);
          }
          log[j] = counter;
          counter--;
        }
      }
    }
    // System.out.println(Arrays.toString(log));
    int lowest = 0;
    for(int i = 0; i<n; i++){
      if(log[i] == 0){
        lowest++;
      }
    }
    int highest = 0;
    for(int i = 0; i<n; i++){
      if(log[i] == 0 || log[i] == -1){
        highest++;
      }
    }
    System.out.println(String.valueOf(lowest) + " " + String.valueOf(highest));
    out.println(String.valueOf(lowest) + " " + String.valueOf(highest));
    out.close();
  }
}
