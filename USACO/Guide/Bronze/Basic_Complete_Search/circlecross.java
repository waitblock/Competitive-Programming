import java.util.*;
import java.io.*;

public class circlecross {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("circlecross.in"));

    ArrayList<Character> crossing = new ArrayList<>();
    char[] a = in.nextLine().toCharArray();
    for(int i = 0; i<52; i++) crossing.add(a[i]);
    // System.out.println(crossing);

    ArrayList<Character> visited = new ArrayList<>();

    int result = 0;

    for(int i = 0; i<52; i++){
      if(visited.contains(crossing.get(i))) continue;
      int startInd = i;
      int endInd = 0;
      for(int j = i+1; j<52; j++){
        if(crossing.get(j) == crossing.get(i)){
          endInd = j;
          break;
        }
      }
      HashMap<Character, Integer> counter = new HashMap<>();
      for(int j = startInd+1; j<endInd; j++){
        char c = crossing.get(j);
        int count = 1;
        if(counter.keySet().contains(c)){
          count += counter.get(c);
        }
        counter.put(c, count);
      }

      for(char c : counter.keySet()){
        if(counter.get(c) == 1) result++;
      }

      visited.add(crossing.get(i));
    }

    result /= 2; // compensate for double-counting

    System.out.println(result);

    PrintWriter out = new PrintWriter(new File("circlecross.out"));
    out.println(result);
    out.close();
  }
}