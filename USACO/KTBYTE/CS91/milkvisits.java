// tle cases 6-12

import java.util.*;
import java.io.*;

public final class milkvisits {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("milkvisits.in"));
    int n = in.nextInt();
    int m = in.nextInt();
    char[] breeds = in.next().toCharArray();
    HashMap<Integer, ArrayList<Integer>> neighbors = new HashMap<>();
    for(int i = 0; i<n-1; i++){
      int r1 = in.nextInt()-1;
      int r2 = in.nextInt()-1;
      // System.out.println(r1);
      // System.out.println(r2);
      ArrayList<Integer> temp = new ArrayList<>();
      temp.add(r2);
      if(!(neighbors.get(r1) == null)){
        for(int j : neighbors.get(r1)) temp.add(j);
      }
      // System.out.println(temp);
      neighbors.put(r1, temp);
      // System.out.println(neighbors);
      ArrayList<Integer> temp2 = new ArrayList<>();
      temp2.add(r1);
      if(!(neighbors.get(r2) == null)){
        for(int j : neighbors.get(r2)) temp2.add(j);
      }
      neighbors.put(r2,temp2);
      // System.out.println(neighbors);
    }

    int[] connectedComponent = new int[n];
    int component = 1;
    // component ident
    for(int i = 0; i<n; i++){
      if(connectedComponent[i] != 0) continue;
      ArrayDeque<Integer> toVisit = new ArrayDeque<>();
      toVisit.add(i);
      // DFS to ident connected components
      while(!toVisit.isEmpty()){
        int temp = toVisit.poll();
        connectedComponent[temp] = component;
        for(int neighbor : neighbors.get(temp)){
          if(breeds[neighbor] == breeds[temp] && connectedComponent[neighbor] == 0) toVisit.add(neighbor);
        }
      }
      component++;
    }
    PrintWriter out = new PrintWriter(new File("milkvisits.out"));
    for(int i = 0; i<m; i++){
      int start = in.nextInt() - 1;
      int end = in.nextInt() - 1;
      char prefer = in.next().charAt(0);
      if(connectedComponent[start] == connectedComponent[end]){
        out.print(breeds[start] == prefer ? 1 : 0);
        System.out.print(breeds[start] == prefer ? 1 : 0);
      }
      else{
        out.print(1);
        System.out.print(1);
      }
    }
    System.out.print("\n");
    out.print("\n");
    in.close();
    out.close();
  }
}
