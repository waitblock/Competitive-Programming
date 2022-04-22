import java.util.*;
import java.io.*;

public class cowroute {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("cowroute.in"));
    int a = in.nextInt();
    int b = in.nextInt();
    int n = in.nextInt();
    int[] cost = new int[n];
    ArrayList<ArrayList<Integer>> stops = new ArrayList<>();
    for(int i = 0; i<n; i++){
      cost[i] = in.nextInt();
      int count = in.nextInt();
      ArrayList<Integer> temp = new ArrayList<>();
      for(int j = 0; j<count; j++){
        temp.add(in.nextInt());
      }
      stops.add(temp);
    }
    in.close();
    System.out.println(stops);
    int result = Integer.MAX_VALUE;
    for(int i = 0; i<n; i++){
      int indA = stops.get(i).indexOf(a);
      int indB = stops.get(i).indexOf(b);
      if(indA == -1 || indB == -1) continue;
      if(indA < indB) result = Math.min(result, cost[i]);
    }
    if(result == Integer.MAX_VALUE) result = -1;
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("cowroute.out"));
    out.println(result);
    out.close();
  }
}