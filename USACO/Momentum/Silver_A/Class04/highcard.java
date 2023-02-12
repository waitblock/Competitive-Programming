import java.util.*;
import java.io.*;

public final class highcard {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("highcard.in"));
		int n = in.nextInt();
		boolean[] inE = new boolean[2*n+1];
		for(int i = 0; i<n; i++){
			int temp = in.nextInt();
			inE[temp] = true;
		}
		in.close();

		int[] b = new int[n];
		int[] e = new int[n];
		int bInc = 0;
		int eInc = 0;
		for(int i = 1; i<inE.length; i++){
			if(inE[i]){
				e[eInc] = i;
				eInc++;
			}
			else{
				b[bInc] = i;
				bInc++;
			}
		}
		
		int bP = 0;
		int eP = 0;
		int result = 0;

		while(true){
			if(bP >= n || eP >= n) break;
			if(b[bP] > e[eP]){
				result++;
				bP++;
				eP++;
			}
			else if(b[bP] < e[eP]){
				bP++;
			}
		}

		System.out.println(result);
		PrintWriter out = new PrintWriter(new File("highcard.out"));
		out.println(result);
		out.close();
	}
}