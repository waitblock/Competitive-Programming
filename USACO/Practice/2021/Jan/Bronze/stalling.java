// works for 1-5 (n<=8)

import java.util.*;

public class stalling {
  static int counter = 0;

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    ArrayList<Integer> cows = new ArrayList<>();
    ArrayList<Integer> stalls = new ArrayList<>();

    for(int i = 0; i<n; i++){
      cows.add(in.nextInt());
    }
    for(int i = 0; i<n; i++){
      stalls.add(in.nextInt());
    }
    in.close();
    findCombo(cows, stalls);
    System.out.println(counter);
  }

  static void findCombo(ArrayList<Integer> cowsLeft, ArrayList<Integer> stallsLeft){
    ArrayList<Integer> tempCow = new ArrayList<Integer>();
    ArrayList<Integer> tempStall = new ArrayList<Integer>();
    for(int i = 0; i<cowsLeft.size(); i++){
      tempCow.add(cowsLeft.get(i));
    }
    for(int i = 0; i<cowsLeft.size(); i++){
      tempStall.add(stallsLeft.get(i));
    }
    int focus = Collections.max(tempCow);
    if(cowsLeft.size() == 1 && cowsLeft.get(0) <= stallsLeft.get(0)){
      counter++;
      return;
    }
    boolean foundWorking = false;
    for(int i = 0; i<tempStall.size(); i++){
      if(tempStall.get(i) >= focus){
        tempStall.remove(i);
        tempCow.remove((Integer) focus);
        findCombo(tempCow, tempStall);
        tempCow.clear();
        tempStall.clear();
        for(int j = 0; j<cowsLeft.size(); j++){
          tempCow.add(cowsLeft.get(j));
        }
        for(int j = 0; j<cowsLeft.size(); j++){
          tempStall.add(stallsLeft.get(j));
        }
        foundWorking = true;
      }
    }
    if(!foundWorking){
      return;
    }
  }
}