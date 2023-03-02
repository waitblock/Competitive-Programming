import java.util.*;
import java.io.*;

public class measurement {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("measurement.in"));
		int n = in.nextInt();
		Measure[] measures = new Measure[n];
		HashSet<String> names2 = new HashSet<>();
		for(int i = 0; i<n; i++){
			int day = in.nextInt();
			String name = in.next();
			names2.add(name);
			String change = in.next();
			int intChange = Integer.parseInt(change.substring(1,2));
			// System.out.println(change.substring(0,1));
			if(change.substring(0,1).equals("-")){
				intChange *= -1;
			}
			// System.out.println(intChange);
			measures[i] = new Measure(day, name, intChange);
		}
		
		String[] names = new String[names2.size()];
		int[] outputs = new int[names2.size()];
		
		int ind = 0;
		for(String name : names2){
			names[ind] = name;
			outputs[ind] = 7;
			ind++;
		}
		System.out.println(Arrays.toString(names));
		System.out.println(Arrays.toString(outputs));
		
		String topName = null;
		
		int result = 0;
		
		for(int i = 1; i<=100; i++){
			int maxOutput = Integer.MIN_VALUE;
			ArrayList<String> maxNames = new ArrayList<>();
			boolean changed = false;
			for(Measure m : measures){
				if(m.day == i){
					outputs[Arrays.asList(names).indexOf(m.name)] += m.change;
					changed = true;
					System.out.println(Arrays.toString(outputs));
				}
			}
			if(!changed) continue;
			for(int j = 0; j<names.length; j++){
				if(outputs[j] > maxOutput){
					maxOutput = outputs[j];
					maxNames.clear();
					maxNames.add(names[j]);
				}
				if(outputs[j] == maxOutput){
					maxNames.add(names[j]);
				}
			}
			for(String name : maxNames){
				if(name != topName){
					result++;
					topName = name;
					break;
				}
			}
			
		}
		
		System.out.println(result);
		PrintWriter out = new PrintWriter(new File("measurement.out"));
		out.println(result);
		out.close();
		in.close();
	}
	static class Measure {
		int day, change;
		String name;
		Measure(int day, String name, int change){
			this.day = day;
			this.name = name;
			this.change = change;
		}
		
	}
}