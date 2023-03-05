import java.util.*;

public final class lucky {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayDeque<Integer> circle = new ArrayDeque<>();
		for(int i = 1; i<=n; i++){
			circle.add(i);
		}
		for(int i=0; i<n-1; i++){
			int temp = in.nextInt();
			if(i != 0) temp -= 1;
			temp %= circle.size();
			// System.out.println(temp);
			for(int j = 0; j<temp; j++){
				circle.add(circle.pop());
			}
			circle.remove();
			// System.out.println(circle);
		}
		System.out.println(circle.pop());
	}
}