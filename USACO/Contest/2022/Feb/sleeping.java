import java.util.*;

public class sleeping {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();
    for(int asdf = 0; asdf<t; asdf++){
      int n = in.nextInt();
      ArrayList<Integer> entries = new ArrayList<>();
      for(int i = 0; i<n; i++){
        entries.add(in.nextInt());
      }
      int result = 0;
      while(true){
        if(allEqual(entries)) break;
        int minimum = Integer.MAX_VALUE;
        int minimum_index = 0;
        for(int i = 0; i<entries.size()-1; i++){
          if(entries.get(i) < minimum){
            minimum = entries.get(i);
            minimum_index = i;
          }
        }
        entries = combine(entries, minimum_index, minimum_index+1);
        result++;
      }
      System.out.println(result);
    }
  }

  static ArrayList<Integer> combine(ArrayList<Integer> al, int index1, int index2){
    ArrayList<Integer> ret = new ArrayList<>();
    for(int i = 0; i<al.size(); i++){
      if(i == index1){
        ret.add(al.get(index1)+al.get(index2));
        continue;
      }
      if(i == index2) continue;
      ret.add(al.get(i));
    }
    return ret;
  }

  static boolean allEqual(ArrayList<Integer> al){
    int num = al.get(0);
    for(int i = 1; i<al.size(); i++){
      if(al.get(i) != num){
        return false;
      }
    }
    return true;
  }
}