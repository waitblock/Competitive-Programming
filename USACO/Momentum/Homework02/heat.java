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

    float result = Float.MIN_VALUE;

    for(int i = 0; i<n-k; i++){
        int sum = 0;
        for(int j = i; j< i+k; j++) sum += temps[j];
        result = Math.max((float) sum/ (float) k, result);
    }
    System.out.println(df.format(result));
    in.close();
  }
}
