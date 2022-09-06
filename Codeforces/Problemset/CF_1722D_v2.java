import java.util.*;
import java.io.*;

public final class CF_1722D_v2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int t = in.nextInt();
    for(int testcase = 0; testcase < t; testcase++){
      int n = in.nextInt();
      char[] line = in.next().toCharArray();
      int[] count = new int[n];
      long sum = 0;
      for(int i = 0; i<n; i++){
        count[line[i] == 'L' ? i : n-i-1]++;
        sum += line[i] == 'L' ? i : n-i-1;
      }
      // System.out.println(Arrays.toString(count));
      int c = 0;
      for(int k = 1; k<=n; k++){
        while(count[c] == 0) c++;
        if(n-c-1 > c){
          count[c]--;
          sum += n-c-1;
          sum -= c;
        }
        out.print(sum);
        out.print(" ");
      }
      out.println();
    }
    in.close();
    out.close();
  }
}