// time taken: 23 min 29 sec

import java.util.*;
import java.io.*;

public class shell {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("shell.in"));
    int n = in.nextInt();
    int[][] swaps = new int[n][3];
    for(int i = 0; i<n; i++){
      for(int j = 0; j<3; j++){
        swaps[i][j] = in.nextInt();
      }
    }

    int[] counter = new int[3];

    // starts under shell 1
    for(int i = 0; i<3; i++){
      int shell = i+1;
      for(int j = 0; j<n; j++){
        int[] swap = swaps[j];
        if(swap[0] == shell){
          // System.out.println(swap[1]);
          shell = swap[1];
        }
        else if(swap[1] == shell){
          shell = swap[0];
        }
        if(swap[2] == shell) counter[i]++;
        // System.out.println(Arrays.toString(swap));
        // System.out.println(shell);
      }
    }

    // System.out.println(Arrays.toString(counter));

    int result = -Integer.MAX_VALUE;
    for(int i : counter){
      result = Math.max(result, i);
    }
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("shell.out"));
    out.println(result);
    out.close();
  }
}