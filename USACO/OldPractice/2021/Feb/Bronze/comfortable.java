// TODO: tle on cases 7-12

import java.util.*;

public class comfortable {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    boolean[][] cows = new boolean[1001][1001];
    ArrayList<int[]> toAdd = new ArrayList<>();
    ArrayList<int[]> added = new ArrayList<>();

    for(int i = 0; i<n; i++){
      int x = in.nextInt();
      int y = in.nextInt();
      int[] temp = {x, y};
      toAdd.add(temp);
    }
    in.close();
    for(int i = 0; i<toAdd.size(); i++){
      int[] newCow = toAdd.get(i);
      int newX = newCow[0];
      int newY = newCow[1];
      cows[newX][newY] = true;
      added.add(newCow);
      System.out.println(count_comfort(cows, added));
    }
  }
  static int count_comfort(boolean[][] cows, ArrayList<int[]> added){
    int result = 0;
    for(int i = 0; i<added.size(); i++){
      int[] temp = added.get(i);
      if(check(cows, temp[0], temp[1])){
        result++;
      }
    }
    return result;
  }

  static boolean check(boolean[][] cows, int x, int y){
    boolean[] directions = new boolean[4]; // {left, right, up, down}
    if(x != 0){
      directions[0] = cows[x-1][y];
    }
    if(x != 1000){
      directions[1] = cows[x+1][y];
    }
    if(y != 0){
      directions[2] = cows[x][y-1];
    }
    if(y != 1000){
      directions[3] = cows[x][y+1];
    }
    int result = 0;
    for(int i = 0; i<4; i++){
      if(directions[i]){
        result++;
      }
    }
    if(result == 3){
      return true;
    }
    return false;
  }
}