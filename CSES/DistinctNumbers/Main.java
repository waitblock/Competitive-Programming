import java.util.*;

public class Main {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();

    int[] arr = new int[n];

    for(int i = 0; i<n; i++){
      arr[i] = in.nextInt();
    }

    TreeSet<Integer> result = new TreeSet<Integer>();

    for(int i = 0; i<n; i++){
      result.add(arr[i]);
    }

    System.out.println(result.size());
  }
}