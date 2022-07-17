import java.util.*;
import java.io.*;

public class notlast {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("notlast.in"));
		int n = in.nextInt();
		HashMap<String, Integer> milk = new HashMap<>();
		String[] names = {"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
		for(String name : names){
			milk.put(name, 0);
		}
		for(int i = 0; i<n; i++){
			String name = in.next();
			int milkProduced = in.nextInt();
			milk.put(name, milk.get(name)+milkProduced);
		}
		// System.out.println(milk);
		int minimum = Integer.MAX_VALUE;
		for(int i = 0; i<7; i++){
			minimum = Math.min(milk.get(names[i]), minimum);
		}
		ArrayList<String> secondLowest = new ArrayList<>();
		int secondLowestMilk = Integer.MAX_VALUE;
		for(int i = 0; i<7; i++){
			String name = names[i];
			int totalMilk = milk.get(name);
			if(totalMilk == minimum) continue;
			if(totalMilk == secondLowestMilk){
				secondLowest.add(name);
			}
			if(totalMilk < secondLowestMilk){
				secondLowest.clear();
				secondLowest.add(name);
				secondLowestMilk = totalMilk;
			}
		}
		PrintWriter out = new PrintWriter(new File("notlast.out"));
		if(secondLowest.size() == 1){
			System.out.println(secondLowest.get(0));
			out.println(secondLowest.get(0));
		}
		else{
			System.out.println("Tie");
			out.println("Tie");
		}
		in.close();
		out.close();
	}
}