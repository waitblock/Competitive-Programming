import java.util.*;

public final class E {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    char[] m2 = Integer.toBinaryString(m).toCharArray();

    int result = 0;
    for(int x = 1; x<=Math.pow(2,n)-1; x++){
      for(int y = 1; y<=Math.pow(2,n)-1; y++){
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(y));

        char[] x2 = Integer.toBinaryString(x).toCharArray();
        char[] y2 = Integer.toBinaryString(y).toCharArray();

        int firstDiffX = -1;
        for(int i = 0; i<((x2.length <= m2.length) ? x2.length : m2.length); i++){
          if(x2[i] != m2[i]){
            firstDiffX = i;
            break;
          }
        }

        int firstDiffY = -1;
        for(int i = 0; i<((y2.length <= m2.length) ? y2.length : m2.length); i++){
          if(y2[i] != m2[i]){
            firstDiffY = i;
            break;
          }
        }

        int diffCharsX = x2.length-firstDiffX;
        int diffCharsY = y2.length-firstDiffY;

        int xOp = diffCharsX*2 + (Math.abs(m2.length-x2.length));
        int yOp = diffCharsY*2 + (Math.abs(m2.length-y2.length));

        System.out.println(xOp);
        System.out.println(yOp);
        System.out.println("---");

        result += xOp;
        result += yOp;
      }
    }
    System.out.println(result);
  }
}