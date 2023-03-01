import java.util.*;

public final class cowlibi {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int g = in.nextInt();
		int n = in.nextInt();

		Event[] graze = new Event[g];
		for(int i = 0; i<g; i++){
			int x = in.nextInt();
			int y = in.nextInt();
			int t = in.nextInt();
			graze[i] = new Event(x,y,t);
		}

		Event[] alibi = new Event[n];
		for(int i = 0; i<n; i++){
			int x = in.nextInt();
			int y = in.nextInt();
			int t = in.nextInt();
			alibi[i] = new Event(x,y,t);
		}

		int result = 0;

		for(int i = 0; i<n; i++){
			Event[] temp = new Event[g+1];
			for(int j = 0; j<g; j++){
				temp[j] = graze[j];
			}
			temp[g] = alibi[i];
			Arrays.sort(temp);
			int ai = -1;
			for(int j = 0; j<=g; j++){
				if(temp[j] == alibi[i]){
					ai = j;
					break;
				}
			}
			System.out.println("---");

			boolean guilt1 = false;
			if(ai != 0){
				int dist1 = Math.abs(temp[ai-1].x - temp[ai].x) + Math.abs(temp[ai-1].y - temp[ai].y);
				int time1 = Math.abs(temp[ai].t - temp[ai-1].t);
				if(dist1 <= time1) guilt1 = true;
				System.out.println(dist1);
				System.out.println(time1);
				System.out.println("guilt1 manual check");
			}
			else{
				guilt1 = true;
			}

			boolean guilt2 = false;
			if(ai != g){
				int dist2 = Math.abs(temp[ai+1].x-temp[ai].x) + Math.abs(temp[ai+1].y-temp[ai].y);
				int time2 = Math.abs(temp[ai+1].t-temp[ai].t);
				if(dist2 <= time2) guilt2 = true;
				System.out.println("guilt2 manual check");
			}
			else{
				guilt2 = true;
			}

			System.out.println("guilt check 1: " + String.valueOf(guilt1));
			System.out.println("guilt check 2: " + String.valueOf(guilt2));

			// for(int j = 0; j<g; j++){
			// 	System.out.println("---");
			// 	Event e1 = temp[j];
			// 	Event e2 = temp[j+1];
			// 	int dist = Math.abs(e2.x-e1.x) + Math.abs(e2.y-e1.y);
			// 	int time = e2.t-e1.t;
			// 	System.out.println(dist);
			// 	System.out.println(time);
			// 	if(dist > time){
			// 		inno = true;
			// 		break;
			// 	}
			// }
			if(!guilt1 && !guilt2) result++;
		}
		System.out.println(result);
	}
	static class Event implements Comparable<Event> {
		int x, y, t;
		Event(int x, int y, int t){
			this.x = x;
			this.y = y;
			this.t = t;
		}

		public int compareTo(Event e){
			if(this.t == e.t) return 0;
			if(this.t > e.t) return 1;
			return -1;
		}
		// for debug
		public String toString(){
			return String.valueOf(x) + " " + String.valueOf(y) + " " + String.valueOf(t);
		}
	}
}