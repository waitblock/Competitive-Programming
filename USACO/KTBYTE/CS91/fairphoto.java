// INCOMPLETE

import java.util.*;
import java.io.*;

public final class fairphoto {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("fairphoto.in"));
    int n = in.nextInt();
    ArrayList<Cow> cows = new ArrayList<>();
    for(int i = 0; i<n; i++){
      int pos = in.nextInt();
      String breed = in.next();
      cows.add(new Cow(pos, breed));
    }
    in.close();
    Collections.sort(cows);
    int[] prefix = new int[n+1];
    prefix[0] = 0;
    int sum = 0;
    for(int i = 0; i<n; i++){
      sum += cows.get(i).breed == 'G' ? 1 : -1;
      prefix[i+1] = sum;
    }
    System.out.println(Arrays.toString(prefix));
    int result = Integer.MIN_VALUE;
    // for(int i = 1; i<=n; i++){
    //   for(int j = i; j<=n; j++){
    //     if(prefix[j] - prefix[i-1] == 0){
    //       result = Math.max(result, cows.get(j-1).x-cows.get(i-1).x);
    //     }
    //   }
    // }
    for(int i = 1; i<=n; i++){

    }
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("fairphoto.out"));
    out.println(result);
    out.close();
  }
  static class Cow implements Comparable<Cow> {
    char breed;
    int x;

    Cow(int x, String breed) {
      this.x = x;
      this.breed = breed.charAt(0);
    }

    public int compareTo(Cow other) {
      return this.x - other.x;
    }
  }
}