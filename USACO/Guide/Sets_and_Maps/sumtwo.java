import java.util.*;

public class sumtwo {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> copy = new ArrayList<>();
		int n = in.nextInt();
		int target = in.nextInt();
		for(int i = 0; i<n; i++){
			arr.add(in.nextInt());
		}
		for(int i = 0; i<n; i++) copy.add(arr.get(i));
		in.close();
		Collections.sort(arr);
		for(int i = 0; i<n-1; i++){
			for(int j = i+1; j<n; j++){
				if(arr.get(i) + arr.get(j) > target){
					break;
				}
				if(arr.get(i) + arr.get(j) == target){
					System.out.print(copy.indexOf(arr.get(i))+1);
					System.out.print(" ");
					copy.set(copy.indexOf(arr.get(i)),arr.get(i)+1);
					System.out.println(copy.indexOf(arr.get(j))+1);
					System.exit(0);
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	}
}