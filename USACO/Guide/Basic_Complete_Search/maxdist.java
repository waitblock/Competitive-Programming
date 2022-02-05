import java.util.*;

public class maxdist{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    for(int i = 0; i<n; i++){
      x[i] = in.nextInt();
    }

    for(int i = 0; i<n; i++){
      y[i] = in.nextInt();
    }

    int result = Integer.MIN_VALUE;

    for(int i = 0; i<n; i++){
      for(int j = 0; j<n; j++){
        int x_dist = Math.abs(x[i]-x[j]);
        int y_dist = Math.abs(y[i]-y[j]);
        int dist = (int) Math.pow(x_dist,2) + (int) Math.pow(y_dist,2);
        if(dist > result) result = dist;
      }
    }

    System.out.println(result);
  }
}