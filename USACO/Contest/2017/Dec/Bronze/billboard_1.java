import java.util.*;
import java.io.*;

class billboard_1 {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("billboard.in"));
    int[] b1 = new int[4];
    for(int i = 0; i<4; i++){
      b1[i] = in.nextInt();
    }
    int[] b2 = new int[4];
    for(int i = 0; i<4; i++){
      b2[i] = in.nextInt();
    }
    int[] truck = new int[4];
    for(int i = 0; i<4; i++){
      truck[i] = in.nextInt();
    }

    in.close();
    // System.out.println(Arrays.toString(b1));
    // System.out.println(Arrays.toString(b2));
    // System.out.println(Arrays.toString(truck));
    System.out.println("intersecting area of b1 and truck");
    System.out.println(interArea(b1, truck));
    System.out.println("intersecting area of b2 and truck");
    System.out.println(interArea(b2, truck));
    // System.out.println(interArea(b1, b2));
    System.out.println("area of b1");
    System.out.println(totalArea(b1));
    System.out.println("area of b2");
    System.out.println(totalArea(b2));
    // int result = (totalArea(b1) - interArea(b1, truck)) + (totalArea(b2) - interArea(b2, truck));
    int result = 0;
    if(interArea(b1, truck) > 0){
      result += (totalArea(b1) - interArea(b1, truck));
    }
    if(interArea(b2, truck) > 0){
      result += (totalArea(b2) - interArea(b2, truck));
    }
    if(result < 0){
      result = totalArea(b1) + totalArea(b2);
    }
    PrintWriter out = new PrintWriter(new File("billboard.out"));
    out.println(result);
    System.out.println("result");
    System.out.println(result);
    out.close();
  }

  static int interArea(int[] s1, int[] s2) {
  	int bl_a_x = s1[0], bl_a_y = s1[1], tr_a_x = s1[2], tr_a_y = s1[3];
  	int bl_b_x = s2[0], bl_b_y = s2[1], tr_b_x = s2[2], tr_b_y = s2[3];

  	return (Math.min(tr_a_x, tr_b_x) - Math.max(bl_a_x, bl_b_x))
  		* (Math.min(tr_a_y, tr_b_y) - Math.max(bl_a_y, bl_b_y));
  }

  static int totalArea(int[] coords){
    int bl_x = coords[0];
    int bl_y = coords[1];
    int tr_x = coords[2];
    int tr_y = coords[3];
    return (tr_y-bl_y) * (tr_x-bl_x);
  }
}
