import java.util.*;
import java.io.*;

public class angry_v2 {
	static ArrayList<Integer> positions = new ArrayList<>();
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("angry.in"));
		int n = in.nextInt();
		
		for(int i = 0; i<n; i++){
			positions.add(in.nextInt());
		}
		in.close();
		Collections.sort(positions);
		// System.out.println(positions);
		int result = Integer.MIN_VALUE;
		for(int i = 0; i<n; i++){
			int e = countExplosions(positions.get(i));
			// System.out.println(positions.get(i));
			// System.out.println(e);
			// System.out.println("---");
			result = Math.max(result, e);
		}
		System.out.println(result);
		PrintWriter out = new PrintWriter(new File("angry.out"));
		out.println(result);
		out.close();
	}
	
	static int countExplosions(int posi){
		int radius = 1;
		int pos = posi;
		int left = 0;
		int right = 0;
		while(true){
			int leftMost = pos;
			
			for(int i = pos-radius; i<pos; i++){
				if(positions.contains(i)){
					leftMost = i;
					break;
				}
			}
			
			if(leftMost == pos){
				left = leftMost;
				break;
			}
			pos = leftMost;
			radius++;
		}
		pos = posi;
		radius = 1;
		while(true){
			int rightMost = pos;
			
			for(int i = pos+radius; i>=pos+1; i--){
				if(positions.contains(i)){
					rightMost = i;
					break;
				}
			}
			
			if(rightMost == pos){
				right = rightMost;
				break;
			}
			pos = rightMost;
			radius++;
		}
		// System.out.println(left);
		// System.out.println(right);
		// System.out.println("---");
		int count = 0;
		for(int i = left; i<= right; i++){
			if(positions.contains(i)){
				count++;
			}
		}
		return count;
	}
}