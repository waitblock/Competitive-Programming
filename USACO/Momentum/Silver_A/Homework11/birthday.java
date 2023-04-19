// wrong answer on case 3 and 5

import java.util.*;
import java.io.*;

public final class birthday {
    static ArrayList<HashSet<Integer>> adj = new ArrayList<>();

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
    int q = in.nextInt();
    int result = 0;
    for(int i = 0; i<q; i++){

        int p = in.nextInt();
        int c = in.nextInt();
        for(int j = 0; j<p; j++){
            adj.add(new HashSet<Integer>());
        }
        for(int j = 0; j<c; j++){
            int a = in.nextInt();
            int b = in.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        // System.out.println(adj);
        boolean valid = true;
        for(int j = 0; j<p; j++){
            if(adj.get(j).size() == 1){
                valid = false;
                break;
            }
        }
        if(!valid){
            result++;
        }
        adj.clear();
    }
    System.out.println(result);
    in.close();
  }
}