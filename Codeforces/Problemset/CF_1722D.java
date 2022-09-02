// Time complexity: O(tn^2)
// tle case 3

import java.util.*;
import java.io.*;

public final class CF_1722D {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  public static void main(String[] args) {
    int t = in.nextInt();
    for(int i = 0; i<t; i++){
      solve();
    }
    in.close();
    out.close();
  }
  static int value(char[] line, int n){
    int result = 0;
    for(int i = 0; i<n; i++){
      result += (line[i] == 'L' ? i : n-i-1);
    }
    return result;
  }
  static void solve(){
    int n = in.nextInt();
    char[] line = in.next().toCharArray();
    if(n % 2 == 0){
      for(int k = 1; k<=n; k++){
        boolean lChanged = false;
        for(int i = 0; i<=n/2-1; i++){
          if(line[i] == 'L'){
            line[i] = 'R';
            lChanged = true;
          }
          int lValue = value(line, n);
          if(lChanged) line[i] = 'L';
          boolean rChanged = false;
          if(line[n-1-i] == 'R'){
            line[n-1-i] = 'L';
            rChanged = true;
          }
          int rValue = value(line, n);
          if(rChanged) line[n-1-i] = 'R';
          if(!lChanged && !rChanged) continue;
          if(lChanged && !rChanged) line[i] = 'R';
          if(!lChanged && rChanged) line[n-1-i] = 'L';
          if(lChanged && rChanged){
            if(lValue > rValue){
              line[i] = 'R';
            }
            else{
              line[n-1-i] = 'L';
            }
          }
          if(lChanged || rChanged) break;
        }
        int result = value(line, n);
        out.print(result);
        out.print(" ");
      }
    }
    else{
      for(int k = 1; k<=n; k++){
        boolean lChanged = false;
        for(int i = 0; i<=n/2; i++){
          if(line[i] == 'L'){
            line[i] = 'R';
            lChanged = true;
          }
          int lValue = value(line, n);
          if(lChanged) line[i] = 'L';
          boolean rChanged = false;
          if(line[n-1-i] == 'R'){
            line[n-1-i] = 'L';
            rChanged = true;
          }
          int rValue = value(line, n);
          if(rChanged) line[n-1-i] = 'R';
          if(!lChanged && !rChanged) continue;
          if(lChanged && !rChanged) line[i] = 'R';
          if(!lChanged && rChanged) line[n-1-i] = 'L';
          if(lChanged && rChanged){
            if(lValue > rValue){
              line[i] = 'R';
            }
            else{
              line[n-1-i] = 'L';
            }
          }
          if(lChanged || rChanged) break;
        }
        int result = value(line, n);
        out.print(result);
        out.print(" ");
      }
    }
    out.print("\n");
  }
}