import java.util.*;

public final class leaders {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    char[] breed = in.next().toCharArray();
    int[] e = new int[n];
    for(int i = 0; i<n; i++){
      e[i] = in.nextInt()-1;
    }
    in.close();
    // System.out.println(Arrays.toString(e));

    int gTotal = 0;
    int hTotal = 0;
    int[] gPos = new int[n];
    int[] hPos = new int[n];

    for(int i = 0; i<n; i++){
      if(breed[i] == 'G') gTotal++;
      else if(breed[i] == 'H') hTotal++;
      gPos[i] = gTotal;
      hPos[i] = hTotal;
    }
    // System.out.println(Arrays.toString(gPos));
    // System.out.println(Arrays.toString(hPos));
    ArrayList<Integer> gAll = new ArrayList<>();
    ArrayList<Integer> hAll = new ArrayList<>();
    TreeSet<Integer> gAllS = new TreeSet<>();
    TreeSet<Integer> hAllS = new TreeSet<>();

    for(int i = 0; i<n; i++){
      int end = e[i];
      if(breed[i] == 'G'){
        int total = gPos[end]-gPos[i]+1;
        if(total == gTotal){
          gAll.add(i);
          gAllS.add(i);
        }
      }
      else if(breed[i] == 'H'){
        int total = hPos[end]-hPos[i]+1;
        if(total == hTotal){
          hAll.add(i);
          hAllS.add(i);
        }
      }
    }

    int result = gAllS.size() * hAllS.size();

    // System.out.println(result);
    //
    // System.out.println(gAll);
    // System.out.println(hAll);

    for(int i = 0; i<n; i++){
      int end = e[i];
      if(breed[i] == 'G' && !gAllS.contains(i)){
        Integer first = hAllS.ceiling(i);
        Integer last = hAllS.floor(end);
        // System.out.println(first);
        // System.out.println(last);
        if(first == null || last == null) continue;
        int firstInd = Collections.binarySearch(hAll, first);
        int lastInd = Collections.binarySearch(hAll, last);
        // System.out.println(firstInd);
        // System.out.println(lastInd);
        result += (lastInd-firstInd+1);
      }
      else if(breed[i] == 'H' && !hAllS.contains(i)){
        Integer first = gAllS.ceiling(i);
        Integer last = gAllS.floor(end);
        // System.out.println(first);
        // System.out.println(last);
        if(first == null || last == null) continue;
        int firstInd = Collections.binarySearch(gAll, first);
        int lastInd = Collections.binarySearch(gAll, last);
        // System.out.println(firstInd);
        // System.out.println(lastInd);
        result += (lastInd-firstInd+1);
      }
      // System.out.println("===");
    }

    System.out.println(result);
  }
}