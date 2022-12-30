import java.util.*;

public final class CF_4B {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int d = in.nextInt();
    int sumTime = in.nextInt();
    int[] minTime = new int[d];
    int[] maxTime = new int[d];
    for(int i = 0; i<d; i++){
      minTime[i] = in.nextInt();
      maxTime[i] = in.nextInt();
    }
    int[] currentTime = new int[d];
    int currentSumTime = 0;
    for(int i = 0; i<d; i++){
      currentSumTime += maxTime[i];
      currentTime[i] = maxTime[i];
    }
    while(true){
      // if valid case is found
      if(sumTime == currentSumTime){
        System.out.println("YES");
        break;
      }
      int maxDiff = Integer.MIN_VALUE;
      int maxDiffInd = -1;
      for(int i = 0; i<d; i++){
        int diff = currentTime[i] - minTime[i];
        if(maxDiff < diff){
          maxDiff = diff;
          maxDiffInd = i;
        }
      }
      // System.out.println(maxDiff);
      // System.out.println(Arrays.toString(currentTime));
      // if invalid case is found
      if(maxDiff == 0){
        System.out.println("NO");
        System.exit(0);
      }
      currentTime[maxDiffInd]--;
      currentSumTime--;
    }
    // System.out.println(Arrays.toString(currentTime));
    for(int i = 0; i<d; i++){
      System.out.print(currentTime[i]);
      System.out.print(" ");
    }
    System.out.print("\n");
  }
}