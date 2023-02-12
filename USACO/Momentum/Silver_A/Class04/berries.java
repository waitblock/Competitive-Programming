import java.util.*;
import java.io.*;

public final class berries {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("berries.in"));
		int n = in.nextInt();
		int k = in.nextInt();
		int[] b = new int[n];
		for(int i = 0; i<n; i++){
			b[i] = in.nextInt();
		}
		int result = Integer.MIN_VALUE;
		for(int i = 1000; i>=1; i--){
			if(result >= i*k/2) break;
			ArrayList<Integer> baskets = new ArrayList<>();
			for(int j = 0; j<n; j++){
				int toAdd = b[j]/i;
				int extra = b[j]%i;
				for(int a = 0; a<toAdd; a++) baskets.add(i);
				if(extra != 0) baskets.add(extra);
			}
			Collections.sort(baskets);
			Collections.reverse(baskets);
			int total = 0;
			for(int j = k/2; j<k; j++){
				total += baskets.get(j);
			}
			result = Math.max(result, total);
		}
		System.out.println(result);
		PrintWriter out = new PrintWriter(new File("berries.out"));
		out.println(result);
		out.close();
	}
}