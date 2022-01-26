import java.util.*;
import java.io.*;

public class cbarn{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("cbarn.in"));
    int n = in.nextInt();
    int[] targets = new int[n];
    for(int i = 0; i<n; i++){
      targets[i] = in.nextInt();
    }
    in.close();

    int result = Integer.MAX_VALUE;
    for(int i = 0; i<n; i++){
      int distance = 0;
      int counter = 0;
      // System.out.println("---");
      for(int j = i; j<i+n; j++){
        // System.out.println(targets[j%n]);
        // System.out.println(targets[j%(n-1)] * counter);
        distance += (targets[j%n] * counter);
        counter++;
      }
      // System.out.println(distance);
      if(distance < result){
        result = distance;
      }
    }
    PrintWriter out = new PrintWriter(new File("cbarn.out"));
    out.println(result);
    System.out.println(result);
    out.close();
  }
}