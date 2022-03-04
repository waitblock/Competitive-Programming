import java.util.*;

public class photoshoot {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    ArrayList<Integer> order = new ArrayList<>();
    ArrayList<Integer> desired = new ArrayList<>();

    for(int i = 0; i<n; i++){
      order.add(in.nextInt());
    }
    for(int i = 0; i<n; i++){
      desired.add(in.nextInt());
    }

    int result = 0;

    while(true){
      boolean finished = true;
      for(int i = 0; i<n; i++){
        if(order.get(i) != desired.get(i)){
          finished = false;
        }
      }
      if(finished) break;
      int max_dist = Integer.MIN_VALUE;
      int max_ind = 0;
      for(int i = 0; i < n; i++){
        int dist = Math.abs(i-desired.indexOf(order.get(i)));
        if(dist > max_dist){
          max_dist = dist;
          max_ind = i;
        }
      }
      int temp = order.get(max_ind);
      order.remove(max_ind);
      order.add(desired.indexOf(temp), temp);
      System.out.println(order);
      result++;
    }

    System.out.println(result);
  }
}