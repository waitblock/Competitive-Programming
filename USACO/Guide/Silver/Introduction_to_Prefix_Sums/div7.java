import java.util.*;
import java.io.*;

public final class div7 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("div7.in"));
		int n = in.nextInt();
		int[] first = new int[7];
		int[] last = new int[7];
		Arrays.fill(first, -1);
		Arrays.fill(last, -1);
		int runningTotal = 0;
		for(int i = 0; i<n; i++){
			runningTotal += in.nextInt();
			runningTotal %= 7;
			if(first[runningTotal] == -1){
				first[runningTotal] = i;
				last[runningTotal]= i;
			}
			else{
				last[runningTotal] = i;
			}
		}
		in.close();
		// System.out.println(Arrays.toString(first));
		// System.out.println(Arrays.toString(last));
		int result = Integer.MIN_VALUE;
		for(int i = 0; i<7; i++){
			if(first[i] == -1) continue;
			result = Math.max(last[i]-first[i], result);
		}
		System.out.println(result);
		PrintWriter out = new PrintWriter(new File("div7.out"));
		out.println(result);
		out.close();
	}
}