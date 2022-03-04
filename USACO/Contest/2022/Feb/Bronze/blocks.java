import java.util.*;

public class blocks {
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
        // System.out.println(used);
        boolean possible = false;
        outer: for(int j = 0; j<4; j++){
          if(used.contains(j)) continue;
          // if(Arrays.asList(dice[j]).contains(c)){
          //   used.add(j);
          //   possible = true;
          //   break;
          // }
          for(int k = 0; k<6; k++){
            if(dice[j][k] == c){
              used.add(j);
              possible = true;
              break outer;
            }
          }
        }
        if(possible == false){
          System.out.println("NO");
          valid = false;
          break;
        }
      }
      if(valid == true){
        System.out.println("YES");
      }
    }
  }
}