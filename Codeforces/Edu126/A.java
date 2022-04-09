import java.util.*;

public final class A {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int testcase=0; testcase<t; testcase++){
    // for(int testcase=0; testcase<1; testcase++){
      int n = in.nextInt();
      int[] a = new int[n];
      int[] b = new int[n];
      for(int i = 0; i<n; i++){
        a[i] = in.nextInt();
      }
      for(int i = 0; i<n; i++){
        b[i] = in.nextInt();
      }
      int prevMin = Integer.MAX_VALUE;
      while(true){
        int[] aTemp = new int[n];
        int[] bTemp = new int[n];
        reset(a, b, aTemp, bTemp);
        // System.out.println(Arrays.toString(aTemp));
        // System.out.println(Arrays.toString(bTemp));
        // System.out.println("===");

        int min = Integer.MAX_VALUE;

        for(int i = 0; i<n; i++){
          // System.out.println(Arrays.toString(aTemp));
          // System.out.println(Arrays.toString(bTemp));
          // System.out.println("===");
          int temp = a[i];
          a[i] = b[i];
          b[i] = temp;
          min = Math.min(min, summation(n, aTemp, bTemp));
          // System.out.println(Arrays.toString(aTemp));
          // System.out.println("===");
          // System.out.println(Arrays.toString(bTemp));
          reset(a,b,aTemp,bTemp);
        }
        // System.out.println(min);
        if(min >= prevMin) break;
        prevMin = min;
      }
      System.out.println(prevMin);
    }
  }

  static int summation(int n, int[] a, int[] b){
    int result = 0;
    for(int i = 0; i<n-1; i++){
      result += Math.abs(a[i]-a[i+1]);
    }
    for(int i = 0; i<n-1; i++){
      result += Math.abs(b[i]-b[i+1]);
    }
    return result;
  }

  static void reset(int[] a, int[] b, int[] aTemp, int[] bTemp){
    for(int i = 0; i<a.length; i++) aTemp[i] = a[i];
    for(int i = 0; i<b.length; i++) bTemp[i] = b[i];
  }
}