// TODO: Unfinished

import java.util.*;
import java.io.*;

public class guess {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("guess.in"));
    Map<String, String[]> charMap = new HashMap<>();
    ArrayList<String> chara = new ArrayList<>();
    ArrayList<Integer> freq = new ArrayList<>();
    // Map<String, Integer> frequency = new HashMap<>();
    int n = in.nextInt();
    for(int i = 0; i<n; i++){
      String animal = in.next();
      int charCount = in.nextInt();
      String[] animalChars = new String[charCount];
      for(int j = 0; j<charCount; j++){
        animalChars[j] = in.next();
      }
      // System.out.println(Arrays.toString(animalChars));
      charMap.put(animal, animalChars);
    }
    ArrayList<String> onceChars = new ArrayList<>();
    ArrayList<String> allChars = new ArrayList<>();
    ArrayList<String[]> charsList = new ArrayList<>(charMap.values());
    for(int i = 0; i<charsList.size(); i++){
      String[] temp = charsList.get(i);
      // System.out.println(Arrays.toString(temp));
      for(int j = 0; j<temp.length; j++){
        allChars.add(temp[j]);
        if(onceChars.contains(temp[j])) continue;
        onceChars.add(temp[j]);
      }
    }
    System.out.println(onceChars);
    System.out.println(allChars);
    for(int i = 0; i<onceChars.size(); i++){
      System.out.println(i);
      String ch = onceChars.get(i);
      int count = 0;
      for(int j = 0; j<allChars.size(); j++){
        if(allChars.get(j).equals(ch)){
          count++;
        }
      }
      chara.add(ch);
      freq.add(count);
    }
    System.out.println(chara);
    System.out.println(freq)
    while(true){

    }
  }

  static boolean check(ArrayList<Integer> freqs){

  }
}