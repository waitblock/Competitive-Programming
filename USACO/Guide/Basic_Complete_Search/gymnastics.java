import java.util.*;
import java.io.*;

public class gymnastics{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("gymnastics.in"));
    int k = in.nextInt();
    int n = in.nextInt();

    int[][] sessions = new int[k][n];
    for(int i = 0; i<k; i++){
      for(int j = 0; j<n; j++){
        sessions[i][j] = in.nextInt()-1;
      }
    }

    for(int[] arr : sessions){
      System.out.println(Arrays.toString(arr));
    }

    int result = 0;

    for(int i = 0; i<n; i++){
      for(int j = i+1; j<n; j++){
        boolean valid = true;
        if(getInd(sessions[0], i) > getInd(sessions[0], j)){
          for(int a = 0; a<k; a++){
            if(getInd(sessions[a],i) < getInd(sessions[a], j)){
              valid = false;
            }
          }
        }
        else{
          for(int a = 0; a<k; a++){
            if(getInd(sessions[a],i) > getInd(sessions[a], j)){
              valid = false;
            }
          }
        }
        if(valid){
          result++;
          // System.out.println(i+1);
          // System.out.println(j+1);
          // System.out.println("-");
        }
      }
    }

    System.out.println(result);

    PrintWriter out = new PrintWriter(new File("gymnastics.out"));
    out.println(result);
    out.close();
  }

  static int getInd(int[] arr, int k){
    for(int i = 0; i<arr.length; i++){
      if(arr[i] == k){
        return i;
      }
    }
    return -1;
  }
}