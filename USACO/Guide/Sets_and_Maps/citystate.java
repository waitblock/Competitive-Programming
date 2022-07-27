import java.util.*;
import java.io.*;

public class citystate {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("citystate.in"));
		int n = in.nextInt();
		HashMap<String, String[]> store = new HashMap<>();
		String[] cities = new String[n];
		String[] states = new String[n];
		for(int i = 0; i<n; i++){
			String city = in.next().substring(0,2);
			cities[i] = city;
			String state = in.next();
			states[i] = state;
			System.out.println(city);
			System.out.println(state);
			System.out.println("--");
			String[] current = store.get(city);
			if(current == null){
				store.put(city, new String[]{state});
			}
			else if(current != null){
				String[] replace = new String[current.length+1];
				for(int j = 0; j<current.length; j++){
					replace[j] = current[j];
				}
				replace[current.length] = state;
				// System.out.println(Arrays.toString(replace));
				store.put(city, replace);
			}
		}
		for(String s : store.keySet()){
			System.out.println(s);
			System.out.println(Arrays.toString(store.get(s)));
		}
		int result = 0;
		for(int i = 0; i<n; i++){
			String[] got = store.get(states[i]);
			if(got == null) continue;
			// System.out.println(cities[i]);
			// System.out.println(Arrays.toString(got));
			// System.out.println(binarySearch(got, cities[i]));
			if(binarySearch(got, cities[i]) != -1){
				result++;
			}
		}
		result /= 2;
		System.out.println(result);
		PrintWriter out = new PrintWriter(new File("citystate.out"));
		out.println(result);
		out.close();
	}
	 static int binarySearch(String[] arr, String s){
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l+(r-l)/2;
 
            int c = s.compareTo(arr[m]);
 
            if (c == 0) return m;
            if (c > 0) l = m + 1;
            else r = m - 1;
        }
 
        return -1;
    }
}
