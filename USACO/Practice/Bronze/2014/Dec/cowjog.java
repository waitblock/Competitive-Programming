import java.util.*;
import java.io.*;

public class cowjog {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("cowjog.in"));
    int n = in.nextInt();
    // int[] positions = new int[n];
    int[] speeds = new int[n];
    for(int i = 0; i<n; i++){
      // positions[i] = in.nextInt();
      in.nextInt();
      speeds[i] = in.nextInt();
    }
    // System.out.println(Arrays.toString(positions));
    int slowest = speeds[n-1];
    int result = 1;
    for(int i = n-2; i>=0; i--){
      if(speeds[i] > slowest) {}
      else result++;
      slowest = Math.min(slowest, speeds[i]);
    }
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("cowjog.out"));
    out.println(result);
    out.close();
  }
}