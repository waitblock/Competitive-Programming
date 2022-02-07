import java.util.*;
import java.io.*;

public class diamond{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("diamond.in"));
    int n = in.nextInt();
    int k = in.nextInt();

    int[] diamonds = new int[n];

    for(int i = 0; i<n; i++){
      diamonds[i] = in.nextInt();
    }
    in.close();

    int result = Integer.MIN_VALUE;

    for(int i = 0; i<n; i++){
      int count = 0;
      for(int j = 0; j<n; j++){
        // System.out.println(Math.abs(diamonds[i]-diamonds[j]));
        if(diamonds[j]-diamonds[i] <= k && diamonds[i] <= diamonds[j]){
          count++;
        }
      }
      // System.out.println(count);
      result = Math.max(count, result);
      // System.out.println("--");
    }

    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("diamond.out"));
    out.println(result);
    out.close();
  }
}