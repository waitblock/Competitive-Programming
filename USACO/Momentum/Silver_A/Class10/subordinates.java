import java.util.*;

public final class subordinates {
	static ArrayList<HashSet<Integer>> adj = new ArrayList<>();
	static int[] result;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		result = new int[n];
		for(int i = 0; i<n; i++){
			adj.add(new HashSet<Integer>());
		}
		for(int i = 1; i<n; i++){
			int boss = in.nextInt();
			adj.get(boss-1).add(i);
		}
		in.close();
		// System.out.println(adj);
		solve(0);
		for(int i : result){
			System.out.print(i-1);
			System.out.print(" ");
		}
		System.out.println();

	}

	static void solve(int node){
		result[node] = 1;
		// System.out.println(Arrays.toString(result));
		for(int i : adj.get(node)){
			solve(i);
			result[node] += result[i];
		}

	}
}