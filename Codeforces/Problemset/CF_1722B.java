// 10m 19s

import java.util.*;
import java.io.*;

public final class CF_1722B {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int t = in.nextInt();
    for(int testcase = 0; testcase < t; testcase++){
      int n = in.nextInt();
      char[] a = in.next().toCharArray();
      char[] b = in.next().toCharArray();
      for(int i = 0; i<n; i++){
        if(a[i] == 'G'){
          a[i] = 'B';
        }
        if(b[i] == 'G'){
          b[i] = 'B';
        }
      }
      boolean same = true;
      for(int i = 0; i<n; i++){
        if(a[i] != b[i]){
          same = false;
          break;
        }
      }
      if(same){
        out.println("YES");
      }
      else{
        out.println("NO");
      }
    }
    in.close();
    out.close();
  }
}
