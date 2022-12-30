import java.util.*;

public final class feeding {
  static Scanner in = new Scanner(System.in);
  public static void main(String[] args) {
    int t = in.nextInt();
    for(int i = 0; i<t; i++) solve();
    in.close();
  }

  static void solve(){
    int n = in.nextInt();
    int k = in.nextInt();
    char[] cows = in.next().toCharArray();
    boolean[] gPatch = new boolean[n];
    boolean[] hPatch = new boolean[n];
    char[] patch = new char[n];
    for(int i = 0; i<n; i++) patch[i] = '.';
    int[] g = new int[n];
    int[] h = new int[n];
    for(int i = 0; i<n; i++){
      int start = i-k >= 0 ? i-k : 0;
      int end = i+k < n ? i+k : n-1;
      int gCount = 0;
      int hCount = 0;
      for(int j = start; j<=end; j++){
        if(cows[j] == 'G'){
          gCount++;
        }
        if(cows[j] == 'H'){
          hCount++;
        }
      }
      g[i] = gCount;
      h[i] = hCount;
    }
    // System.out.println(Arrays.toString(g));
    // System.out.println(Arrays.toString(h));
    int count = 0;
    while(true){
      // System.out.println(Arrays.toString(gPatch));
      // System.out.println(Arrays.toString(hPatch));
      // System.out.println("");
      boolean valid = true;
      for(int i = 0; i<n; i++){
        if(!((cows[i] == 'G' && gPatch[i]) || (cows[i] == 'H' && hPatch[i]))){
          valid = false;
          break;
        }
      }
      if(valid) break;
      int gMax = Integer.MIN_VALUE;
      int gInd = -1;
      int hMax = Integer.MIN_VALUE;
      int hInd = -1;
      // System.out.println(gMax);
      for(int i = 0; i<n; i++){
        if(g[i] > gMax && !gPatch[i] && patch[i] == '.'){
          gMax = g[i];
          gInd = i;
        }
        if(h[i] > hMax && !hPatch[i] && patch[i] == '.'){
          hMax = h[i];
          hInd = i;
        }
      }
      // System.out.println(gMax);
      // System.out.println(gInd);
      // System.out.println(hMax);
      // System.out.println(hInd);
      if(gMax > hMax){
        // System.out.println("g bigger");
        int start = gInd-k >= 0 ? gInd-k : 0;
        int end = gInd+k < n ? gInd+k : n-1;
        for(int i = start; i<= end; i++){
          gPatch[i] = true;
        }
        patch[gInd] = 'G';
      }
      else{
        // System.out.println("h bigger");
        int start = hInd-k >= 0 ? hInd-k : 0;
        int end = hInd+k < n ? hInd+k : n-1;
        for(int i = start; i<= end; i++){
          hPatch[i] = true;
        }
        patch[hInd] = 'H';
      }
      count++;
    }
    System.out.println(count);
    for(int i = 0; i<n; i++) System.out.print(patch[i]);
    System.out.print("\n");
  }
}