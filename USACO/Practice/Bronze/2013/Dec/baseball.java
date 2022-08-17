import java.util.*;
import java.io.*;

public class baseball {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("baseball.in"));
    int n = in.nextInt();
    int[] positions = new int[n];
    for(int i = 0; i < n; i++){
      positions[i] = in.nextInt();
    }
    in.close();
    Arrays.sort(positions);
    // System.out.println(Arrays.toString(positions));
    int result = 0;
    for(int i = 0; i < n-2; i++){
      for(int j = i+1; j < n-1; j++){
        for(int k = j+1; k < n; k++){
          if(positions[j] - positions[i] <= positions[k] - positions[j] && (positions[j] - positions[i]) * 2 >= positions[k] - positions[j]){
            result++;
          }
        }
      }
    }
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("baseball.out"));
    out.println(result);
    out.close();
  }
}

/*
Farmer John notes that
the second throw travels at least as far and no more than twice as far as
the first throw.  Please count the number of possible triples of cows
(X,Y,Z) that Farmer John could have been watching.

*/
