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
    log[0] = 0;
    for(int i = n-1; i>=0; i--){
      System.out.println(log[i]);
      if(log[i] > 0){
        int counter = log[i]-1;
        for(int j = i-1; j>=i-log[i]; j--){
          log[j] = counter;
          counter--;
        }
      }
    }
    System.out.println(Arrays.toString(log));
  }
}
