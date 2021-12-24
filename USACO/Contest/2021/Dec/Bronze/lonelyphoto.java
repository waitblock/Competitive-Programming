import java.util.*;

public class lonelyphoto {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    in.nextInt();
    String cows = in.next();
    ArrayList<String> substrs = new ArrayList<>();
    for(int i = 3; i<=cows.length(); i++){
      for (int j = 0; j <= cows.length() - i; j++) {
        String sub = cows.substring(j, j + i);
        substrs.add(sub);
      }
    }
    // System.out.println(substrs);
    ArrayList<int[]> subarrs = new ArrayList<>();
    for(String s : substrs){
      char[] chars = s.toCharArray();
      int[] temp = new int[s.length()];
      for(int i = 0; i<chars.length; i++) temp[i] = (int) s.charAt(i)-71;
      subarrs.add(temp);
    }
    // for(int i = 0; i<subarrs.size(); i++){
    //   System.out.println(Arrays.toString(subarrs.get(i)));
    // }
    int lonely = 0;
    for(int[] arr : subarrs){
      if(lonely(arr)) lonely++;
    }
    System.out.println(lonely);
  }

  static boolean lonely(int[] lineup) {
    int[] count = new int[2];
    for(int i = 0; i<lineup.length; i++){
      count[lineup[i]]++;
    }
    return (count[0] == 1 || count[1] == 1);
  }
}