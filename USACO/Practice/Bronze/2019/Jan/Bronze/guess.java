import java.util.*;
import java.io.*;

public class guess {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("guess.in"));
        Map<String, String[]> charMap = new HashMap<>();
        ArrayList<String> animals = new ArrayList<>();
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
          animals.add(animal);
        }
        // System.out.println(countSimilarChar(charMap, "sheep", "cow"));
        int result = -(Integer.MAX_VALUE);
        for(int i = 0; i<charMap.size(); i++){
            for(int j = i+1; j<charMap.size(); j++){
                result=Math.max(result, countSimilarChar(charMap,animals.get(i), animals.get(j)));
                // System.out.println(i);
                // System.out.println(j);
                // System.out.println(result);
                // System.out.println("..");
            }
        }
        result++;
        System.out.println(result);
        PrintWriter out = new PrintWriter(new File("guess.out"));
        out.println(result);
        out.close();
    }

  static int countSimilarChar(Map<String, String[]> charMap, String animal1, String animal2){
    String[] animal1Arr = charMap.get(animal1);
    String[] animal2Arr = charMap.get(animal2);
    int count = 0;
    for(int i = 0; i<animal1Arr.length; i++){
        for(int j = 0; j<animal2Arr.length; j++){
            if(animal2Arr[j].equals(animal1Arr[i])) count++;
        }
    }
    return count;
  }
}