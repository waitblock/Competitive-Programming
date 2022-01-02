import java.util.*;
import java.io.*;

public class billboard_2 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("billboard.in"));
    int[] lawn = new int[4]; // {bl_x, bl_y, tr_x, tr_y}
    int[] feed = new int[4];
    for(int i = 0; i<4; i++){
      lawn[i] = in.nextInt();
    }
    for(int i = 0; i<4; i++){
      feed[i] = in.nextInt();
    }
    in.close();

    System.out.println(Arrays.toString(lawn));
    System.out.println(Arrays.toString(feed));

    // check for height
    // lawn_tr_y <= feed_tr_y && lawn_bl_y >= feed_tr_y
    // feed_tr_x >= lawn_tr_x || feed_bl_x <= lawn_bl_x
    boolean coverHeight = (lawn[3] <= feed[3] && lawn[1] >= feed[1]) && (feed[2] >= lawn[2] || feed[0] <= lawn[0]);
    System.out.println("covers height: " + String.valueOf(coverHeight));

    // check for width
    // lawn_tr_x <= feed_tr_x && lawn_bl_x >= feed_bl_x
    // feed_tr_y >= lawn_tr_y && feed_bl_y <= lawn_bl_y
    boolean coverWidth = (lawn[2] <= feed[2] && lawn[0] >= feed[0]) && (feed[3] >= lawn[3] || feed[1] <= lawn[1]);
    System.out.println("covers width: " + String.valueOf(coverWidth));

    PrintWriter out = new PrintWriter(new File("billboard.out"));

    int result = (lawn[3]-lawn[1]) * (lawn[2]-lawn[0]);

    // in this case the answer is the area of the mower board
    if(!coverHeight && !coverWidth){

    }

    // in this case the answer is the remaining height to be covered
    else if(!coverHeight && coverWidth){
      result -= interArea(lawn, feed);
    }

    else if(coverHeight && !coverWidth){
      result -= interArea(lawn, feed);
    }

    else if(coverHeight && coverWidth){
      result = 0;
    }

    System.out.println(result);
    out.println(result);
    out.close();
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

/*
note: width is left to right, and height is up and down

the cow feed billboard needs to either cover the entire width or the entire height of the lawnmower billboard
in order for the tarp to not be as big as the entire lawnmower billboard

if the cow feed billboard is as wide or bigger than the lawnmower billboard but does not cover the lawnmower billboard from
top to bottom, then the tarp just needs to cover the height of the billboard that is not covered

vice versa for height

case 4 fix (corner case):
the feed board must cover from the top to somewhere in the middle (or vice versa from the bottom),
not from somewhere in the middle to somewhere in the middle in the case of the width being covered

same thing but vice versa in the case of the height being covered

implementation: add an or statement checking whether or not the feed board
extends from the top or the bottom when covering the entire width

again, vice versa in the case of the height being covered
*/

/*
tr-top right
br-bottom right
tl-top left
bl-bottom left
*/