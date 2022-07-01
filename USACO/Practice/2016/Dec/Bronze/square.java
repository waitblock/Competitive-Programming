import java.util.*;
import java.io.*;

public class square {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("square.in"));
    int[] rect1 = new int[4];
    int[] rect2 = new int[4];

    for(int i = 0; i<4; i++){
      rect1[i] = in.nextInt();
    }
    for(int i = 0; i<4; i++){
      rect2[i] = in.nextInt();
    }
    in.close();
    int[] xpoints = {rect1[0], rect1[2], rect2[0], rect2[2]};
    int[] ypoints = {rect1[1], rect1[3], rect2[1], rect2[3]};
    Arrays.sort(xpoints);
    Arrays.sort(ypoints);
    // int[] corners = {xpoints[0], ypoints[0], xpoints[3], ypoints[3]};
    // System.out.println(Arrays.toString(corners));
    int xside = xpoints[3]-xpoints[0];
    int yside = ypoints[3]-ypoints[0];
    PrintWriter out = new PrintWriter(new File("square.out"));
    int result = (int) Math.pow(Math.max(xside, yside), 2);
    System.out.println(result);
    out.println(result);
    out.close();
  }
}