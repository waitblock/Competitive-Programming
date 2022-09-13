import java.util.*;
import java.io.*;

public final class oddphoto {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = in.nextInt();
    int even = 0;
    int odd = 0;
    for(int i = 0; i<n; i++){
      if(in.nextInt() % 2 == 0) even++;
      else odd++;
    }
    while(even < odd){
      odd-=2;
      even++;
    }
    if(even > odd + 1){
      even = odd + 1;
    }
    out.println(odd+even);
    in.close();
    out.close();
  }
}
