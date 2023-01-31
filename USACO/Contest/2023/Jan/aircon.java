import java.util.*;

public final class aircon {
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
      int bestInd = -1;
      int bestVal = -1;
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
          if(cost[i] > bestVal){
            bestInd = i;
            bestVal = cost[i];
          }
        }
        for(int j = a[i]; j<=b[i]; j++){
          cooled[j] += p[i];
        }
      }
      if(bestInd == -1){
        break;
      }
      else {
        total -= bestVal;
        removed.add(bestInd);
      }
      for(int i = a[bestInd]; i<=b[bestInd]; i++){
         cooled[i] -= p[bestInd];
      }
    }
    System.out.println(total);
  }
}