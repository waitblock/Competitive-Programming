import java.util.*;

public final class D {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    char[] str2 = in.next().toCharArray();
    in.close();
    int[] str = new int[str2.length];
    for(int i = 0; i<str.length; i++){
      int ascii = str2[i];
      str[i] = ascii-96;
    }
    int sum = 0;
    for(int i = 0; i<str.length; i++) sum += (str[i]-1);

    int[] arr = new int[str.length];
    for(int i = 0; i<arr.length; i++) arr[i] = 1;

    for(int i = arr.length-1; i>=0; i--){
      arr[i] += Math.min(25, sum);
      sum -= (arr[i]-1);
    }

    for(int i = 0; i<str.length; i++){
      System.out.print((char) (arr[i] + 96));
    }
    System.out.print("\n");
  }
}