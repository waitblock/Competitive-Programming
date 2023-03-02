import java.util.*;
import java.io.*;

public class sleepy {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("sleepy.in"));
		int n = in.nextInt();
		int[] cows = new int[n];
		for(int i = 0; i<n; i++){
			cows[i] = in.nextInt();
		}
		in.close();
		int result = 1;
		for(int i = n-1; i>0; i--){
			if(cows[i] > cows[i-1]){
				result++;
			}
			else{
				break;
			}
		}
		result = n-result;
		System.out.println(result);
		PrintWriter out = new PrintWriter(new File("sleepy.out"));
		out.println(result);
		out.close();
	}
}