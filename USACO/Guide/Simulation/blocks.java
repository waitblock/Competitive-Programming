import java.util.*;
import java.io.*;

public class blocks{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("blocks.in"));
    int n = in.nextInt();
    String[] side1 = new String[n];
    String[] side2 = new String[n];
    for(int i = 0; i<n; i++){
      side1[i] = in.next();
      side2[i] = in.next();
    }
    in.close();
    int[] result = new int[26];
    for(int i = 0; i<n; i++){

      int[] count1 = new int[26]; // count for word1
      int[] count2 = new int[26]; // count for word2

      char[] word1 = side1[i].toCharArray();
      char[] word2 = side2[i].toCharArray();

      for(int j = 0; j<word1.length; j++){
        count1[word1[j] - 'a']++;
      }

      for(int j = 0; j<word2.length; j++){
        count2[word2[j] - 'a']++;
      }
      for(int j = 0; j<26; j++){
        result[j] += Math.max(count1[j], count2[j]);
      }
    }
    // System.out.println(Arrays.toString(result));
    PrintWriter out = new PrintWriter(new File("blocks.out"));
    for(int i = 0; i<26; i++){
      out.println(result[i]);
      // System.out.println((char) ('a' + i));
      System.out.println(result[i]);
    }
    out.close();
  }
}