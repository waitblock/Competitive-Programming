import java.util.*;
import java.io.*;

public class outofplace {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("outofplace.in"));
    int n = in.nextInt();

    int[] a = new int[n];
    int[] b = new int[n];

    for(int i = 0; i<n; i++){
      int next = in.nextInt();
      a[i] = next;
      b[i] = next;
    }

    in.close();

    Arrays.sort(b);

    int result = 0;

    for(int i = 0; i<n; i++){
      if(a[i] != b[i]) {
        result++;
      }
    }

    PrintWriter out = new PrintWriter(new File("outofplace.out"));
    out.println(result-1);
    System.out.println(result-1);
    out.close();
  }
}

/*
- make two arrays and fill them both with the input
- sort one array
- output the amount of different elements in each array
*/
