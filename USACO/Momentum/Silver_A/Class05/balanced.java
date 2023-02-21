import java.util.*;

public final class balanced {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<char[]> strings = new ArrayList<>();
		for(int i = 0; i<n; i++){
			strings.add(in.next().toCharArray());
		}
		String result = "";
		for(char[] arr : strings){
			Stack<Character> s = new Stack<>();
			boolean valid = true;
			for(char c : arr){
				if(c == '(' || c == '['){
					s.push(c);
				}
				if(s.empty()){
					valid = false;
					break;
				}
				if(c == ')'){
					if(s.pop() != '('){
						valid = false;
						break;
					}
				}
				if(c == ']'){
					if(s.pop() != '['){
						valid = false;
						break;
					}
				}
			}
			if(!s.empty()) valid = false;
			result += (valid) ? "1" : "0";
		}
		System.out.println(result);
	}
}