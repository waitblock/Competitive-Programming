import java.util.*;
import java.io.*;

public final class strings {

  static char[] c;
  static ArrayList<String> result = new ArrayList<>();
  static int[] cCount = new int[26];

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    c = in.next().toCharArray();
    for(int i = 0; i<c.length; i++){
      cCount[c[i]-'a']++;
    }
    solve("");
    Collections.sort(result);
    PrintWriter out = new PrintWriter(System.out);
    out.println(result.size());
    for(String s : result){
      out.println(s);
    }
    out.close();
  }
  static void solve(String currentPermutation){
    if(currentPermutation.length() == c.length){
      result.add(currentPermutation);
      return;
    }
    for(int i = 0; i<26; i++){
      if(cCount[i] > 0){
        cCount[i]--;
        solve(currentPermutation + (char) (i+'a'));
        cCount[i]++;
      }
    }
  }
}
