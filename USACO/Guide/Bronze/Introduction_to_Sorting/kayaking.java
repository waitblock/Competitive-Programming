import java.util.*;

public class kayaking {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int p = n*2;
		int[] weights = new int[p];
		for(int i = 0; i<p; i++){
			weights[i] = in.nextInt();
		}
		Arrays.sort(weights);
		int result = Integer.MAX_VALUE;
		for(int i = 0; i<p-1; i++){
			for(int j = i+1; j<p; j++){
				ArrayList<Integer> people = new ArrayList<>();
				for(int k = 0; k<p; k++){
					if(k != i && k != j){
						people.add(weights[k]);
					}
				}
				// System.out.println(people);
				Collections.sort(people);
				int instability = 0;
				for(int k = 0; k<people.size(); k+=2){
					instability += people.get(k+1)-people.get(k);
				}
				result = Math.min(instability, result);
				// System.out.println(instability);
			}
		}
		System.out.println(result);
	}
}