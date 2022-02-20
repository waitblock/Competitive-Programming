import java.util.*;
import java.io.*;

public class cownomics {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("cownomics.in"));
    int n = in.nextInt();
    int m = in.nextInt();
    char[][] spotty = new char[n][m];
    char[][] plain = new char[n][m];

    in.nextLine();

    for(int i = 0; i<n; i++){
      spotty[i] = in.nextLine().toCharArray();
    }

    for(int i = 0; i<n; i++){
      plain[i] = in.nextLine().toCharArray();
    }

    in.close();
    // for(char[] arr : spotty){
    //   System.out.println(Arrays.toString(arr));
    // }
    // for(char[] arr : plain){
    //   System.out.println(Arrays.toString(arr));
    // }
    int result = 0;

    for(int i = 0; i<m; i++){
      char[] spot = new char[n];
      char[] noSpot = new char[n];
      for(int j = 0; j<n; j++){
        spot[j] = spotty[j][i];
        noSpot[j] = plain[j][i];
      }

      if(possible(spot, noSpot)) result++;

      // System.out.println("-");
      // System.out.println(Arrays.toString(spot));
      // System.out.println(Arrays.toString(noSpot));
      // System.out.println(possible(spot, noSpot));
    }

    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("cownomics.out"));
    out.println(result);
    out.close();
  }

  static boolean possible(char[] spot, char[] noSpot){
    HashSet<Character> temp = new HashSet<>();
    for(int i = 0; i<noSpot.length; i++){
      temp.add(noSpot[i]);
    }
    for(int i = 0; i<spot.length; i++){
      if(temp.contains(spot[i])) return false;
    }

    return true;
  }
}