import java.util.*;

public class daisychains{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    int[] petals = new int[n];

    for(int i = 0; i<n; i++){
      petals[i] = in.nextInt();
    }

    int result = 0;

    for(int i = 0; i<petals.length; i++){
      ArrayList<Integer> temp = new ArrayList<>();
      for(int j = i; j<petals.length; j++){
        temp.add(petals[j]);
        int sum = 0;
        for(int k : temp){
          sum += k;
        }
        float avg = (float) sum / (float) temp.size();
        for(int k : temp){
          if((float) k == avg){
            result++;
            break;
          }
        }
      }
    }

    System.out.println(result);
  }
}