import java.util.*;
import java.io.*;

public final class shuffle_v2 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("shuffle.in"));
    int n = in.nextInt();
    int[] target = new int[n];
    int[] count = new int[n];
    for(int i = 0; i<n; i++){
      target[i] = in.nextInt()-1;
      count[target[i]]++;
    }
    in.close();
    int result = n;
    Stack<Integer> empty = new Stack<>();
    for(int i = 0; i<n; i++){
      if(count[i] == 0){
        result--;
        empty.add(i);
      }
    }
    while(!empty.isEmpty()){
      int temp = empty.pop();
      count[target[temp]]--;
      if(count[target[temp]] == 0){
        result--;
        empty.add(target[temp]);
      }
    }
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("shuffle.out"));
    out.println(result);
    out.close();
  }
}
