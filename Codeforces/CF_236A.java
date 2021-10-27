import java.util.*;

public class CF_236A {
  public static void main(String[] args){
    final String girl = "CHAT WITH HER!";
    final String boy = "IGNORE HIM!";
    Scanner sc = new Scanner(System.in);
    char[] name = sc.nextLine().toCharArray();
    sc.close();

    TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();

    for(char c : name){
      map.put(c, null);
    }

    if(map.keySet().size() % 2 == 0){
      System.out.println(girl);
    }
    else{
      System.out.println(boy);
    }
  }
}
