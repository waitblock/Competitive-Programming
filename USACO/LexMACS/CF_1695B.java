import java.util.*;

public final class CF_1695B {
  static Scanner in = new Scanner(System.in);
  public static void main(String[] args) {
    int t = in.nextInt();
    for(int i = 0; i<t; i++) solve();
    in.close();
  }
  static void solve(){
    int n = in.nextInt();
    int[] a = new int[n];
    for(int i = 0; i<n; i++){
      a[i] = in.nextInt();
    }
    if(n % 2 == 1) System.out.println("Mike");
    else{
      int minPile = Integer.MAX_VALUE;
      int minPileInd = -1;
      for(int i = 0; i<n; i++){
        if(a[i] < minPile){
          minPile = a[i];
          minPileInd = i;
        }
      }
      if(minPileInd % 2 == 0) System.out.println("Joe");
      else System.out.println("Mike");
    }
  }
}