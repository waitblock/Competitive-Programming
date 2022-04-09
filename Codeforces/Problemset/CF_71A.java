import java.util.*;

public class CF_71A {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String[] words = new String[n];
    for(int i = 0; i<n; i++){
      words[i] = in.next();
    }
    for(int i = 0; i<words.length; i++){
      String word = words[i];
      if(word.length() <= 10){
        System.out.println(word);
      }
      else{
        char[] word_arr = word.toCharArray();
        System.out.println(String.valueOf(word.charAt(0))+String.valueOf(word.length()-2)+String.valueOf(word.charAt(word.length()-1)));
      }
    }
  }
}
