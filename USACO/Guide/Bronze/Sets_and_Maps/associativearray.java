import java.util.*;
import java.io.*;

public final class associativearray {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long n = in.nextLong();
    HashMap<Long, Long> store = new HashMap<>();
    PrintWriter out = new PrintWriter(System.out);
    for(long i = 0; i<n; i++){
      long temp = in.nextLong();
      if(temp == 0){
        long ind = in.nextLong();
        long value = in.nextLong();
        store.put(ind, value);
      }
      else if(temp == 1){
        long ind = in.nextLong();
        if(store.get(ind) == null){
          out.println(0);
        }
        else{
          out.println(store.get(ind));
        }
      }
    }
    in.close();
    out.close();
  }
}
