// time taken: 38 min 12 sec

import java.util.*;
import java.io.*;

public class shuffle {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("shuffle.in"));
    int n = in.nextInt();
    int[] shuffle = new int[n];
    for(int i = 0; i<n; i++){
      shuffle[i] = in.nextInt();
    }
    int[] reverse_shuffle = new int[n];
    for(int i = 0; i<n; i++){
      reverse_shuffle[shuffle[i]-1] = i;
    }
    System.out.println(Arrays.toString(reverse_shuffle));
    int[] shuffled = new int[n];
    for(int i = 0; i<n; i++){
      shuffled[i] = Integer.parseInt(in.next());
    }
    in.close();
    int[] temp = new int[n];
    for(int i = 0; i<3; i++){
      fill(temp, shuffled);
      for(int j = 0; j<n; j++){
        temp[reverse_shuffle[j]] = shuffled[j];
      }
      fill(shuffled,temp);
    }
    PrintWriter out = new PrintWriter(new File("shuffle.out"));
    for(int i = 0; i<n; i++){
      System.out.println(shuffled[i]);
      out.println(shuffled[i]);
    }
    out.close();
  }

  static void swap(int a, int b, int[] shuffled){
    int temp = shuffled[a];
    shuffled[a] = shuffled[b];
    shuffled[b] = temp;
  }

  static void fill(int[] arr1, int[] arr2){ // fill arr1 with arr2
    for(int i = 0; i<arr1.length; i++){
      arr1[i] = arr2[i];
    }
  }
}