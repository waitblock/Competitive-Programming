import java.util.*;
import java.io.*;

public final class moocast {
	static ArrayList<HashSet<Integer>> adj = new ArrayList<>(); // neighbors are which cows the cow can broadcast to
	static boolean[] visited;
	static int result = -1;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("moocast.in"));
		int n = in.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		int[] p = new int[n];
		for(int i = 0; i<n; i++){
			x[i] = in.nextInt();
			y[i] = in.nextInt();
			p[i] = in.nextInt();
		}
		in.close();
		for(int i = 0; i<n; i++){
			adj.add(new HashSet<Integer>());
		}
		for(int i = 0; i<n; i++){
			for(int j = i+1; j<n; j++){
				int v = x[i]-x[j];
				int h = y[i]-y[j];
				int dist =  v*v+h*h;
				if(dist <= p[i]*p[i]){
					adj.get(i).add(j);
				}
				if(dist <= p[j]*p[j]){
					adj.get(j).add(i);
				}
			}
		}
		// System.out.println(adj);
		for(int i = 0; i<n; i++){
			visited = new boolean[n];
			result = Math.max(result, solve(i));
		}
		System.out.println(result);
		PrintWriter out = new PrintWriter(new File("moocast.out"));
		out.println(result);
		out.close();
	}

	static int solve(int node){
		visited[node] = true;
		int c = 1;
		for(int i : adj.get(node)){
			if(visited[i]) continue;
			visited[i] = true;
			c += solve(i);
		}
		return c;
	}
}