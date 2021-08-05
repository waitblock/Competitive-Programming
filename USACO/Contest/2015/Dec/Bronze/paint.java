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

    boolean[] fence = new boolean[101];
    Arrays.fill(fence, false);

    for(int i = a; i<b; i++){
      fence[i] = true;
    }

    for(int i = c; i<d; i++){
      fence[i] = true;
    }

    int result = 0;

    for(int i = 0; i<101; i++){
      if(fence[i]){
        result++;
      }
    }
    PrintWriter out = new PrintWriter(new File("paint.out"));
    out.println(result);
    out.close();
  }
}
