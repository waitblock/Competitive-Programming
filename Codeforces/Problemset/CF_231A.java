import java.util.*;

public class CF_231A {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int result = 0;
    for(int i = 0; i<n; i++){
      int count = 0;
      for(int j = 0; j<3; j++){
        if(in.nextInt() == 1){
          count++;
        }
      }
      if(count >= 2){
        result++;
      }
    }
    System.out.println(result);
  }
}
