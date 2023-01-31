import java.util.*;

public final class aircon_v2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int[] s = new int[n];
    int[] t = new int[n];
    int[] c = new int[n];
    for(int i = 0; i<n; i++){
      s[i] = in.nextInt(); t[i] = in.nextInt(); c[i] = in.nextInt();
    }
    int end = Integer.MIN_VALUE;
    for(int i = 0; i<n; i++){
      end = Math.max(end, t[i]);
    }

    int[] a = new int[m];
    int[] b = new int[m];
    int[] p = new int[m];
    int[] cost = new int[m];

    for(int i = 0; i<m; i++){
      a[i] = in.nextInt();
      b[i] = in.nextInt();
      p[i] = in.nextInt();
      cost[i] = in.nextInt();
    }
    in.close();

    int[] req = new int[end+1];
    for(int i = 0; i<n; i++){
      for(int j = s[i]; j<=t[i]; j++){
        req[j] = Math.max(req[j], c[i]);
      }
    }
    // System.out.println(Arrays.toString(req));

    int[] cooled = new int[end+1];
    int total = 0;

    for(int i = 0; i<m; i++){
      for(int j = a[i]; j<=b[i]; j++){
        cooled[j] += p[i];
      }
      total += cost[i];
    }
    // System.out.println(Arrays.toString(cooled));

    HashSet<Integer> removed = new HashSet<>();

    for(int ac = 0; ac<m; ac++){
      int worstInd = -1;
      float worstVal = Float.MAX_VALUE;
      for(int i = 0; i<m; i++){
        if(removed.contains(i)) continue;
        for(int j = a[i]; j<=b[i]; j++){
          cooled[j] -= p[i];
        }
        boolean valid = true;
        for(int j = a[i]; j<=b[i]; j++){
          if(cooled[j] < req[j]){
            valid = false;
            break;
          }
        }
        if(valid) {
          int val = (b[i]-a[i]+1)/cost[i];
          if(val < worstVal){
            worstInd = i;
            worstVal = val;
          }
        }
        for(int j = a[i]; j<=b[i]; j++){
          cooled[j] += p[i];
        }
      }
      if(worstInd == -1){
        break;
      }
      else {
        total -= cost[worstInd];
        removed.add(worstInd);
      }
      for(int i = a[worstInd]; i<=b[worstInd]; i++){
         cooled[i] -= p[worstInd];
      }
    }
    System.out.println(total);
  }
}