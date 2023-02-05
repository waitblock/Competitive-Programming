// TODO - not working for sample case

import java.util.*;

public final class kalindrome {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k2 = in.nextInt();
		int result = 0;
		for(int i = 0; i<n; i++){
			char[] s = in.next().toCharArray();
			for(int j = 0; j<=k2; j++){
				int[] temp = new int[s.length];
				for(int k = 0; k<s.length; k++){
					temp[k] = ((int) s[k] - 65);
				}
				System.out.println(Arrays.toString(temp));
				ArrayDeque<Integer> sResult = new ArrayDeque<>();
				sResult.push(0);
				for(int k = s.length-1; k>=0; k--){
					int sum = temp[k] + temp[s.length-1-k];
					System.out.println(sum);
					sum += sResult.removeFirst();
					int extra = 0;
					if(sum > 25){
						sum = 25;
						extra = sum % 26;
					}
					sResult.push(sum);
					sResult.push(extra);
				}
				if(sResult.peekFirst() == 0){
					sResult.removeFirst();
				}
				System.out.println(sResult);
				ArrayList<Integer> num = new ArrayList<>();
				for(int k = 0; k<sResult.size(); k++){
					num.add(sResult.removeFirst());
				}
				System.out.println(num);
				boolean valid = true;
				for(int k = 0; k<num.size()/2; k++){
					if(num.get(k) != num.get(num.size()-1-k)){
						valid = false;
						break;
					}
				}
				if(valid){
					result++;
					break;
				}

			}
		}

		System.out.println(result);
		in.close();
	}
}