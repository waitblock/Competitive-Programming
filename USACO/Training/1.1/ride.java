// This template code suggested by KT BYTE Computer Science Academy
//   for use in reading and writing files for USACO problems.

// https://content.ktbyte.com/problem.java

/*
ID: xuethan1
LANG: JAVA
TASK: ride
*/

import java.util.*;
import java.io.*;

public class ride {
  public static void main(String[] args) throws FileNotFoundException {
    char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();



    Scanner in = new Scanner(new File("ride.in"));
    ArrayList<String> lines = new ArrayList<String>();
    while(in.hasNextLine()){
      lines.add(in.nextLine());
    }
    in.close();

    char[] line1 = lines.get(0).toCharArray();
    char[] line2 = lines.get(1).toCharArray();

    int line1_total = 1;
    int line2_total = 1;

    // System.out.println("=========");

    for(int i = 0; i<line1.length; i++){
      // System.out.println(find_letter(line1[i], alphabet));
      line1_total *= find_letter(line1[i], alphabet);
    }
    // System.out.println("=========");

    for(int i = 0; i<line2.length; i++){
      // System.out.println(find_letter(line2[i], alphabet));
      line2_total *= find_letter(line2[i], alphabet);
    }

    // System.out.println("totals: ");
    // System.out.println(line1_total);
    // System.out.println(line2_total);

    PrintWriter out = new PrintWriter(new File("ride.out"));

    if(line1_total % 47 == line2_total % 47){
      out.println("GO");
    }
    else{
      out.println("STAY");
    }

    out.close();
  }

  static int find_letter(char l, char[] alpha){
    for (int i = 0; i<alpha.length; i++){
      if(alpha[i] == l){
        return i+1;
      }
    }
    return -1;
  }
}
