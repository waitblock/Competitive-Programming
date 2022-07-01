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
		String names = {"Bessie", "Elsie", "Mildred"};
		int[] 
		for(int i = 1; i<100; i++){
			int tempBessie = bessie;
			int tempElsie = elsie;
			int tempMildred = mildred;
			for(Measure m : measures){
				if(m.day == i){
					if(m.name.equals("Bessie")){
						bessie += m.change;
					}
					if(m.name.equals("Elsie")){
						elsie += m.change;
					}
					if(m.name.equals("Mildred")){
						mildred += m.change;
					}
				}
			}
			if()
		}
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