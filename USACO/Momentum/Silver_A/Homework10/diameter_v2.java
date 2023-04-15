import java.util.*;
import java.io.*;

public final class diameter_v2 {
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;
    static int maxDist, farthestNode;
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
    adj = new ArrayList<>();
    visited = new boolean[n + 1];

    for (int i = 1; i <= n; i++) {
        adj.add(new ArrayList<Integer>());
    }

    for (int i = 1; i < n; i++) {
        int a = in.nextInt()-1;
        int b = in.nextInt()-1;
        adj.get(a).add(b);
        adj.get(b).add(a);
    }
    in.close();

    maxDist = 0;
    farthestNode = 1;
    dfs(1, 0);

    Arrays.fill(visited, false);
    maxDist = 0;
    dfs(farthestNode, 0);

    System.out.println(maxDist);
    in.close();
  }
  static void dfs(int node, int dist) {
    visited[node] = true;
    if (dist > maxDist) {
        maxDist = dist;
        farthestNode = node;
    }

    for (int i = 0; i < adj.get(node).size(); i++) {
        int nextNode = adj.get(node).get(i);
        if (!visited[nextNode]) {
            dfs(nextNode, dist + 1);
        }
    }
    }
}