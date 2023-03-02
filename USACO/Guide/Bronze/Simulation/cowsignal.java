// Time taken: 12 min 57 sec

import java.util.*;
import java.io.*;

public class cowsignal {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("cowsignal.in"));
    int m = in.nextInt();
    int n = in.nextInt();
    int k = in.nextInt();

    in.nextLine();

    String[] lines = new String[m];
    for(int i = 0; i<m; i++){
      lines[i] = in.nextLine();
    }
    System.out.println(Arrays.toString(lines));

    in.close();

    PrintWriter out = new PrintWriter(new File("cowsignal.out"));
    for(int a = 0; a<m; a++){
      String current = lines[a];
      String scaled = "";
      for(int b = 0; b<n; b++){
        String temp = "" + current.charAt(b);
        for(int c = 0; c<k; c++){
          scaled += temp;
        }
      }
      for(int b = 0; b<k; b++){
        out.println(scaled);
        System.out.println(scaled);
      }

    }
    out.close();
  }
}