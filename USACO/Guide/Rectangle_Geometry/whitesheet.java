// TODO: Figure out why I'm getting wrong answers

import java.util.*;

public class whitesheet {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int[] white = new int[4];
    int[] black1 = new int[4];
    int[] black2 = new int[4];
    for(int i = 0; i<4; i++){
      white[i] = in.nextInt();
    }
    for(int i = 0; i<4; i++){
      black1[i] = in.nextInt();
    }
    for(int i = 0; i<4; i++){
      black2[i] = in.nextInt();
    }
    // System.out.println(Arrays.toString(white));
    // System.out.println(Arrays.toString(black1));
    // System.out.println(Arrays.toString(black2));

    int white_area = area(white);
    int inter_black1 = interArea(black1, white);
    int inter_black2 = interArea(black2, white);
    // System.out.println(inter_black1);
    // System.out.println(inter_black2);

    if((inter_black1 + inter_black2) >= white_area){
      System.out.println("NO");
    }
    else{
      System.out.println("YES");
    }
  }

  static int area(int[] rect){
    int bl_x = rect[0];
    int bl_y = rect[1];
    int tr_x = rect[2];
    int tr_y = rect[3];

    return (tr_x-bl_x)*(tr_y-bl_y);
  }

  static int interArea(int[] s1, int[] s2) {
  	int bl_a_x = s1[0], bl_a_y = s1[1], tr_a_x = s1[2], tr_a_y = s1[3];
  	int bl_b_x = s2[0], bl_b_y = s2[1], tr_b_x = s2[2], tr_b_y = s2[3];
  	return (
  		(Math.min(tr_a_x, tr_b_x) - Math.max(bl_a_x, bl_b_x))
  		* (Math.min(tr_a_y, tr_b_y) - Math.max(bl_a_y, bl_b_y))
  	);
  }
}