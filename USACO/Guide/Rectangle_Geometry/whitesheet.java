// TODO: Wrong answer on case 11

import java.util.*;

public class whitesheet {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    long[] white = new long[4];
    long[] black1 = new long[4];
    long[] black2 = new long[4];
    for(int i = 0; i<4; i++){
      white[i] = in.nextLong();
    }
    for(int i = 0; i<4; i++){
      black1[i] = in.nextLong();
    }
    for(int i = 0; i<4; i++){
      black2[i] = in.nextLong();
    }
    // System.out.println(Arrays.toString(white));
    // System.out.println(Arrays.toString(black1));
    // System.out.println(Arrays.toString(black2));

    long white_area = area(white);
    long inter_black1 = interArea(black1, white);
    long inter_black2 = interArea(black2, white);
    long black_area = interArea(black1, black2);

    System.out.println(white_area);
    System.out.println(inter_black1);
    System.out.println(inter_black2);
    System.out.println(black_area);

    long area = white_area - (inter_black1 + inter_black2 - black_area);

    System.out.println(area);

    if(area > 0L){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
    }
  }

  static long area(long[] rect){
    long bl_x = rect[0];
    long bl_y = rect[1];
    long tr_x = rect[2];
    long tr_y = rect[3];

    return (long) (tr_x-bl_x)*(tr_y-bl_y);
  }

  static boolean intersect(long[] s1, long[] s2) {
    long bl_a_x = s1[0], bl_a_y = s1[1], tr_a_x = s1[2], tr_a_y = s1[3];
  	long bl_b_x = s2[0], bl_b_y = s2[1], tr_b_x = s2[2], tr_b_y = s2[3];

  	// no overlap
  	if (bl_a_x >= tr_b_x || tr_a_x <= bl_b_x
  			|| bl_a_y >= tr_b_y || tr_a_y <= bl_b_y) {
  		return false;
  	} else {
  		return true;
  	}
  }

  static long interArea(long[] s1, long[] s2) {
    if(!intersect(s1, s2)) return 0;
  	long bl_a_x = s1[0], bl_a_y = s1[1], tr_a_x = s1[2], tr_a_y = s1[3];
  	long bl_b_x = s2[0], bl_b_y = s2[1], tr_b_x = s2[2], tr_b_y = s2[3];
  	return (long) (
  		(Math.min(tr_a_x, tr_b_x) - Math.max(bl_a_x, bl_b_x))
  		* (Math.min(tr_a_y, tr_b_y) - Math.max(bl_a_y, bl_b_y))
  	);
  }
}