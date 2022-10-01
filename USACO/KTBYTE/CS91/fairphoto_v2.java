import java.util.*;
import java.io.*;

public final class fairphoto_v2 {
  // public static void main(String[] args) throws FileNotFoundException {
  public static void main(String[] args) throws IOException {
    // Scanner in = new Scanner(new File("fairphoto.in"));
    BufferedReader br = new BufferedReader(new FileReader("fairphoto.in"));
    int n = Integer.parseInt(br.readLine());
    Cow[] cows = new Cow[n];
    for(int i = 0; i<n; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      cows[i] = new Cow(Integer.parseInt(st.nextToken()), st.nextToken());
    }
    Arrays.sort(cows);
    br.close();
    int[] prefix = new int[n+1];
    int sum = 0;
    for(int i = 1; i<n+1; i++){
      sum += cows[i-1].breed == 'G' ? 1 : -1;
      prefix[i] = sum;
    }
    System.out.println(Arrays.toString(prefix));
    HashMap<Integer, Integer> match = new HashMap<>();
    int result = Integer.MIN_VALUE;
    for(int i = 1; i<n+1; i++){
      if(prefix[i] == 0){
        result = Math.max(cows[i-1].x, result);
        continue;
      }
      if(match.containsKey(prefix[i])){
        int left = match.get(prefix[i]);
        result = Math.max(cows[i-1].x-cows[left].x, result);
      }
      else{
        match.put(prefix[i],i);
      }
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
}