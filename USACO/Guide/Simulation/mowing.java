import java.util.*;
import java.io.*;

public class mowing{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("mowing.in"));
    int n = in.nextInt();

    HashMap<Integer, int[]> visited = new HashMap<>(); // entry: coordinate, time (t)

    int johnX = 0;
    int johnY = 0;
    int t = 0;
    visited.put(t, new int[]{johnX, johnY});

    for(int i = 0; i<n; i++){
      String direction = in.next();
      int distance = in.nextInt();

      for(int j = 0; j<distance; j++){
        t++;
        if(direction.equals("N")){
          johnY--;
        }
        if(direction.equals("S")){
          johnY++;
        }
        if(direction.equals("W")){
          johnX--;
        }
        if(direction.equals("E")){
          johnX++;
        }
        visited.put(t, new int[]{johnX, johnY});
      }
    }

    in.close();

    // for(int i = 0; i<t; i++){
    //   System.out.println(i);
    //   System.out.println(Arrays.toString(visited.get(i)));
    //   System.out.println("--");
    // }

    ArrayList<Integer> doubleVisited = new ArrayList<>(); // store the difference between first visit time and last visit time for duplicate coordinates

    for(int i = 0; i<t; i++){
      int[] current = visited.get(i);
      for(int j = t-1; j>i; j--){
        if(equals(current, visited.get(j))){
          doubleVisited.add(j-i);
          break;
        }
      }
    }

    System.out.println(doubleVisited);

    int result = Integer.MAX_VALUE;

    if(doubleVisited.size() == 0){
      result = -1;
    }
    else{
      for(int i = 0; i<doubleVisited.size(); i++){
        if(doubleVisited.get(i) < result) result = doubleVisited.get(i);
      }
    }

    System.out.println(result);

    PrintWriter out = new PrintWriter(new File("mowing.out"));
    out.println(result);
    out.close();
  }

  static boolean equals(int[] a, int[] b){
    for(int i = 0; i<a.length; i++){
      if(a[i] != b[i]) return false;
    }
    return true;
  }
}