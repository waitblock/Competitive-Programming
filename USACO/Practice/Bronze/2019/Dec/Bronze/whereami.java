import java.util.*;
import java.io.*;

public class whereami {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("whereami.in"));
    int n = in.nextInt();
    char[] mailboxes = in.next().toCharArray();
    in.close();
    ArrayList<String> store = new ArrayList<String>();
    for(int i = 1; i<=n; i++){
      for(int j = 0; j<=n-i; j++){
        String temp = "";
        for(int k = j; k<j+i; k++){
          temp += ("" + mailboxes[k]);
        }
        store.add(temp);
        // System.out.println(temp);
      }
      if(!duplicates(store)){
        PrintWriter out = new PrintWriter(new File("whereami.out"));
        out.println(i);
        System.out.println("Result: " + String.valueOf(i));
        out.close();
        System.exit(0);
      }
      store.clear();
    }
  }

  static boolean duplicates(ArrayList<String> arr){
    TreeSet<String> set = new TreeSet<String>();
    for(String s : arr){
      if(set.contains(s)) return true;
      set.add(s);
    }
    return false;
  }
}