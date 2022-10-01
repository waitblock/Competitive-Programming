import java.util.*;
import java.io.*;

public final class fairphoto {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("fairphoto.in"));
    int n = in.nextInt();
    ArrayList<Cow> cows = new ArrayList<>();
    HashMap<Cow, Integer> cowIndex = new HashMap<>();
    for(int i = 0; i<n; i++){
      int pos = in.nextInt();
      String breed = in.next();
      Cow c = new Cow(pos, breed);
      cows.add(c);
      cowIndex.put(c,i);
    }
    in.close();
    Collections.sort(cows);
    HashMap<Integer,Pair> match = new HashMap<>();
    int sum = 0;
    for(int i = 0; i<n; i++){
      sum += cows.get(i).breed == 'G' ? 1 : -1;
      System.out.println(sum);
      Pair p = match.get(sum);
      if(p == null){
        match.put(sum, new Pair(cows.get(i), null));
      }
      else{
        match.put(sum, new Pair(p.c1, cows.get(i)));
      }
    }
    int result = 0;
    for(int i : match.keySet()){
      Pair p = match.get(i);
      Cow left = p.c1;
      if(cowIndex.get(p.c1) < n-1){
        left = cows.get(cowIndex.get(p.c1)+1);
      }
      Cow right = p.c2;
      int size;
      if(right == null){
        size = 0;
      }
      else{
        size = right.x-left.x;
        System.out.println(right.x);
        System.out.println(left.x);
        System.out.println(".");
      }
      result = Math.max(result, size);
    }
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("fairphoto.out"));
    out.println(result);
    out.close();
  }
  static class Cow implements Comparable<Cow> {
    char breed;
    int x;

    Cow(int x, String breed) {
      this.x = x;
      this.breed = breed.charAt(0);
    }

    public int compareTo(Cow other) {
      return this.x - other.x;
    }
  }

  static class Pair {
    Cow c1; // leftmost
    Cow c2; // rightmost
    Pair(Cow c1, Cow c2){
      this.c1=c1;
      this.c2=c2;
    }
  }
}

// G H G G H G
// 1 0 1 2 1 2
//           ^

// store sum = 1 --> G0   (map)   match w/ H4
// store sum = 0 --> H1
// store sum = 2 --> G3          match w/ G5

// number of H = number of G
// psum[right] = psum[left-1]
// use a map to keep track of leftmost unique sum