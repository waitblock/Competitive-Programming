import java.util.*;
import java.io.*;

public class traffic{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("traffic.in"));
    int n = in.nextInt();
    String[] sensor = new String[n]; // Type of sensor
    int[] lower = new int[n]; // Lower bound of sensor output range
    int[] upper = new int[n]; // Upper bound of sensor output range
    int low = -1001; // lowest possible value for range of values before 1
    int high = 1001; // highest possible value for range of values before 1
    for(int i = 0; i<n; i++){
      sensor[i] = in.next();
      lower[i] = in.nextInt();
      upper[i] = in.nextInt();
    }
    System.out.println(Arrays.toString(lower));
    System.out.println(Arrays.toString(upper));
    in.close();
    PrintWriter out = new PrintWriter(new File("traffic.out"));
    for(int i = n-1; i>=0; i--){
      if(sensor[i].equals("on")){
        low -= upper[i];
        high -= lower[i];
        low = Math.max(0,low);
      }
      if(sensor[i].equals("off")){
        low += lower[i];
        high += upper[i];
      }
      if(sensor[i].equals("none")){
        low = Math.max(low, lower[i]);
        high = Math.min(high, upper[i]);
      }
    }
    out.println(String.valueOf(low)+" "+String.valueOf(high));
    System.out.println(String.valueOf(low)+" "+String.valueOf(high));
    //reset
    low = -1001;
    high = 1001;
    for(int i = 0; i<n; i++){
      if(sensor[i].equals("on")){
        low += lower[i];
        high += upper[i];
      }
      if(sensor[i].equals("off")){
        low -= upper[i];
        high -= lower[i];
        low = Math.max(0,low);
      }
      if(sensor[i].equals("none")){
        low = Math.max(low, lower[i]);
        high = Math.min(high, upper[i]);
      }
    }
    out.println(String.valueOf(low)+" "+String.valueOf(high));
    System.out.println(String.valueOf(low)+" "+String.valueOf(high));
    out.close();
  }
}