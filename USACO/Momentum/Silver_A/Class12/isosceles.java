import java.util.*;
import java.io.*;

public final class isosceles {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.print("Enter directory: ");
    String dir = in.next();
    while(true){
      System.out.print("Enter filename: ");
      String f = in.next();
      try{
        solve(dir+"/"+f);
      }
      catch(Exception e){
        e.printStackTrace(System.err);
      }
    }
  }
  static void solve(String filename) throws FileNotFoundException {
    Scanner in = new Scanner(new File(filename));
    int n = in.nextInt();
    Point[] points = new Point[n];
    for(int i = 0; i<n; i++){
      int x = in.nextInt();
      int y = in.nextInt();
      points[i] = new Point(x,y);
    }
    int result = 0;
    for(int i = 0; i<n; i++){
      HashMap<Integer, Integer> count = new HashMap<>();
      for(int j = 0; j<n; j++){
        if(j == i) continue;
        int d = points[i].dist(points[j]);
        int temp = 1;
        if(count.get(d) != null){
          temp += count.get(d);
        }
        count.put(d,temp);
      }
      for(int j : count.values()){
        result += j*(j-1);
      }
    }
    System.out.println(result);


    in.close();
  }

  static class Point {
    int x, y;
    Point(int x, int y){
      this.x = x;
      this.y = y;
    }
    int dist(Point p){ // returns distance squared to another point
      int xDist = this.x - p.x;
      xDist *= xDist;
      int yDist = this.y - p.y;
      yDist *= yDist;
      return xDist + yDist;
    }
  }
}