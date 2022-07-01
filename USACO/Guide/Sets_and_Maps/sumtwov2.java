import java.util.*;

public class sumtwov2 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int target = in.nextInt();
		int[] values = new int[n];
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i = 0; i<n; i++){
			values[i] = in.nextInt();
		}
		in.close();
		for(int i = 0; i<n; i++){
			if(hm.containsKey(target-values[i])){
				System.out.print(i+1);
				System.out.print(" ");
				System.out.println(hm.get(target-values[i]));
				System.exit(0);
			}
			hm.put(values[i], i+1);
		}
		System.out.println("IMPOSSIBLE");
	}
}