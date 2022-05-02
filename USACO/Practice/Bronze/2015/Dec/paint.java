import java.util.*;
import java.io.*;

public class paint {
  public static void main(String[] args) throws FileNotFoundException {
    boolean[] fence = new boolean[101];
    Scanner in = new Scanner(new File("paint.in"));
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    int d = in.nextInt();
    for(int i = a; i<b; i++) fence[i] = true;
    for(int i = c; i<d; i++) fence[i] = true;
    in.close();
    int result = 0;
    for(int i = 0; i<101; i++) if(fence[i]) result++;
    PrintWriter out = new PrintWriter(new File("paint.out"));
    out.println(result);
    System.out.println(result);
    out.close();
  }
}