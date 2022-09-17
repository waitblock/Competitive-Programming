import java.util.*;
import java.io.*;

public final class shuffle {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("shuffle.in"));
    int n = in.nextInt();
    int[] target = new int[n];
    for(int i = 0; i<n; i++){
      target[i] = in.nextInt();
    }
    in.close();
    int[] count = new int[n];
    for(int i = 0; i<n; i++) count[i]++;
    ArrayList<int[]> cycle = new ArrayList<>();
    int result = n;
    mainLoop:
    while(true){
      for(int[] i : cycle){
        if(Arrays.equals(count, i)) break mainLoop;
      }
      int[] temp = new int[n];
      for(int i = 0; i<n; i++){
        temp[target[i]-1] += count[i];
      }
      for(int i = 0; i<n; i++){
        if(temp[i] == 0){
          result--;
          temp[target[i]-1]--;
        }
      }
      System.out.println(Arrays.toString(temp));
      for(int i = 0; i<n; i++){
        count[i] = temp[i];
      }
      cycle.add(count);
    }
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("shuffle.out"));
    out.println(result);
    out.close();
  }
}
