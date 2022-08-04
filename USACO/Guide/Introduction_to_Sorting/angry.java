import java.util.*;
import java.io.*;

public class angry {
	static ArrayList<Integer> positions = new ArrayList<>();
	static int count = 0;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("angry.in"));
		int n = in.nextInt();
		
		for(int i = 0; i<n; i++){
			positions.add(in.nextInt());
		}
		Collections.sort(positions);
		int result = Integer.MIN_VALUE;
		for(int i = 0; i<n; i++){
			count = 1;
			countExploded(positions.get(i), 1);
			result = Math.max(count, result);
		}
		System.out.println(result);
	}
	
	static void countExploded(int pos, int radius){
		for(int i = pos-radius; i<=pos+radius; i++){
			if(i == pos) continue;
			if(positions.contains(i)){
				count++;
				countExploded(i, radius+1);
			}
		}
		return;
	}
}