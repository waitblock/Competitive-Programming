// wrong answer on case 4

import java.util.*;
import java.io.*;

public class cowroute_2 {
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
    int[] cA = new int[10001];
    int[] cB = new int[10001];
    for(int i = 0; i<10001; i++) cA[i] = Integer.MAX_VALUE/2;
    for(int i = 0; i<10001; i++) cB[i] = Integer.MAX_VALUE/2;
    cA[a] = 0;
    cB[b] = 0;

    for(int i = 0; i<n; i++){
      ArrayList<Integer> s = stops.get(i);
      // System.out.println(s);
      int posA = s.size();
      int posB = -1;
      for(int j = 0; j<s.size(); j++){
        if(s.get(j) == a) posA = j;
        if(s.get(j) == b) posB = j;
      }
      // System.out.println(posA);
      // System.out.println(posB);
      for(int j = 0; j<s.size(); j++){
        if(j >= posA) cA[s.get(j)] = Math.min(cA[s.get(j)], cost[i]);
        if(j <= posB) cB[s.get(j)] = Math.min(cB[s.get(j)], cost[i]);
      }
    }
    int result = Integer.MAX_VALUE;
    for(int i = 1; i<10001; i++){
      result = Math.min(result, cA[i]+cB[i]);
    }
    if(result == Integer.MAX_VALUE) result = -1;
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("cowroute.out"));
    out.println(result);
    out.close();
  }
}