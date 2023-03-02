import java.util.*;
import java.io.*;

public class square {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("square.in"));
    int[] pasture1 = new int[4]; // bl_x, bl_y, ur_x, ur_y
    int[] pasture2 = new int[4];
    for(int i = 0; i<4; i++){
      pasture1[i] = in.nextInt();
    }
    for(int i = 0; i<4; i++){
      pasture2[i] = in.nextInt();
    }
    in.close();
    int bl_x = Math.min(pasture1[0], pasture2[0]);
    // System.out.println(bl_x);
    int bl_y = Math.min(pasture1[1], pasture2[1]);
    // System.out.println(bl_y);
    int ur_x = Math.max(pasture1[2], pasture2[2]);
    // System.out.println(ur_x);
    int ur_y = Math.max(pasture1[3], pasture2[3]);
    // System.out.println(ur_y);
    int side = Math.max((ur_y-bl_y), (ur_x-bl_x));
    // System.out.println(side);
    int result = (int) Math.pow(side, 2);
    // System.out.println(result);
    PrintWriter out = new PrintWriter(new File("square.out"));
    out.println(result);
    out.close();
  }
}
