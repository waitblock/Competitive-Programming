import java.util.*;
import java.io.*;

public final class bovinegenomics {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("cownomics.in"));
		int n = in.nextInt();
		int m = in.nextInt();
		char[][] spotty = new char[n][m];
		char[][] plain = new char[n][m];

		for(int i = 0; i<n; i++){
			spotty[i] = in.next().toCharArray();
		}
		for(int i = 0; i<n; i++){
			plain[i] = in.next().toCharArray();
		}
		in.close();

		int result = 0;

		for(int i = 0; i<m; i++){
			HashSet<Character> temp = new HashSet<>();
			for(int j = 0; j<n; j++){
				temp.add(spotty[j][i]);
			}
			boolean valid = true;
			for(int j = 0; j<n; j++){
				if(temp.contains(plain[j][i])){
					valid = false;
					break;
				}
			}
			if(valid) result++;
		}
		System.out.println(result);
		PrintWriter out = new PrintWriter(new File("cownomics.out"));
		out.println(result);
		out.close();
	}
}