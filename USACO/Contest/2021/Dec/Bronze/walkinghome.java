import java.util.*;

public class walkinghome {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int a = 0; a<t; a++){
      int n = in.nextInt();
      int turns = in.nextInt();
      boolean[][] farm = new boolean[n][n];
      for(int r = 0; r<n; r++){
        char[] row = in.next().toCharArray();
        for(int c = 0; c<n; c++){
          if(row[c] == '.'){
            farm[r][c] = true; // unblocked
          }
          if(row[c] == 'H'){
            farm[r][c] = false; // blocked
          }
        }
      }
      int result = 0;
      if(turns >= 1){
        result += 2;
        for(int i = 0; i<n; i++){
          if(!farm[i][n-1]){
            result--;
          }
        }
        for(int i = 0; i<n; i++){
          if(!farm[0][i]){
            result--;
          }
        }
      }
      if(turns >= 2){
        for(int i = 0; i<n-1; i++){
          boolean valid1 = true;
          boolean valid2 = true;
          for(int j = 0; j<=i; j++){
            valid1 = farm[0][j];
            valid2 = farm[j][0];
          }
          for(int j = 0; j<n; j++){
            valid1 = farm[j][i];
            valid2 = farm[i][j];
          }
          for(int j = i; j<n; j++){
            valid1 = farm[n-1][j];
            valid2 = farm[j][n-1];
          }
          if(valid1){
            result++;
          }
          if(valid2){
            result++;
          }
        }
      }
      if(turns == 3){
        for(int i = 0; i<n-1; i++){
          for(int j = 1; j<n-1; j++){
            boolean valid1 = true;
            boolean valid2 = true;
            for(int k = 0; k<i; k++){
              valid1 = farm[0][k];
              valid2 = farm[k][0];
            }
            for(int k = 0; k<j; k++){
              valid1 = farm[k][i];
              valid2 = farm[i][k];
            }
            for(int k = i; k<n; k++){
              valid1 = farm[j][k];
              valid2 = farm[k][j];
            }
            for(int k = j; k<n; k++){
              valid1 = farm[n-1][k];
              valid2 = farm[k][n-1];
            }
            if(valid1){
              result++;
            }
            if(valid2){
              result++;
            }
          }
        }
      }
      System.out.println(result);
    }
  }
}