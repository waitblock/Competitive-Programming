import java.util.*;
import java.io.*;

public class lifeguards {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new File("lifeguards.in"));
    int n = in.nextInt();
    ArrayList<Integer> unsortedStartingTime = new ArrayList<>();
    ArrayList<Integer> unsortedEndingTime = new ArrayList<>();
    for(int i = 0; i<n; i++){
      unsortedStartingTime.add(in.nextInt());
      unsortedEndingTime.add(in.nextInt());
    }
    in.close();
    // System.out.println(unsortedStartingTime);
    // System.out.println(unsortedEndingTime);
    ArrayList<Integer> startingTime = new ArrayList<>();
    startingTime.addAll(unsortedStartingTime);
    Collections.sort(startingTime);
    ArrayList<Integer> endingTime = new ArrayList<>();
    for(int i : startingTime){
      endingTime.add(unsortedEndingTime.get(unsortedStartingTime.indexOf((Integer) i)));
    }
    // System.out.println(startingTime);
    // System.out.println(endingTime);
    // System.out.println(timeCovered(startingTime, endingTime));
    int result = -Integer.MAX_VALUE;
    ArrayList<Integer> tempStart = new ArrayList<>();
    ArrayList<Integer> tempEnd = new ArrayList<>();
    for(int i = 0; i<startingTime.size(); i++){
      // System.out.println(i);
      // System.out.println("------");
      tempStart.addAll(startingTime);
      tempEnd.addAll(endingTime);
      tempStart.remove((int) i);
      tempEnd.remove((int) i);
      int temp = timeCovered(tempStart, tempEnd);
      // System.out.println(temp);
      result = Math.max(result, temp);
      tempStart.clear();
      tempEnd.clear();
    }
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("lifeguards.out"));
    out.println(result);
    out.close();
  }

  static int timeCovered(ArrayList<Integer> start, ArrayList<Integer> end){
    int covered = 0;
    int lastEnd = 0;
    for(int i = 0; i<start.size(); i++){
      // System.out.println(start.get(i));
      // System.out.println(end.get(i));
      if(start.get(i) >= lastEnd){
        covered += (end.get(i)-start.get(i));
        // System.out.println(end.get(i)-start.get(i));
      }
      else if(start.get(i) < lastEnd){
        covered += (end.get(i)-lastEnd);
        // System.out.println(end.get(i)-lastEnd);
      }
      // System.out.println("...");
      lastEnd = end.get(i);
    }
    return covered;
  }
}