// 20 min 58 sec

import java.util.*;
import java.io.*;

public final class notlast_v2 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("notlast.in"));
    int n = in.nextInt();
    HashMap<String, Integer> milk = new HashMap<>();
    for(int i = 0; i<n; i++){
      String cow = in.next();
      int m = in.nextInt();
      if(milk.get(cow) == null){
        milk.put(cow, m);
      }
      else{
        milk.put(cow, milk.get(cow)+m);
      }
    }
    String[] cows = {"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
    for(int i = 0; i<cows.length; i++){
      if(!milk.keySet().contains(cows[i])){
        milk.put(cows[i], 0);
      }
    }
    int m = Integer.MAX_VALUE;
    for(String s : milk.keySet()){
      m = Math.min(m, milk.get(s));
    }
    HashSet<String> mCows = new HashSet<>();
    String mCow = "";
    int m2 = Integer.MAX_VALUE;
    for(String s : milk.keySet()){
      if(milk.get(s) == m) continue;
      if(milk.get(s) < m2){
        mCows.clear();
        mCows.add(s);
        mCow = s;
        m2 = milk.get(s);
      }
      else if(milk.get(s) == m2){
      mCows.add(s);
      }
    }
    String result = (mCows.size() > 1 || mCows.size() == 0) ? "Tie" : mCow;
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("notlast.out"));
    out.println(result);
    out.close();
    in.close();
  }
}