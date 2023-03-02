import java.util.*;

public final class twotables {
  static Scanner in = new Scanner(System.in);
  public static void main(String[] args) {
    int t = in.nextInt();
    for(int i = 0; i<t; i++){
      solve();
    }
    in.close();
  }

  static void solve(){
    int W = in.nextInt();
    int H = in.nextInt();
    int x1 = in.nextInt();
    int y1 = in.nextInt();
    int x2 = in.nextInt();
    int y2 = in.nextInt();
    int w = in.nextInt();
    int h = in.nextInt();
    int left = w;
    int right = W-w;
    int top = H-h;
    int bottom = h;
    int rLeft = Math.max(left - x1,0);
    int rRight = Math.max(x2-right, 0);
    int rTop = Math.max(y2-top, 0);
    int rBottom = Math.max(bottom-y1, 0);
    if((x2-x1) + w > W){
      rLeft = Integer.MAX_VALUE;
      rRight = Integer.MAX_VALUE;
    }
    if((y2-y1) + h > H){
      rTop = Integer.MAX_VALUE;
      rBottom = Integer.MAX_VALUE;
    }
    int result = Integer.MAX_VALUE;
    result = Math.min(rLeft, result);
    result = Math.min(rRight, result);
    result = Math.min(rTop, result);
    result = Math.min(rBottom, result);
    if(result == Integer.MAX_VALUE) result = -1;
    System.out.println(result);
  }
}