import java.util.*;
import java.io.*;
import java.awt.Rectangle;

public class billboard {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("billboard.in"));
    int[] bill1 = new int[4];
    int[] bill2 = new int[4];
    int[] truck = new int[4];
    for(int i = 0; i<4; i++){
      bill1[i] = in.nextInt();
    }
    for(int i = 0; i<4; i++){
      bill2[i] = in.nextInt();
    }
    for(int i = 0; i<4; i++){
      truck[i] = in.nextInt();
    }
    in.close();
    int remaining1 = area(bill1)-interArea(bill1, truck);
    int remaining2 = area(bill2)-interArea(bill2, truck);
    // System.out.println(remaining1);
    // System.out.println(remaining2);
    // System.out.println(interArea(bill1, truck));
    int result = 0;
    if(interArea(bill1,truck)>0){
      result+=remaining1;
    }
    if(interArea(bill1,truck)<0){
      result+=area(bill1);
    }
    if(interArea(bill2,truck)>0){
      result+=remaining2;
    }
    if(interArea(bill2,truck)<0){
      result+=area(bill2);
    }
    // System.out.println(result);
    PrintWriter out = new PrintWriter(new File("billboard.out"));
    out.println(result);
    out.close();
  }

  static int interArea(int[] s1, int[] s2) {
	int bl_a_x = s1[0], bl_a_y = s1[1], tr_a_x = s1[2], tr_a_y = s1[3];
	int bl_b_x = s2[0], bl_b_y = s2[1], tr_b_x = s2[2], tr_b_y = s2[3];
  int width = Math.min(tr_a_x, tr_b_x) - Math.max(bl_a_x, bl_b_x);
  int height = Math.min(tr_a_y, tr_b_y) - Math.max(bl_a_y, bl_b_y);
  if(width<0||height<0){
    return -1;
  }
	return width*height;
}

  static int area(int[] rect){
    int width = rect[2]-rect[0];
    int height = rect[3]-rect[1];
    return width*height;
  }
}

/*
First, we'll find this rectangle's length and width.

$\texttt{width} = \min(\texttt{tr}_{a_x}, \texttt{tr}_{b_x}) - \max(\texttt{bl}_{a_x}, \texttt{bl}_{b_x})$
.

$\texttt{length} = \min(\texttt{tr}_{a_y}, \texttt{tr}_{b_y}) - \max(\texttt{bl}_{a_y}, \texttt{bl}_{b_y})$
.
*/