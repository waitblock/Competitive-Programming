import java.util.*;

public class photoshoot {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextLine();
    char[] cows = in.nextLine().toCharArray();
    int result = 0;
    while(true){
      int currentEven = 0;
      for(int i = 0; i<n; i++){
        if((i+1) % 2 == 0){
          if(cows[i] == 'G'){
            currentEven++;
          }
        }
      }
      int even = 0;
      int odd = 0;
      int maxInd = -1;
      int maxVal = Integer.MIN_VALUE;
      for(int i = 0; i<n; i++){
        if(cows[i] == 'G'){
          if((i+1) % 2 == 0){
            even++;
          }
          else{
            odd++;
          }
        }
        if((i+1) % 2 == 0){
          if(Math.abs(even-odd) > maxVal){
            maxVal = Math.abs(even-odd);
            maxInd = i;
          }
        }
      }
      // System.out.println(maxInd);
      char[] temp = new char[maxInd+1];
      int counter = 0;
      for(int i = maxInd; i>=0; i--){
        temp[counter] = cows[i];
        counter++;
      }
      for(int i = 0; i<maxInd; i++){
        cows[i] = temp[i];
      }
      // System.out.println(Arrays.toString(cows));
      int newEven = 0;
      for(int i = 0; i<n; i++){
        if((i+1) % 2 == 0){
          if(cows[i] == 'G'){
            newEven++;
          }
        }
      }
      // System.out.println(currentEven);
      // System.out.println(newEven);
      if(newEven <= currentEven){
        break;
      }
      result++;
    }
    System.out.println(result);
  }
}