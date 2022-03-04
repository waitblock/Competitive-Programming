import java.util.*;

public class sleeping_v2 {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();
    for(int asdf = 0; asdf<t; asdf++){
      int n = in.nextInt();
      ArrayList<Integer> entries = new ArrayList<>();
      for(int i = 0; i<n; i++){
        entries.add(in.nextInt());
      }
      int result = solve(entries, 0);
      System.out.println(result);
    }
  }

  static int solve(ArrayList<Integer> arr, int count){
    boolean finished = true;
    int number = arr.get(0);
    for(int i = 1; i<arr.size(); i++){
      if(arr.get(i) != number){
        finished = false;
        break;
      }
    }
    if(finished || arr.size() == 1){
      return count;
    }
    int minimum = Integer.MAX_VALUE;
    for(int i = 0; i<arr.size()-1; i++){
      ArrayList<Integer> copy = new ArrayList<Integer>();
      copy.addAll(arr);
      copy.set(i, copy.get(i)+copy.get(i+1));
      copy.remove(i+1);
      minimum = Math.min(solve(copy, count+1), minimum);
    }

    return minimum;
  }
}
