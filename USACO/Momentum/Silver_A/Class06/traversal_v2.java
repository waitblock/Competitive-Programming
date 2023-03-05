import java.util.*;

public final class traversal_v2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long MOD = 1_000_000_007;
		int m = in.nextInt();
		int n = in.nextInt();
		int L = Math.max(m,n);
		int[][] matrix = new int[L][L];
		for(int[] a : matrix){
			Arrays.fill(a,-1);
		}
		for(int i = 0; i<m; i++){
			for(int j = 0; j<n; j++){
				matrix[i][j] = in.nextInt();
			}
		}
		in.close();
		long counter = 0;
		long result = 0;
		for(int i = 0; i<L; i++){
			for(int j = 0; j<=i; j++){
				if(matrix[i][j] == -1) continue;
				// System.out.print(matrix[i][j]);
				// System.out.print(" ");
				// System.out.println(String.valueOf(i) + " " + String.valueOf(j));
				result += (counter * (long) matrix[i][j]);
				counter++;
			}
			for(int j = i-1; j>=0; j--){
				if(matrix[j][i] == -1) continue;
				// System.out.print(matrix[j][i]);
				// System.out.print(" ");
				// System.out.println(String.valueOf(i) + " " + String.valueOf(j));
				result += (counter * (long) matrix[j][i]);
				counter++;
			}
			// System.out.println();
		}
		System.out.println(result%MOD);
	}
}