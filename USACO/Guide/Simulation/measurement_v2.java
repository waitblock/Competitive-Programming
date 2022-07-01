import java.util.*;
import java.io.*;

public class measurement_v2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("measurement.in"));
		int n = in.nextInt();
		Measure[] measures = new Measure[n];
		for(int i = 0; i<n; i++){
			int day = in.nextInt();
			String name = in.next();
			String change = in.next();
			int intChange = Integer.parseInt(change.substring(1,2));
			// System.out.println(change.substring(0,1));
			if(change.substring(0,1).equals("-")){
				intChange *= -1;
			}
			// System.out.println(intChange);
			measures[i] = new Measure(day, name, intChange);
		}
		in.close();
		int result = 0;
		String[] names = {"Bessie", "Elsie", "Mildred"};
		int[] outputs = {7,7,7};
		boolean[] highestOutputLast = {false, false, false};
		for(int i = 1; i<100; i++){
			boolean changed = false;
			for(Measure m : measures){
				if(m.day == i){
					if(m.name.equals("Bessie")){
						outputs[0] += m.change;
					}
					if(m.name.equals("Elsie")){
						outputs[1] += m.change;
					}
					if(m.name.equals("Mildred")){
						outputs[2] += m.change;
					}
					changed = true;
				}
			}
			if(!changed) continue;
			int highestOut = Integer.MIN_VALUE;
			ArrayList<String> highest = new ArrayList<>();
			for(int j = 0; j<3; j++){
				if(outputs[j] > highestOut){
					highest.clear();
					highest.add(names[j]);
				}
				if(outputs[j] == highestOut){
					highest.add(names[j]);
				}
			}
			boolean[] newHOL = new boolean[3];
			if(highest.contains("Bessie")) newHOL[0] = true;
			if(highest.contains("Elsie")) newHOL[1] = true;
			if(highest.contains("Mildred")) newHOL[2] = true;
			System.out.println(Arrays.toString(newHOL));
			System.out.println(Arrays.toString(highestOutputLast));
			for(int j = 0; j<3; j++){
				if(newHOL[j] != highestOutputLast[j]){
					result++;
					break;
				}
			}
			for(int j = 0; j<3; j++){
				highestOutputLast[j] = newHOL[j];
			}
		}
		System.out.println(result);
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