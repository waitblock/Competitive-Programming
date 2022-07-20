// tles 7, 10

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
			char[][] spottyChars = new char[n][3];
			for(int l = 0; l<n; l++){
				char[] chars = new char[3];
				chars[0] = spottyGenomes[l][i];
				chars[1] = spottyGenomes[l][j];
				chars[2] = spottyGenomes[l][k];
				// Arrays.sort(chars);
				spottyChars[l] = chars;
			}
			boolean explainsSpottiness = true;
			for(int l = 0; l<n; l++){
				char[] chars = new char[3];
				chars[0] = plainGenomes[l][i];
				chars[1] = plainGenomes[l][j];
				chars[2] = plainGenomes[l][k];
				// Arrays.sort(chars);
				for(int a = 0; a<n; a++){
					if(Arrays.equals(chars, spottyChars[a])){
						explainsSpottiness = false;
						l = a = n;
					}
				}
			}
			if(explainsSpottiness) result++;
		}
		System.out.println(result);
		PrintWriter out = new PrintWriter(new File("cownomics.out"));
		out.println(result);
		out.close();
	}
}