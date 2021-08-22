import java.util.*;
import java.io.*;

class cowqueue_1 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("cowqueue.in"));
    int n = in.nextInt();

    int[] arrivals = new int[n];
    int[][] store = new int[n][2];

    for(int i = 0; i < n; i++){
      int arrival = in.nextInt();
      int duration = in.nextInt();

      arrivals[i] = arrival;

      int[] toStore = {arrival, duration};
      store[i] = toStore;
    }

    // for(int i = 0; i < n; i++){
    //   System.out.println(Arrays.toString(store[i]));
    // }

    Arrays.sort(arrivals);

    // System.out.println(Arrays.toString(arrivals));

    int[] durations = new int[n];

    for(int i = 0; i < arrivals.length; i++){
      for(int j = 0; j < store.length; j++){
        if(store[j][0] == arrivals[i]){
          // System.out.println(store[j][1]);
          durations[i] = store[j][1];
        }
      }
    }

    // System.out.println(Arrays.toString(durations));

    int time = 0;

    for(int i = 0; i < n; i++){
      if(arrivals[i] > time){
        time = arrivals[i];
        time += durations[i];
      }
      else if(arrivals[i] < time){
        time += durations[i];
      }
    }

    System.out.println(time);

    PrintWriter out = new PrintWriter(new File("cowqueue.out"));
    out.println(time);
    out.close();
  }
}
