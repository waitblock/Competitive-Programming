import java.util.*;

public final class D {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int a,b,c,d;
    a = in.nextInt(); b = in.nextInt(); c = in.nextInt(); d = in.nextInt();
    int u,v,w;
    u = in.nextInt(); v = in.nextInt(); w = in.nextInt();
    int a_ = 1-a;
    int b_ = -(u+v+w)-b;
    int c_ = (u*w+u*v+v*w)-c;
    int d_ = -(u*v*w)-d;
    System.out.print(a_); System.out.print(" ");
    System.out.print(b_); System.out.print(" ");
    System.out.print(c_); System.out.print(" ");
    System.out.println(d_);
  }
}