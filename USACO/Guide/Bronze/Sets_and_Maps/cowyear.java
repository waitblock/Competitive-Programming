import java.util.*;
// import java.io.*;

public class cowyear {
	public static void main(String[] args) {
	// public static void main(String[] args) throws FileNotFoundException {
		String[] zodiacs = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};
		HashMap<String,Integer> nZodiacs = new HashMap<>();
		for(int i = 0; i<12; i++){
			nZodiacs.put(zodiacs[i], i);
		}
		// Scanner in = new Scanner(new File("cowyear.in"));
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashMap<String, Integer> diff = new HashMap<>(); // Bessie, 0
		diff.put("Bessie", 0);
		for(int i = 0; i<n; i++){
			String cow = in.next();
			in.next(); in.next();
			String type = in.next(); // previous or next
			String zodiac = in.next(); // what zodiac symbol
			in.next(); in.next();
			String cCow = in.next();
			int cnZodiac = diff.get(cCow)%12;
			if(cnZodiac < 0){
				cnZodiac = (12-Math.abs(cnZodiac));
			}
			String cZodiac = zodiacs[cnZodiac];
			int cDiff = Math.abs(nZodiacs.get(zodiac)-nZodiacs.get(cZodiac));
			if(cDiff == 0){
				cDiff = 12;
			}
			if(type.equals("next") && cnZodiac > nZodiacs.get(zodiac)){
				cDiff = 12-cDiff;
			}
			if(type.equals("previous")){
				if(cnZodiac < nZodiacs.get(zodiac)){
					cDiff = 12-cDiff;
				}
				cDiff *= -1;
			}
			int toPut = cDiff + diff.get(cCow);
			// System.out.println(cow+":"+zodiac);
			// System.out.println(cCow + ":"+ cZodiac);
			// System.out.println(cDiff);
			// System.out.println("---");
			// System.out.println(toPut);
			diff.put(cow, toPut);
		}
		// System.out.println(diff);
		System.out.println(Math.abs(diff.get("Elsie")));
	}
}