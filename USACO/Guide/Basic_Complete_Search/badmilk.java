import java.util.*;
import java.io.*;

public final class badmilk {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("badmilk.in"));
		int n = in.nextInt();
		int m = in.nextInt();
		int d = in.nextInt();
		int s = in.nextInt();
		int[] person = new int[d];
		int[] milk = new int[d];
		int[] time = new int[d];
		for(int i = 0; i<d; i++){
			person[i] = in.nextInt();
			milk[i] = in.nextInt();
			time[i] = in.nextInt();
		}
		HashMap<Integer, Integer> sick = new HashMap<>(); // p, m
		for(int i = 0; i<s; i++){
			int p = in.nextInt();
			int m2 = in.nextInt(); 
			sick.put(p,m2);
		}
		int result = -1;
		for(int i = 1; i<m; i++){
			boolean bad = true;
			for(int p : sick.keySet()){
				int t = sick.get(p);
				System.out.println("t: "+String.valueOf(t));
				
				boolean valid = false;
				for(int j = 0; j<n; j++){
					if(person[j] == p && milk[j] == i){
						System.out.println("person[j]: " + String.valueOf(person[j]));
						System.out.println("milk[j]: " + String.valueOf(milk[j]));
						System.out.println("time[j]: " + String.valueOf(time[j]));
						if(time[j] < t){
							valid = true;
						}
					}
				}
				if(!valid){
					bad = false;
					break;
				}
				System.out.println("---");
			}
			System.out.println("===");
			int count = 0;
			if(bad){
				System.out.println("hi");
				HashSet<Integer> whoDrank = new HashSet<>();
				for(int j = 0; j<n; j++){
					if(milk[j] == i){
						whoDrank.add(person[j]);
					}
				}
				result = Math.max(whoDrank.size(), result);
			}
		}
		System.out.println(result);
	}
}