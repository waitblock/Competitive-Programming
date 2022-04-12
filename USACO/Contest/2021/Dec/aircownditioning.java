import java.util.*;

public class aircownditioning {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] current = new int[n];
    int[] prefer = new int[n];
    for(int i = 0; i<n; i++){
      prefer[i] = in.nextInt();
    }
    for(int i = 0; i<n; i++){
      current[i] = in.nextInt();
    }
    while(!Arrays.equals(prefer, current)){
      Map<ArrayList<Integer>, int[]> subarrs = new HashMap<>(); // int[] has the endpoints
      for(int i = 0; i<current.length; i++){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int j = i; j<current.length; j++){
          temp.add(current[j]);
          int[] endpoints = {i, current.length-1};
          subarrs.put(temp, endpoints);
        }
      }
      int max = -Integer.MAX_VALUE;
      int minEqual = Integer.MAX_VALUE;
      int start = 0;
      int end = 0;
      boolean increase = false; // should i increase?
      for(Map.Entry<ArrayList<Integer>,int[]> entry : subarrs.entrySet()){
        ArrayList<Integer> arrlist = entry.getKey();
        int[] ends = entry.getValue();
        int equal = countEqual(arrlist, prefer);
        int cnt = count(arrlist, prefer);
        System.out.println(arrlist);
        System.out.println(Arrays.toString(ends));
        System.out.println(minEqual);
        System.out.println(equal);
        System.out.println(cnt);
        System.out.println("..");
        if(Math.abs(cnt) > max && equal < minEqual){
          increase = true;
          if(cnt > 0){ // more greater
            increase = false;
          }
          max = Math.abs(cnt);
          start = ends[0];
          end = ends[1];
          minEqual = equal;
        }
      }
      System.out.println(max);
      System.out.println(minEqual);
      System.out.println(start);
      System.out.println(end);
      System.out.println(increase);
      break;
    }
  }

  static int count(ArrayList<Integer> arrlist, int[] prefer){
    int greater = 0;
    int smaller = 0;
    for(int i = 0; i<arrlist.size(); i++){
      if(arrlist.get(i) > prefer[i]){
        greater++;
      }
      if(arrlist.get(i) < prefer[i]){
        smaller++;
      }
    }
    if(greater > smaller){
      return greater;
    }
    if(greater < smaller){
      return -smaller;
    }
    return 0;
  }

  static int countEqual(ArrayList<Integer> arrlist, int[] prefer){
    int count = 0;
    for(int i = 0; i<arrlist.size(); i++){
      if(prefer[i] == arrlist.get(i)){
        count++;
      }
    }
    return count;
  }
}