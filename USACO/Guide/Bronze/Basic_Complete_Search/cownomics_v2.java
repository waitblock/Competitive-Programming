import java.util.*;
import java.io.*;

public class cownomics_v2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("cownomics.in"));
		int n = in.nextInt();
		int m = in.nextInt();
		char[][] spottyGenomes = new char[n][m];
		char[][] plainGenomes = new char[n][m];
		for(int i = 0; i<n; i++){
			spottyGenomes[i] = in.next().toCharArray();
		}
		for(int i = 0; i<n; i++){
			plainGenomes[i] = in.next().toCharArray();
		}
		int result = 0;
		ArrayList<int[]> sets = new ArrayList<>();
		for(int i = 0; i<m-2; i++){
			for(int j = i+1; j<m-1; j++){
				for(int k = j+1; k<m; k++){
					// System.out.println(i);
					// System.out.println(j);
					// System.out.println(k);
					// System.out.println("---");
					sets.add(new int[]{i,j,k});
				}
			}
		}
		for(int[] set : sets){
			int i = set[0];
			int j = set[1];
			int k = set[2];
			boolean[] spottyGenome = new boolean[64];
			for(int l = 0; l<n; l++){
				int sum = convert(spottyGenomes[l][i]) + convert(spottyGenomes[l][j])*4 + convert(spottyGenomes[l][k])*16;
				spottyGenome[sum] = true;
			}
			boolean explainsSpottiness = true;
			for(int l = 0; l<n; l++){
				int sum = convert(plainGenomes[l][i]) + convert(plainGenomes[l][j])*4 + convert(plainGenomes[l][k])*16;
				
				if(spottyGenome[sum]){
					explainsSpottiness = false;
					break;
				}
			}
			if(explainsSpottiness) result++;
		}
		System.out.println(result);
		PrintWriter out = new PrintWriter(new File("cownomics.out"));
		out.println(result);
		out.close();
	}
	static int convert(char c){
		if(c == 'A') return 0;
		if(c == 'C') return 1;
		if(c == 'G') return 2;
		if(c == 'T') return 3;
		return -1;
	}
}