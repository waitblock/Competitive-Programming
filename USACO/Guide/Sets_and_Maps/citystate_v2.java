import java.util.*;
import java.io.*;

public class citystate_v2 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("citystate.in"));
    int n = in.nextInt();
    HashMap<String, ArrayList<String>> s = new HashMap<>(); // map state to cities
    String[] cities = new String[n];
    String[] states = new String[n];
    for(int i = 0; i<n; i++){
      String city = in.next();
      String state = in.next();
      ArrayList<String> t = new ArrayList<>();
      t.add(city);
      if(s.get(state) != null){
        for(String st : s.get(state)){
          t.add(st);
        }
      }
      s.put(state, t);
      cities[i] = city;
      states[i] = state;
    }
    in.close();
    // System.out.println(s);
    int result = 0;
    for(int i = 0; i<n; i++){
      ArrayList<String> ci = s.get(cities[i].substring(0,2));
      if(ci != null){
        for(String c : ci){
          if(c.substring(0,2).equals(states[i])){
            result++;
          }
        }
      }
    }
    result /= 2;
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("citystate.out"));
    out.println(result);
    out.close();
  }
}
