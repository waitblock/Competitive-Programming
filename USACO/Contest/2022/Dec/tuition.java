import java.util.*;
import java.io.*;

public final class tuition {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    long[] maxT = new long[n];
    for(int i = 0; i<n; i++){
      maxT[i] = in.nextLong();
    }
    in.close();
    Arrays.sort(maxT);
    long count = (long) n;
    long result = maxT[0];
    long max = maxT[0]*count;
    for(int i = 1; i<n; i++){
      count--;
      long curTuition = count * maxT[i];
      if(curTuition > max){
        result = maxT[i];
        max = curTuition;
      }
    }
    System.out.print(max);
    System.out.print(" ");
    System.out.println(result);
  }
}