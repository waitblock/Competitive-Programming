import java.util.*;
import java.io.*;

public final class skyline {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("skyline.in"));
    int n = in.nextInt();
    int b = in.nextInt();
    int[] heights = new int[n];
    for(int i = 0; i<n; i++){
      heights[i] = in.nextInt();
    }
    in.close();
    int[] avg = new int[n-b+1];
    int sum = 0;
    for(int i = 0; i<b; i++){
      sum += heights[i];
    }
    for(int i = 0; i<n-b; i++){
      avg[i] = sum/b;
      sum -= heights[i];
      sum += heights[i+b];
    }
    avg[n-b] = sum/b;
    // System.out.println(Arrays.toString(avg));
    int max = Integer.MIN_VALUE;
    int maxInd = -1;
    for(int i = 0; i<=n-b; i++){
      if(avg[i] > max){
        max = avg[i];
        maxInd = i;
      }
    }
    // System.out.println(maxInd+1);
    // System.out.println(maxInd+b);
    // System.out.print(((maxInd+1)+(maxInd+b))/2);
    System.out.print((2*maxInd+b+1)/2);
    System.out.print(" ");
    System.out.println(avg[maxInd]);
    PrintWriter out = new PrintWriter(new File("skyline.out"));
    out.print((2*maxInd+b+1)/2);
    out.print(" ");
    out.println(avg[maxInd]);
    out.close();
  }
}