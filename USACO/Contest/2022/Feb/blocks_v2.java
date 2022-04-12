import java.util.*;

public class blocks_v2 {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    char[][] dice = new char[4][6];

    in.nextLine();

    for(int i = 0; i<4; i++){
      dice[i] = in.nextLine().toCharArray();
    }

    // for(char[] arr : dice) System.out.println(Arrays.toString(arr));

    for(int i = 0; i<n; i++){
      boolean valid = true;
      ArrayList<Integer> used = new ArrayList<>();
      char[] word = in.nextLine().toCharArray();
      for(char c : word){
        ArrayList<Integer> usable = new ArrayList<Integer>();
        // System.out.println(used);
        for(int j = 0; j<4; j++){
          if(used.contains(j)) continue;
          for(int k = 0; k<6; k++){
            if(dice[j][k] == c){
              usable.add(j);
              break;
            }
          }
        }
        // System.out.println(usable);
        if(usable.size() == 0){
          System.out.println("NO");
          valid = false;
          break;
        }
        if(usable.size() == 1){
          used.add(usable.get(0));
        }
        if(usable.size() >= 2){
          HashMap<Integer, Integer> duplicates = new HashMap<>();
          for(int j = 0; j<usable.size(); j++){
            duplicates.put(usable.get(j), 0);
          }
          // usable_index, number of other characters present in the dice that are also present in the word
          for(int j = 0; j<word.length; j++){
            if(word[j] == c) continue;
            for(int k = 0; k<usable.size(); k++){
              if(contains(dice[usable.get(k)], word[j])){
                duplicates.put(k, duplicates.get(k)+1);
              }
            }
          }
          // System.out.println(duplicates);
          int min_usable = 0;
          int minimum_value = Integer.MAX_VALUE;
          for(int j = 0; j<usable.size(); j++){
            int u_val = usable.get(j);
            int val = duplicates.get(u_val);
            if(val < minimum_value){
              minimum_value = val;
              min_usable = u_val;
            }
          }
          // System.out.println(minimum_value);
          // System.out.println(min_usable);
          used.add(min_usable);
        }
      }
      // System.out.println(used);
      if(valid){
        System.out.println("YES");
      }
    }
  }

  static boolean contains(char[] arr, char c){
    for(int i = 0; i<arr.length; i++){
      if(arr[i] == c){
        return true;
      }
    }
    return false;
  }
}