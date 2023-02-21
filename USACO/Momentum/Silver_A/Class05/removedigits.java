import java.util.*;

public final class removedigits {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		String numS = in.next();
		int[] num = new int[n];
		for(int i = 0; i<n; i++){
			num[i] = Integer.parseInt(numS.substring(i,i+1));
		}
		// System.out.println(Arrays.toString(num));
		Stack<Integer> s = new Stack<>();
		s.push(num[0]);
		for(int i = 1; i<n; i++){
			// System.out.println(s);
			while(k != 0 && !s.isEmpty() && s.peek() < num[i]){
				s.pop();
				// System.out.println(s);
				k--;
			}
			s.push(num[i]);
		}
		Stack<Integer> result = new Stack<>();
		while(!s.isEmpty()){
			result.push(s.pop());
		}
		while(!result.isEmpty()){
			System.out.print(result.pop());
		}
		System.out.print("\n");
	}
}