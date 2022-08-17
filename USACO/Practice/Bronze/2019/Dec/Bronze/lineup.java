// TODO: Unfinished

import java.util.*;
import java.io.*;

public class lineup {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("lineup.in"));
    int n = in.nextInt();

    Map<String, String> beside = new HashMap<>();
    for(int i = 0; i<n; i++){
      // X  must be milked beside Y
      String x = in.next();
      for(int j = 0; j<4; j++) in.next();
      String y = in.next();
      beside.put(x, y);
    }
    System.out.println(beside);

    ArrayList<ArrayList<String>> groups = new ArrayList<>();

    for(Map.Entry<String, String> en : beside.entrySet()){
      String x = en.getKey();
      String y = en.getValue();
      int indX = listContains(groups, x);
      int indY = listContains(groups, y);
      if(indX != -1){
        ArrayList<String> temp = groups.get(indX);
        temp.add(y);
        groups.add(temp);
        continue;
      }
      if(indY != -1){
        ArrayList<String> temp = groups.get(indY);
        temp.add(x);
        groups.add(temp);
        continue;
      }
      if(indX == -1 && indY == -1){
        ArrayList<String> temp = new ArrayList<String>();
        temp.add(x);
        temp.add(y);
        groups.add(temp);
      }
    }

    groups = prepareArrList(groups);

    System.out.println(groups);

    PrintWriter out = new PrintWriter(new File("lineup.out"));
    out.close();
  }

  static int listContains(ArrayList<ArrayList<String>> groups, String k){
    for(int i = 0; i<groups.size(); i++){
      ArrayList<String> current = groups.get(i);
      for(int j = 0; j<current.size(); j++){
        if(current.get(j).equals(k)){
          return i; // return the index of which the element is at
        }
      }
    }
    return -1; // did not find element
  }

  static ArrayList<ArrayList<String>> prepareArrList(ArrayList<ArrayList<String>> arrlist){
    ArrayList<ArrayList<String>> temp = new ArrayList<>();
    for(int i = 0; i<arrlist.size(); i++){
      if(temp.contains(arrlist.get(i))) continue;
      temp.add(arrlist.get(i));
    }
    for(int i = 0; i<temp.size(); i++){
      if(temp.get(i).size() == 2){
        Collections.sort(temp.get(i));
      }
    }
    return temp;
  }
}