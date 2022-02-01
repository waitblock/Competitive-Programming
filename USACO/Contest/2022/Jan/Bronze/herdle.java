import java.util.*;

public class herdle {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    char[][] correct = new char[3][3];
    char[][] guess = new char[3][3];

    for(int i = 0; i<3; i++){
      correct[i] = in.nextLine().toCharArray();
    }
    for(int i = 0; i<3; i++){
      guess[i] = in.nextLine().toCharArray();
    }

    HashMap<Character, Integer> available = new HashMap<>();

    for(int i = 0; i<3; i++){
      for(int j = 0; j<3; j++){
        char c = correct[i][j];
        int count = 0;
        if(available.containsKey(c)) count = available.get(c);
        count++;
        available.put(c, count);
      }
    }

    // System.out.println(available);

    int green = 0;

    for(int i = 0; i<3; i++){
      for(int j = 0; j<3; j++){
        if(correct[i][j] == guess[i][j]){
          green++;
          int temp = available.get(correct[i][j]);
          available.put(correct[i][j], temp-1);
        }
      }
    }
    // System.out.println(available);

    int yellow = 0;

    for(int i = 0; i<3; i++){
      for(int j = 0; j<3; j++){
        if(available.containsKey(guess[i][j]) && guess[i][j] != correct[i][j]){
          if(available.get(guess[i][j]) > 0){
            yellow++;
            int temp = available.get(guess[i][j]);
            available.put(guess[i][j], temp-1);
          }
        }
      }
    }
    // System.out.println(available);
    System.out.println(green);
    System.out.println(yellow);
  }
}