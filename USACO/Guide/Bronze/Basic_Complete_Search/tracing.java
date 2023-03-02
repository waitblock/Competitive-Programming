import java.util.*;
import java.io.*;

public final class tracing {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("tracing.in"));
    int n = in.nextInt();
    int t = in.nextInt();
    char[] infected_ = in.next().toCharArray();
    boolean[] infected = new boolean[n+1];
    for(int i = 1; i<=n; i++){
      if(infected_[i-1] == '1'){
        infected[i] = true;
      }
    }
    // Log of interactions
    int[][] interactions = new int[251][2];
    for(int i = 0; i<t; i++) {
    	interactions[in.nextInt()] = new int[] {in.nextInt(), in.nextInt()};
    }
    HashSet<Integer> validPZero = new HashSet<>();
    int minK = Integer.MAX_VALUE;
    int maxK = Integer.MIN_VALUE;
    for(int i = 1; i<=n; i++){ // i is the cow that is patient zero
      for(int j = 0; j<=t; j++){ // j is the k
        boolean[] inf = new boolean[n+1];
        int[] remainingInt = new int[n+1];
        inf[i] = true;
        for(int k = 0; k<=n; k++){
          remainingInt[k] = j;
        }

        for(int k = 1; k<251; k++){
        	if(interactions[k][0] == 0) {
        		continue;
        	}
          if(inf[interactions[k][0]] && !inf[interactions[k][1]] && remainingInt[interactions[k][0]] > 0){
            inf[interactions[k][1]] = true;
            remainingInt[interactions[k][0]]--;
          }
          else if(!inf[interactions[k][0]] && inf[interactions[k][1]] && remainingInt[interactions[k][1]] > 0){
            inf[interactions[k][0]] = true;
            remainingInt[interactions[k][1]]--;
          }
          else if(inf[interactions[k][0]] && inf[interactions[k][1]]) {
        	  remainingInt[interactions[k][0]]--;
        	  remainingInt[interactions[k][1]]--;
          }
        }
        boolean valid = true;
        for(int k = 1; k<=n; k++){
          if(inf[k] != infected[k]){
            valid = false;
            break;
          }
        }
        if(valid){
          validPZero.add(i);
          minK = Math.min(minK, j);
          maxK = Math.max(maxK, j);
        }
      }
    }
    String result = String.valueOf(validPZero.size()) + " " + String.valueOf(minK) + " ";
    if(maxK == t){
      result += "Infinity";
    }
    else{
      result += String.valueOf(maxK);
    }
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("tracing.out"));
    out.println(result);
    out.close();
  }
}
