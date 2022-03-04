import java.util.*;

public class weird {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    long n = in.nextLong();
    System.out.print(String.valueOf(n)+" ");
    while(n>1){
      if(n%2 != 0){
        n = n*3+1;
        System.out.print(String.valueOf(n)+" ");
      }
      else{
        n/=2;
        System.out.print(String.valueOf(n)+" ");
      }
    }
  }
}