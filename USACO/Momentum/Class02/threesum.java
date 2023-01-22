import java.util.*;

public final class threesum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		String result = "";
		for(int tc = 0; tc<q; tc++){
			int n = in.nextInt();
			int[] nums = new int[n];
			for(int i = 0; i<n; i++){
				nums[i] = in.nextInt()%10;
			}
			int[] freq = new int[10];
			for(int i = 0; i<n; i++){
				freq[nums[i]]++;
			}
			int bSize = 0;
			for(int i = 0; i<n; i++){
				freq[i] = Math.min(3, freq[i]);
				bSize += freq[i];
			}
			int[] b = new int[bSize];
			int iter = 0;
			for(int i = 0; i<n; i++){
				for(int j = 0; j<freq[i]; j++){
					b[iter] = i;
					iter++;
				}
			}
			// System.out.println(Arrays.toString(b));
			boolean yes = false;
			for(int i = 0; i<bSize; i++){
				for(int j = i+1; j<bSize; j++){
					for(int k = j+1; k<bSize; k++){
						// System.out.println(String.valueOf(i)+" "+String.valueOf(j)+" "+String.valueOf(k));
						if(((b[i]+b[j]+b[k]) % 10) == 3){
							yes=true;
							// System.out.println((b[i]+b[j]+b[k]) % 10);
							i=bSize;
							j=bSize;
							k=bSize;
						}
					}
				}
			}
			result += yes ? "1" : "0";
		}
		System.out.println(result);
	}
}