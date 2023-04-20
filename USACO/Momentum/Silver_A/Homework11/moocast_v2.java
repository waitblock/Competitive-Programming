import java.util.*;
import java.io.*;

public final class moocast_v2 {
	static boolean[][] linked;
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
		linked = new boolean[n][n];
		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				int v = x[i]-x[j];
				int h = y[i]-y[j];
				int dist =  v*v+h*h;
				linked[i][j] = dist <= p[i]*p[i];
			}
		}

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
		for(int i = 0; i<linked.length; i++){
			if(!visited[i] && linked[node][i]){
				visited[i] = true;
				c += solve(i);
			}
		}
		return c;
	}
}