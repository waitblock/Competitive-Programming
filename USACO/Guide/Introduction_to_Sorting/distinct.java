import java.util.*;

public class distinct {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    HashSet<Integer> hs = new HashSet<>();
    for(int i = 0; i<n; i++){
      hs.add(in.nextInt());
    }
    System.out.println(hs.size());
  }
}