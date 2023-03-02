import java.util.*;

public class sleeping_v2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		for(int testcase = 0; testcase < testcases; testcase++){
			int n = in.nextInt();
			int[] log = new int[n];
			int sum = 0;
			for(int i = 0; i<n; i++){
				log[i] = in.nextInt();
				sum += log[i];
			}
			for(int i = n; i>=1; i--){
				if(sum % i == 0){
					int reqSum = sum/i;
					int currSum = 0;
					boolean valid = true;
					for(int j = 0; j<n; j++){
						currSum += log[j];
						if(currSum > reqSum){
							valid = false;
							break;
						}
						if(currSum == reqSum) currSum = 0;
					}
					if(valid){
						System.out.println(n-i);
						break;
					}
				}
			}
		}
	}
}