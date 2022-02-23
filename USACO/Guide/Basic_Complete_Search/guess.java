// INCOMPLETE

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

    while(true){

    }

    System.out.println(result);

    PrintWriter out = new PrintWriter(new File("guess.out"));
    out.println(result);
    out.close();
  }

  static HashMap<String, Integer> generateFrequency(ArrayList<ArrayList<String>> attributes){
    HashMap<String, Integer> freq = new HashMap<>();

    for(ArrayList<String> list : attributes){
      for(int i = 0; i<list.size(); i++){
        int c = 1;
        String a = list.get(i);
        if(freq.keySet().contains(a)){
          c += freq.get(a);
        }
        freq.put(a, c);
      }
    }

    return freq;
  }
}