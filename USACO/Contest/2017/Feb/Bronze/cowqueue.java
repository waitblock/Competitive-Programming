/*
this solution does not work because sometimes two cows will come
at the same time and treemaps do not allow duplicate keys
*/

import java.util.*;
import java.io.*;

class cowqueue {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("cowqueue.in"));
    int n = in.nextInt();

    TreeMap<Integer, Integer> times = new TreeMap<Integer, Integer>();

    for(int i = 0; i<n; i++){
      int arrival = in.nextInt();
      int duration = in.nextInt();
      System.out.println(String.valueOf(arrival) + "," + String.valueOf(duration));
      times.put(arrival, duration);
    }

    int time = 0;


    System.out.println(times);

    for(int i = 0; i<n; i++){
      if(times.firstKey() > time){
        time = times.firstKey();
        time += times.get(times.firstKey());
      }
      else if (times.firstKey() < time){
        time += times.get(times.firstKey());
      }
      times.remove(times.firstKey());
    }

    System.out.println(time);

    PrintWriter out = new PrintWriter(new File("cowqueue.out"));
    out.println(time);
    out.close();
  }
}
