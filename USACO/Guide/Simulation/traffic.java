// incomplete

import java.util.*;
import java.io.*;

public class traffic{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("traffic.in"));
    int n = in.nextInt();
    String[] type = new String[n];
    int[] lower = new int[n];
    int[] upper = new int[n];
    for(int i = 0; i<n; i++){
      type[i] = in.next();
      lower[i] = in.nextInt();
      upper[i] = in.nextInt();
    }
    // System.out.println(Arrays.toString(type));
    // System.out.println(Arrays.toString(lower));
    // System.out.println(Arrays.toString(upper));
    int[] before_1 = new int[2];
    int[] after_n = new int[2];
    int min_on = 0;
    int min_off = 0;
    int max_on = 0;
    int max_off = 0;
    if(type[0].equals("none")){
      before_1 = new int[]{lower[0], upper[0]};
    }
    else{
      for(int i = 0; i<n; i++){
        String type2 = type[i];
        if(type2.equals("none")){
          break;
        }
        int lower2 = lower[i];
        int upper2 = upper[i];
        if(type2.equals("off")){
          min_off += lower2;
          max_off += upper2;
        }
        else if(type2.equals("on")){
          min_on += lower2;
          max_on += upper2;
        }
      }
    }
    System.out.println("Min on:" + String.valueOf(min_on));
    System.out.println("Min off:" + String.valueOf(min_off));
    System.out.println("Max on:" + String.valueOf(max_on));
    System.out.println("Max off:" + String.valueOf(max_off));
  }
}