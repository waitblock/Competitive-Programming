import java.util.*;
import java.io.*;

public final class outofplace {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("outofplace.in"));
    int n = in.nextInt();
    int[] init = new int[n];
    for(int i = 0; i<n; i++){
      init[i] = in.nextInt();
    }
    int[] sorted = new int[n];
    for(int i = 0; i<n; i++){
      sorted[i] = init[i];
    }
    Arrays.sort(sorted);
    int result = 0;
    for(int i = 0; i<n; i++){
      if(init[i] != sorted[i]) result++;
    }
    if(result > 0) result--;
    PrintWriter out = new PrintWriter(new File("outofplace.out"));
    out.println(result);
    out.close();
  }
}