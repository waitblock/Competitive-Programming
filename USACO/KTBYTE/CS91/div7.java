// Credit: KTBYTE Computer Science Academy CS91 Course (https://ktbyte.com)

import java.util.*;
import java.io.*;

public final class div7 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("div7.in"));
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i<n; i++) nums[i] = in.nextInt();
        in.close();

        int result = 0;

        Map<Integer, Integer> prevSums = new HashMap<>();
        // key: mod 7'd prefix sum at some earlier location in the array
        // value: index of the earliest location that key/sum every occurred in the array

        int sum = 0;

        for(int i = 0; i<n; i++) {
        	sums += nums[i];
        	sum %= 7;
        	if(prevSums.containsKey(sum)) {
        		int photosize = i-prevSums.get(sum);
        		result = Math.max(photoSize, result);
        	}
        	else {
        		prevSums.put(sum, i);
        	}
        }

        PrintWriter out = new PrintWriter(new File("div7.out"));
        System.out.println(result);
        out.println(result);
        out.close();
    }
}