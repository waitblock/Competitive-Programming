import java.util.*;

public class whitesheet_v2 {
 	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Rect A = new Rect(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		Rect B = new Rect(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		Rect C = new Rect(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());

		A = cut(A, B);
		A = cut(A, C);

    if(A.area() == 0){
      System.out.println("NO");
    }
    else{
      System.out.println("YES");
    }
  }

	static class Rect {
		public int x1, y1, x2, y2;
		public Rect(int a, int b, int c, int d) {
			x1 = a;
			y1 = b;
			x2 = c;
			y2 = d;
		}

		public int area() {
			return (x2 - x1) * (y2 - y1);
		}
	}

	static Rect cut(Rect A, Rect B) {

		// If B cuts A from the left side
		if (A.x1 >= B.x1 && B.x2 >= A.x1 && B.y1 <= A.y1 && B.y2 >= A.y2) {
			A.x1 = B.x2;
			A.x2 = Math.max(A.x2, B.x2);  // If B covers A entirely
		}

		// If B cuts A from the right side
		if (A.x2 >= B.x1 && B.x2 >= A.x2 && B.y1 <= A.y1 && B.y2 >= A.y2) {
			A.x2 = B.x1;
			A.x1 = Math.min(A.x1, B.x1);  // If B covers A entirely
		}

		// If B cuts A from the bottom side
		if (A.y1 >= B.y1 && B.y2 >= A.y1 && B.x1 <= A.x1 && B.x2 >= A.x2) {
			A.y1 = B.y2;
			A.y2 = Math.max(A.y2, B.y2);  // If B covers A entirely
		}

		// If B cuts A from the top side
		if (A.y2 >= B.y1 && B.y2 >= A.y2 && B.x1 <= A.x1 && B.x2 >= A.x2) {
			A.y2 = B.y1;
			A.y1 = Math.min(A.y1, B.y1);  // If B covers A entirely
		}
		return A;
	}
}