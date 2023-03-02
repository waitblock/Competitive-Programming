import java.util.*;
import java.io.*;

public class lifeguards {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("lifeguards.in"));
    int n = in.nextInt();
    ArrayList<Integer> start = new ArrayList<>();
    ArrayList<Integer> end = new ArrayList<>();
    for(int i = 0; i<n; i++){
      start.add(in.nextInt());
      end.add(in.nextInt());
    }
    ArrayList<Integer> sortedStart = new ArrayList<>(start);
    ArrayList<Integer> sortedEnd = new ArrayList<>();

    Collections.sort(sortedStart);
    for(int i = 0; i<sortedStart.size(); i++){
      sortedEnd.add(end.get(start.indexOf(sortedStart.get(i))));
    }

    // System.out.println(start);
    // System.out.println(end);
    // System.out.println(sortedStart);
    // System.out.println(sortedEnd);

    int result = 0;

    for(int i = 0; i<n; i++){
      ArrayList<Integer> newStart = new ArrayList<>();
      ArrayList<Integer> newEnd = new ArrayList<>();
      for(int j = 0; j<n; j++){
        if(j == i) continue;
        newStart.add(sortedStart.get(j));
      }
      for(int j = 0; j<n; j++){
        if(j == i) continue;
        newEnd.add(sortedEnd.get(j));
      }
      result = Math.max(timeCovered(newStart, newEnd), result);
      // System.out.println("****");
      // System.out.println(timeCovered(newStart, newEnd));
      // System.out.println("****");
    }
    System.out.println(result);
    PrintWriter out = new PrintWriter(new File("lifeguards.out"));
    out.println(result);
    out.close();
  }

  static int timeCovered(ArrayList<Integer> start, ArrayList<Integer> end){
    int total = 0;
    int lastEnd = 0;
    // System.out.println(start);
    // System.out.println(end);
    for(int i = 0; i<start.size(); i++){
      // System.out.println(start.get(i));
      // System.out.println(end.get(i));
      if(start.get(i) < lastEnd){
        total += (end.get(i) - lastEnd);
        // System.out.println(end.get(i) - lastEnd);
      }
      else if(start.get(i) >= lastEnd){
        total += (end.get(i) - start.get(i));
        // System.out.println(end.get(i) - start.get(i));
      }
      lastEnd = end.get(i);
      // System.out.println("--");
    }
    return total;
  }
}