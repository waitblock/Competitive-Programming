import java.util.*;

public final class cowntagion {
	static ArrayList<HashSet<Integer>> adj = new ArrayList<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i<n; i++){
			adj.add(new HashSet<Integer>());
		}
		for(int i = 0; i<n-1; i++){
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		System.out.println(solve(0,-1));
	}

	static int solve(int node, int parent){
		int result = 0; 
		int cows = adj.get(node).size();
		if(parent == -1){
			cows++;
		}

		int cowsF = 1;
		int days = 0;

		while(cowsF < cows){
			days++;
			cowsF *= 2;
		}

		result += days;

		for(int i : adj.get(node)){
			if(i != parent){
				result += (solve(i, node) + 1);
			}
		}

		return result;
	}
}