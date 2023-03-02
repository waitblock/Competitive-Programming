import java.util.*;
import java.io.*;

public class citystate {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("citystate.in"));
    int n = in.nextInt();
    HashMap<String, Long> s = new HashMap<>(); // map 4 letter code to count
    for(int i = 0; i<n; i++){
      String code = in.next().substring(0,2) + in.next();
      if(code.substring(0,2).equals(code.substring(2,4))) continue; // ignore "self-counting" codes
      Long c = 1L;
      if(s.get(code) != null) c += s.get(code);
      s.put(code, c);
    }
    in.close();
    // System.out.println(s);
    long result = 0;
    for(String code : s.keySet()) {
    	String comp = code.substring(2,4) + code.substring(0,2);
    	result += s.get(code) * (s.get(comp) == null ? 0 : s.get(comp));
    }
    result /= 2;
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("citystate.out"));
    out.println(result);
    out.close();
  }
}
