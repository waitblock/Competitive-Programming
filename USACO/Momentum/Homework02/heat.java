import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public final class heat {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.print("Enter directory: ");
    String dir = in.next();
    while(true){
      System.out.print("Enter filename: ");
      String f = in.next();
      try{
        solve(dir+"/"+f);
      }
      catch(Exception e){
        e.printStackTrace(System.err);
      }
    }
  }
  static void solve(String filename) throws FileNotFoundException {
    DecimalFormat df = new DecimalFormat("#.######");
    df.setRoundingMode(RoundingMode.FLOOR);
    Scanner in = new Scanner(new File(filename));
    int n = in.nextInt();
    int k = in.nextInt();

    int[] temps = new int[n];
    for(int i = 0; i<n; i++){
        temps[i] = in.nextInt();
    }
    // System.out.println(Arrays.toString(temps));

    double result = Double.MIN_VALUE;

    for(int i = 0; i<n; i++){
        int sum = 0;
        int inc = 0;
        for(int j = i; j<n; j++){
          sum += temps[j];
          inc++;
          if(inc >= k){
            result = Math.max(((double) sum / (double) inc), result);
          }
        }
    }
    // System.out.println(result);
    System.out.println(df.format(result));
    in.close();
  }
}
