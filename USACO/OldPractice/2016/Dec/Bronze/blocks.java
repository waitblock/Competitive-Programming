import java.util.*;
import java.io.*;

public class blocks {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("blocks.in"));
    int n = in.nextInt();
    int[] blocks = new int[26];

    for(int i = 0; i<n; i++){
      String board1 = in.next();
      String board2 = in.next();

      for(int j = 0; j<26; j++){
        if(countLetters(board1)[j] > countLetters(board2)[j]){
          blocks[j] += countLetters(board1)[j];
        }
        else{
          blocks[j] += countLetters(board2)[j];
        }
      }
    }

    in.close();

    PrintWriter out = new PrintWriter(new File("blocks.out"));
    for(int i = 0; i<26; i++) out.println(blocks[i]);
    out.close();
  }

  public static int[] countLetters(String str){
    int[] result = new int[26];
    for(int i = 0; i<str.length(); i++) result[str.charAt(i)-97] += 1;
    return result;
  }
}
