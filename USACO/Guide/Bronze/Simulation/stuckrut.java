import java.util.*;
import java.io.*;

public final class stuckrut {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    ArrayList<int[]> north = new ArrayList<>();
    ArrayList<int[]> east = new ArrayList<>();
    for(int i = 0; i<n; i++){
      if(in.next().equals("N")){
        north.add(new int[]{in.nextInt(), in.nextInt()});
      }
      else{
        east.add(new int[]{in.nextInt(), in.nextInt()});
      }
    }
    in.close();
    for(int[] a : north){
      System.out.println(Arrays.toString(a));
    }
  }
}
