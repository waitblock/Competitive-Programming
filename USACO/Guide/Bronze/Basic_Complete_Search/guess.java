import java.util.*;
import java.io.*;

public class guess {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("guess.in"));
    // parallel arraylists
    ArrayList<String> animals = new ArrayList<>();
    ArrayList<ArrayList<String>> attributes = new ArrayList<>();
    // ArrayList<String> attrs = new ArrayList<>();

    int n = in.nextInt();

    for(int i = 0; i<n; i++){
      String animal = in.next();
      int k = in.nextInt();
      ArrayList<String> attr = new ArrayList<>();
      for(int j = 0; j<k; j++){
        String a = in.next();
        attr.add(a);
        // if(!attrs.contains(a)) attrs.add(a);
      }
      animals.add(animal);
      attributes.add(attr);
    }
    in.close();

    System.out.println(animals);
    System.out.println(attributes);

    int result = 0;

    for(int i = 0; i<n-1; i++){
      for(int j = i+1; j<n; j++){
        result = Math.max(countSimilar(i, j, attributes), result);
      }
    }

    result++;

    System.out.println(result);

    PrintWriter out = new PrintWriter(new File("guess.out"));
    out.println(result);
    out.close();
  }

  static int countSimilar(int a1, int a2, ArrayList<ArrayList<String>> attributes){
    int count = 0;
    ArrayList<String> al1 = attributes.get(a1);
    ArrayList<String> al2 = attributes.get(a2);
    for(int i = 0; i<al1.size(); i++){
      if(al2.contains(al1.get(i))){
        count++;
      }
    }
    return count;
  }

  // static HashMap<String, Integer> generateFrequency(ArrayList<ArrayList<String>> attributes){
  //   HashMap<String, Integer> freq = new HashMap<>();
  //
  //   for(ArrayList<String> list : attributes){
  //     for(int i = 0; i<list.size(); i++){
  //       int c = 1;
  //       String a = list.get(i);
  //       if(freq.keySet().contains(a)){
  //         c += freq.get(a);
  //       }
  //       freq.put(a, c);
  //     }
  //   }
  //
  //   return freq;
  // }
}