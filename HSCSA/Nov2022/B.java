import java.util.*;
import java.io.*;

public final class B{
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String blank = ".......";
    String nonBlank = ".XXXXX.";
    for(int i = 0; i<n; i++){
      System.out.println(blank);
      System.out.println(nonBlank);
    }
    System.out.println(blank);
  }
}