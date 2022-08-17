import java.util.*;

public class oddphotos {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] cowId = new int[n];
    for(int i = 0; i<n; i++){
      cowId[i] = in.nextInt();
    }
    int evenRemaining = 0;
    for(int i = 0; i<n; i++){
      if(cowId[i] % 2 == 0){
        evenRemaining++;
      }
    }
    int oddRemaining = n-evenRemaining;

    while(oddRemaining > evenRemaining) {
      oddRemaining -= 2;
      evenRemaining++;
    }
    if(evenRemaining > oddRemaining+1){
      System.out.println(2*oddRemaining+1);
    }
    else{
      System.out.println(evenRemaining+oddRemaining);
    }
  }
}