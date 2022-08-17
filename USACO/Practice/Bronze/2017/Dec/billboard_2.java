import java.util.*;
import java.io.*;

public class billboard_2{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new File("billboard.in"));
    Rectangle b1 = new Rectangle();
    Rectangle b2 = new Rectangle();
    Rectangle truck = new Rectangle();

    b1.x1 = in.nextInt();
    b1.y1 = in.nextInt();
    b1.x2 = in.nextInt();
    b1.y2 = in.nextInt();

    b2.x1 = in.nextInt();
    b2.y1 = in.nextInt();
    b2.x2 = in.nextInt();
    b2.y2 = in.nextInt();

    truck.x1 = in.nextInt();
    truck.y1 = in.nextInt();
    truck.x2 = in.nextInt();
    truck.y2 = in.nextInt();

    in.close();

    PrintWriter out = new PrintWriter(new File("billboard.out"));
    int result = b1.area() + b2.area() - intersect(b1, truck) - intersect(b2, truck);
    System.out.println(result);
    out.println(result);
    out.close();
  }

  static int intersect(Rectangle p, Rectangle q) {
		int xOverlap = Math.max(0, Math.min(p.x2, q.x2) - Math.max(p.x1, q.x1));
		int yOverlap = Math.max(0, Math.min(p.y2, q.y2) - Math.max(p.y1, q.y1));
		return xOverlap * yOverlap;
	}

}

class Rectangle {
  int x1;
  int x2;
  int y1;
  int y2;

  int area() {
    return (y2-y1) * (x2-x1);
  }
}
