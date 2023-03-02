import java.io.*;
import java.util.*;
public class measurement_v3 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("measurement.in"));
		int n = in.nextInt();
		int[] day = new int[n];
		String[] cow = new String[n];
		int[] change = new int[n];
		for(int i = 0; i < n; i++) {
			day[i] = in.nextInt();
			cow[i] = in.next();
			change[i] = in.nextInt();
		}
		
		int bessieMilk = 7, elsieMilk = 7, mildredMilk = 7;
		boolean bessieOn = true, elsieOn = true, mildredOn = true;
		int result = 0;
		
		for(int currDay = 1; currDay <= 100; currDay++) {
			for(int i = 0; i < n; i++) {
				if(day[i] == currDay) {
					if(cow[i].equals("Bessie")) {
						bessieMilk += change[i];
					}
					if(cow[i].equals("Elsie")) {
						elsieMilk += change[i];
					}
					if(cow[i].equals("Mildred")) {
						mildredMilk += change[i];
					}
				}
			}
			int highestMilk = Math.max(bessieMilk, Math.max(elsieMilk, mildredMilk));
			boolean bessieOnNext = bessieMilk == highestMilk;
			boolean elsieOnNext = elsieMilk == highestMilk;
			boolean mildredOnNext = mildredMilk == highestMilk;
			if(bessieOn != bessieOnNext || elsieOn != elsieOnNext || mildredOn != mildredOnNext) {
				result++;
			}
			bessieOn = bessieOnNext;
			elsieOn = elsieOnNext;
			mildredOn = mildredOnNext;
		}

		PrintWriter out = new PrintWriter(new File("measurement.out"));
		out.println(result);
		out.close();
		in.close();
	}

}