import java.util.*;
import java.io.*;

public final class A {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = in.nextInt();
    if(n<=0){
      System.out.println("BIKE");
    }
    else System.out.println("WALK");

  }
}