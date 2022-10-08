import java.util.*;
import java.io.*;

public final class angry {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("angry.in"));
    int n = in.nextInt();
    int k = in.nextInt();
    int[] hay = new int[n];
    for(int i = 0; i<n; i++){
      hay[i] = in.nextInt();
    }
    in.close();
    Arrays.sort(hay);
    int l = 0;
    int r = 500000000;
    while(true){
      if(l == r) break;
      int m = (l+r)/2;
      int count = 0;
      int last = 0;
      while(true){
        if(last >= n) break;
        count++;
        int temp = last+1;
        while(n > temp && m*2 >= hay[temp] - hay[last]) {
					temp++;
				}
        last = temp;
      }
      if(count > k){
        l = m+1;
      }
      else{
        r = m;
      }
    }
    PrintWriter out = new PrintWriter(new File("angry.out"));
    out.println(l);
    out.close();
  }
}