/*
 * Kalindrome - TEACHER VERSION
 */
import java.util.*;
import java.io.*;
public class kalindrome_teacher {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //# of queries
		int K = Integer.parseInt(st.nextToken()); //# of iterations to obtain a palindrome

		int cnt = 0;
		for(int p=0; p<N; p++) {
			String s = br.readLine();

			//construct an ArrayList of integers from the String s
			// Here the right-most digit is at the front (left) of the ArrayList.
			ArrayList<Integer> A = new ArrayList<Integer>();
			for(int j=s.length()-1; j>=0; j--)
				A.add(s.charAt(j) - 'A');

			int rounds = 0;
			while(rounds<K && !isPalindrome(A)) {
				A = addReverse(A);
				rounds++;
			}
			
			if(rounds<K) cnt++;
		}
		System.out.println(cnt);
		br.close();
	}

	//check whether an ArrayList is a palindrome
	public static boolean isPalindrome(ArrayList<Integer> A) {
		int n = A.size();
		for(int j=0; j<n/2; j++) {
			if(A.get(j) != A.get(n-1-j))
				return false;
		}
		
		return true;
	}

	//add an ArrayList and its reverse with base 26
	public static ArrayList<Integer> addReverse(ArrayList<Integer> A) {
		ArrayList<Integer> B = new ArrayList<Integer>();
		
		int len = A.size();
		int carryOver = 0;
		for(int j=0; j<len; j++) {
			int s = A.get(j) + A.get(len-1-j) + carryOver;
			if(s>25) {
				carryOver = 1;
				s -= 26;
			}
			else
				carryOver = 0;
			
			B.add(s); //append to the tail
		}
		if(carryOver==1)
			B.add(carryOver);
		
		return B;
	}
}