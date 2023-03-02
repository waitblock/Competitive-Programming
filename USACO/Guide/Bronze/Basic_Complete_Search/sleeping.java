import java.util.*;

public class sleeping {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		for(int testcase = 0; testcase < testcases; testcase++){
			int n = in.nextInt();
			int[] log = new int[n];
			for(int i = 0; i<n; i++){
				log[i] = in.nextInt();
			}
			int sum = 0;
			for(int i = 0; i<n; i++){
				sum += log[i];
			}
			int result = Integer.MAX_VALUE;
			for(int i = 0; i<=sum; i++){
				if(i != 0) if(sum % i != 0) continue;
				int requiredPartitionSum;
				if(i == 0) requiredPartitionSum = 0;
				else requiredPartitionSum = sum/i;
				int caseResult = 0;
				int current = 0;
				int partitionSize = 0;
				for(int j = 0; j<n; j++){
					if(current + log[j] > requiredPartitionSum) {
						if(partitionSize == 0){
							caseResult = Integer.MAX_VALUE;
							break;
						}
						caseResult += (partitionSize-1);
						current = 0;
						partitionSize = 0;
					}
					
					current += log[j];
					partitionSize++;
				}
				if(current == requiredPartitionSum && partitionSize == n){
					boolean allEqual = true;
					for(int j = 1; j<n; j++){
						if(log[j] != log[0]){
							allEqual = false;
							break;
						}
					}
					if(!allEqual) caseResult = n-1;
				}
				System.out.println("--");
				System.out.println(i);
				System.out.println(caseResult);
				result = Math.min(caseResult, result);
			}
			System.out.println(result);
		}
	}
}