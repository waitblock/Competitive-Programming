import java.util.*;

public final class moo {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for(int tc=0; tc<q; tc++){
      String s = in.next();
      if(s.length() < 3){
        System.out.println(-1);
        continue;
      }
      boolean ooo = false;
      boolean oom = false;
      boolean moo = false;
      boolean mom = false;
      for(int i = 0; i<s.length()-2; i++){
        String sub = s.substring(i,i+3);
        if(sub.equals("OOO")) ooo = true;
        else if(sub.equals("OOM")) oom = true;
        else if(sub.equals("MOO")) moo = true;
        else if(sub.equals("MOM")) mom = true;
      }
      if(!ooo && !oom && !moo && !mom){
        System.out.println(-1);
        continue;
      }
      int result = s.length()-3;
      int addTo = 0;
      if(oom) addTo = 2;
      if(ooo || mom) addTo = 1;
      if(moo) addTo = 0;
      result += addTo;
      System.out.println(result);
    }
    in.close();
  }
}