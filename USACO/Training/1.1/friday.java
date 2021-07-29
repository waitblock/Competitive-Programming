// This template code suggested by KT BYTE Computer Science Academy
//   for use in reading and writing files for USACO problems.

// https://content.ktbyte.com/problem.java

/*
ID: xuethan1
LANG: JAVA
TASK: friday
*/

//Thirty days has September, April, June, and November, all the rest have 31
//except for February which has 28 except in leap years when it has 29.

import java.util.*;
import java.io.*;

public class friday {
  public static void main(String[] args) throws FileNotFoundException {
    int[] thirteen_count = new int[7];
    Scanner in = new Scanner(new File("friday.in"));
    ArrayList<String> lines = new ArrayList<String>();
    while(in.hasNextLine()){
      lines.add(in.nextLine());
    }
    in.close();

    System.out.println(lines);

    int N = Integer.valueOf(lines.get(0));

    int end_year = 1900 + N - 1;

    int count = 0;

    for(int i = 0; i<end_year-1900+1; i++){
      for(int j = 0; j<12; j++){
        for(int k = 0; k<getDays(j, i); k++){
          if(k == 12){
            System.out.println("thirteenth");
            System.out.println(count%7);
            thirteen_count[count%7] += 1;
          }
          count++;
        }
      }
    }

    System.out.println(Arrays.toString(thirteen_count));


    PrintWriter out = new PrintWriter(new File("friday.out"));
    for(int i = 0; i<thirteen_count.length; i++){
      if(i == thirteen_count.length-1){
        out.println(Integer.toString(thirteen_count[i]));
      }
      else{
        out.print(Integer.toString(thirteen_count[i]) + " ");
      }
    }
    // out.println(result);
    out.close();
  }

  static int getDays(int month, int year){
    int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    if(month == 1){
      if(leap(year)){
        return 29;
      }
    }
    return days[month];
  }

  static boolean leap(int year){
    if(year % 100 == 0){
      return year % 400 == 0;
    }
    return year % 4 == 0;
  }
}
