// This problem was easier to do in Java because of Java's handy Scanner method which ignores all whitespace.

import java.io.*;
import java.util.*;

public class Timus1001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

    ArrayList<Double> al = new ArrayList<Double>();

		while (sc.hasNext()) {
			al.add(Math.sqrt(sc.nextDouble()));
		}
		double[] arr = new double[al.size()];
		for (int i = 0; i < al.size(); i++) {
			arr[i] = al.get(i);
		}
		for (int i = arr.length-1; i >= 0; i--){
			pw.println(arr[i]);
    }
		pw.flush();
	}
}
