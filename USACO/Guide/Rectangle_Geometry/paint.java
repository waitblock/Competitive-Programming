import java.util.*;
import java.io.*;

public class paint {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("paint.in"));
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    int d = in.nextInt();
    in.close();
    int[] fence = new int[101];
    for(int i = a; i<b; i++){
      fence[i] = 1;
    }
    for(int i = c; i<d; i++){
      fence[i] = 1;
    }
    int result = 0;
    for(int i : fence){
      if(i == 1){
        result++;
      }
    }
    PrintWriter out = new PrintWriter(new File("paint.out"));
    out.println(result);
    System.out.println(result);
    out.close();
  }
}