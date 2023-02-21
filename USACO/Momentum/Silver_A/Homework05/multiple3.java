import java.util.*;

public final class multiple3 {
	public static void main(String[] args) {
		double MOD = 1e9+7;
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a2 = new int[n];
		for(int i = 0; i<n; i++){
			a2[i] = in.nextInt();
		}

		ArrayList<Integer> a = new ArrayList<>();
		for(int i : a2) a.add(i);
		Collections.sort(a);
		int sum = 0;
		for(int i : a) sum += i;

		boolean one = a.contains(1); boolean four = a.contains(4); boolean seven = a.contains(7);
		boolean two = a.contains(2); boolean five = a.contains(5); boolean eight = a.contains(8);
		
		if(sum % 3 == 1){	
			if(one) a.remove(Integer.valueOf(1));
			else if(four) a.remove(Integer.valueOf(4));
			else if(seven) a.remove(Integer.valueOf(7));
			if(!one && !four && seven){

			}
		}
		if(sum % 3 == 2){
			if(two && five){
				a.remove(Integer.valueOf(2));
				a.remove(Integer.valueOf(5));
			}
			else if(two && eight){
				a.remove(Integer.valueOf(2));
				a.remove(Integer.valueOf(8));
			}
			else if(five && eight){
				a.remove(Integer.valueOf(5));
				a.remove(Integer.valueOf())
			}
		}

	}
}