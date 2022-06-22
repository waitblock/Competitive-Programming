import java.util.*;

public class liars {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    Cow[] cows = new Cow[n];
    for(int i = 0; i<n; i++){
      cows[i] = new Cow(in.next().equals("G") ? true : false, in.nextInt());
    }
    int result = Integer.MAX_VALUE;
    for(int i = 0; i<n; i++){
      Cow c2 = cows[i];
      int count = 0;
      for(Cow c : cows){
        if(!c.consistent(c2.location)) count++;
      }
      result = Math.min(count, result);
    }
    System.out.println(result);
  }

  static class Cow {
    boolean greater = false; // is cow reporting greater than location
    int location = 0;
    Cow(boolean greater, int location){
      this.greater = greater;
      this.location = location;
    }
    boolean consistent(int loc){
      return (greater && loc >= location) || (!greater && loc <= location);
    }
  }
}