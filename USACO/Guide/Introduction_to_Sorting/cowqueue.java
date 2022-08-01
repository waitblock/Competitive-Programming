import java.util.*;
import java.io.*;

public class cowqueue {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("cowqueue.in"));
		int n = in.nextInt();
		int[] arrival = new int[n];
		int[] time = new int[n];
		for(int i = 0; i<n; i++){
			arrival[i] = in.nextInt();
			time[i] = in.nextInt();
		}
		in.close();
		// System.out.println(Arrays.toString(arrival));
		// System.out.println(Arrays.toString(time));
		int[] temp = new int[n];
		for(int i = 0; i<n; i++){
			temp[i] = arrival[i];
		}
		int[] temp2 = new int[n]; 
		for(int i = 0; i<n; i++){
			temp2[i] = time[i];
		}
		Arrays.sort(arrival);
		for(int i = 0; i<n; i++){
			int ind = 0;
			for(int j = 0; j<temp.length; j++){
				if(temp[j] == arrival[i]){
					ind = j;
					break;
				}
			}
			time[i] = temp2[ind];
		}
		// System.out.println(Arrays.toString(arrival));
		// System.out.println(Arrays.toString(time));
		int result = 0;
		for(int i = 0; i<n; i++){
			if(result < arrival[i]){
				result = arrival[i];
			}
			result += time[i];
		}
		// System.out.println(result);
		PrintWriter out = new PrintWriter(new File("cowqueue.out"));
		out.println(result);
		out.close();
	}
}