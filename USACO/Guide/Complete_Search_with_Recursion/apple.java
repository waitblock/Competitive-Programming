import java.util.*;
import java.io.*;

public class apple {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = in.nextInt();
		}
    System.out.println(solve(n,nums,0,0,0));
	}

	static long solve(int n, int[] nums, int index, long sum1, long sum2) {
		if (index == n) {
			return Math.abs(sum1 - sum2);
		}

		return Math.min(
			solve(n, nums, index + 1, sum1 + nums[index], sum2),
			solve(n, nums, index + 1, sum1, sum2 + nums[index])
		);
	}
}