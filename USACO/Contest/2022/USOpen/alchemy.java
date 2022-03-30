 import java.util.*;

public class alchemy {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] metals = new int[n];
    for(int i = 0; i<n; i++){
      metals[i] = in.nextInt();
    }
    int k = in.nextInt();
    HashMap<Integer, ArrayList<Integer>> recipes = new HashMap<>();

    for(int i = 0; i<k; i++){
      int l = in.nextInt();
      int m = in.nextInt();
      ArrayList<Integer> temp = new ArrayList<>();
      for(int j = 0; j<m; j++){
        temp.add(in.nextInt());
      }
      recipes.put(l, temp);
    }
    // System.out.println(recipes);
    ArrayList<Integer> recipeLookup = new ArrayList<>(recipes.keySet());
    Collections.reverse(recipeLookup);
    // System.out.println(recipeLookup);
    while(true){
      boolean recipeUsed = false;
      for(int recipe : recipeLookup){
        boolean enoughMetal = true;
        ArrayList<Integer> metalsNeeded = recipes.get(recipe);
        for(int i = 0; i<metalsNeeded.size(); i++){
          int metal = metalsNeeded.get(i);
          if(metals[metal-1] == 0){
            enoughMetal = false;
          }
        }
        if(enoughMetal == true){
          for(int metal : metalsNeeded){
            metals[metal-1]--;
          }
          metals[recipe-1]++;
          recipeUsed = true;
          break;
        }
      }
      if(recipeUsed == false){
        break;
      }
    }
    // System.out.println(Arrays.toString(metals));
    System.out.println(metals[n-1]);
  }
}