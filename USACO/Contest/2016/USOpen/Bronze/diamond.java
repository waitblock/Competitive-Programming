import java.util.*;
import java.io.*;

public class diamond {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("diamond.in"));
    int n = in.nextInt();
    int k = in.nextInt();

    int[] diamonds = new int[n];

    for(int i = 0; i<n; i++){
      diamonds[i] = in.nextInt();
    }
    in.close();

    int result = 0;

    for(int i = 0; i<n; i++){
      int count = 0;
      for(int j = 0; j<n; j++){
        if(diamonds[j] >= diamonds[i] && Math.abs(diamonds[j]-diamonds[i]) <= k){
          count += 1;
        }
      }
      result = Math.max(result, count);
    }

    System.out.println("Result: " + String.valueOf(result));

    PrintWriter out = new PrintWriter(new File("diamond.out"));
    out.println(result);
    out.close();
  }
}
