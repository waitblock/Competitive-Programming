import java.util.*;
import java.io.*;

public final class breedflip {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("breedflip.in"));
    PrintWriter out = new PrintWriter(new File("breedflip.out"));
    int n = in.nextInt();
    char[] cows = in.next().toCharArray();
    char[] target = in.next().toCharArray();
    in.close();
    int result = 0;
    while(true){
      boolean valid = true;
      for(int i = 0; i<n; i++){
        if(cows[i] != target[i]){
          valid = false;
          break;
        }
      }

      int start = 0;
      int maxStart = 0; int maxEnd = 0;
      int length = 0; int maxLength = 0;
      boolean inChain = false;
      if(valid) break;
      for(int i = 0; i<n-1; i++){
        if(cows[i] != target[i]){
          if(inChain){
            length++;
          }
          if(!inChain){
            inChain = true;
            length++;
            start = i;
          }
        }
        if(cows[i] == target[i]){
          if(inChain){
            inChain = false;
            if(length > maxLength){
              maxStart = start;
              maxEnd = i;
            }
          }
        }
      }
      if(inChain){
        if(cows[n-1] != target[n-1]){
          length++;
          if(length > maxLength){
            maxStart = start;
            maxEnd = n;
          }
        }
        else{
          if(length > maxLength){
            maxStart = start;
            maxEnd = n-1;
          }
        }
      }
      if(!inChain && cows[n-1] != target[n-1]){
        if(1 > maxLength){
          maxStart = n-1;
          maxEnd = n;
        }
      }
      for(int i = maxStart; i<maxEnd; i++){
        cows[i] = cows[i] == 'G' ? 'H' : 'G';
      }
      // System.out.println(Arrays.toString(cows));
      result++;
    }
    System.out.println(result);
    out.println(result);
    out.close();
  }
}
