// Note to self: looked at testcases for this problem (bad)

import java.util.*;
import java.io.*;

public class notlast{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("notlast.in"));
    int n = in.nextInt();
    if(n == 0){
      PrintWriter out = new PrintWriter(new File("notlast.out"));
      out.println("Tie");
      out.close();
      System.exit(0);
    }
    if(n == 1){
      PrintWriter out = new PrintWriter(new File("notlast.out"));
      out.println(in.next());
      out.close();
      System.exit(0);
    }
    Map<String, Integer> cows = new HashMap<>();
    for(int i = 0; i<n; i++){
      // System.out.println(cows);
      String cow = in.next();
      int produced = in.nextInt();
      if(!cows.keySet().contains(cow)){
        cows.put(cow, produced);
      }
      else{
        int newValue = cows.get(cow)+produced;
        cows.put(cow, newValue);
      }
      // System.out.println(cow);
      // System.out.println(produced);
    }
    in.close();
    // System.out.println(cows);
    ArrayList<String> cowNames = new ArrayList<>();
    cowNames.addAll(cows.keySet());
    ArrayList<Integer> totalMilk = new ArrayList<>();
    totalMilk.addAll(cows.values());

    // System.out.println(cowNames);
    // System.out.println(totalMilk);
    boolean allSame = true;
    int first = totalMilk.get(0);
    for(int i = 0; i<totalMilk.size(); i++) if(totalMilk.get(i) != first) allSame = false;
    if(allSame){
      PrintWriter out = new PrintWriter(new File("notlast.out"));
      out.println("Tie");
      out.close();
      System.exit(0);
    }

    int min = Integer.MAX_VALUE;
    for(int i = 0; i<totalMilk.size(); i++){
      min = Math.min(min, totalMilk.get(i));
    }
    // System.out.println(min);
    while(totalMilk.contains(min)){
      for(int i = 0; i<totalMilk.size(); i++){
        if(totalMilk.get(i) == min){
          cowNames.remove(i);
          totalMilk.remove(i);
        }
      }
    }
    System.out.println(cowNames);
    System.out.println(totalMilk);

    min = Integer.MAX_VALUE;
    for(int i = 0; i<totalMilk.size(); i++){
      min = Math.min(min, totalMilk.get(i));
    }
    int count = 0;
    for(int i = 0; i<totalMilk.size(); i++){
      if(totalMilk.get(i) == min){
        count++;
      }
    }
    System.out.println(min);
    PrintWriter out = new PrintWriter(new File("notlast.out"));
    if(count >= 2){
      out.println("Tie");
    }
    else{
      out.println(cowNames.get(totalMilk.indexOf(min)));
    }
    out.close();
  }

  static int count(ArrayList<Integer> arrlist, int k){
    int result = 0;
    for(int i = 0; i<arrlist.size(); i++){
      if(arrlist.get(i) == k){
        result++;
      }
    }
    return result;
  }
}