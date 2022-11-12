// tle 4-10

import java.util.*;
import java.io.*;

public final class cereal {
  public static void main(String[] args) throws IOException {
    Kattio io = new Kattio("cereal");
    int n = io.nextInt();
    int m = io.nextInt();
    int[] favorite = new int[n];
    int[] favorite2 = new int[n];
    for(int i = 0; i<n; i++){
      favorite[i] = io.nextInt();
      favorite2[i] = io.nextInt();
    }
    for(int i = 0; i<n; i++){
      HashSet<Integer> remaining = new HashSet<>();
      int result = 0;
      for(int j = 1; j<=m; j++){
        remaining.add(j);
      }
      for(int j = i; j<n; j++){
        if(remaining.contains(favorite[j])){
          remaining.remove(favorite[j]);
          result++;
        }
        else if(remaining.contains(favorite2[j])){
          remaining.remove(favorite2[j]);
          result++;
        }
      }
      io.println(result);
    }
    io.close();
  }

  // @author: Kattis
  static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;
		// standard input
		public Kattio() { this(System.in, System.out); }
		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}
		// USACO-style file input
		public Kattio(String problemName) throws IOException {
			super(problemName + ".out");
			r = new BufferedReader(new FileReader(problemName + ".in"));
		}
		// returns null if no more input
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) { }
			return null;
		}
		public int nextInt() { return Integer.parseInt(next()); }
		public double nextDouble() { return Double.parseDouble(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
}