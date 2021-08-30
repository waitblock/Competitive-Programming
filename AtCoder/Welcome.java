import java.util.*;

public class Welcome {
  public static void main(String [] args){
    Scanner in = new Scanner(System.in);
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    String s = in.next();
    System.out.println(String.valueOf(a+b+c) + " " + s);
  }
}
