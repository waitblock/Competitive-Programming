import java.io.*;
import java.util.*;

public class reststops {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken()); //length of the trail
		int N = Integer.parseInt(st.nextToken()); //# of rest stops
		int rf = Integer.parseInt(st.nextToken()); //rate for FJ
		int rb = Integer.parseInt(st.nextToken()); // rate for Bessie

		PriorityQueue<Stop> stops = new PriorityQueue<>(
				(p, q) -> q.taste - p.taste); //max priority_queue

		for(int j=0; j<N; j++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); //position
			int c = Integer.parseInt(st.nextToken()); //taste value
			stops.add(new Stop(x, c));
		}

        int pf = 0;
        int pb = 0;

        long result = 0;

		//Bessie keeps looking for the next rest stop with the max taste value
        while(!stops.isEmpty()){
            Stop s = stops.poll();
            if(s.loc > pb){
            	long stopTime = (long)(s.loc-pb)*rf-(long)(s.loc-pb)*rb; 
            	pf = s.loc;
            	pb = s.loc;
            	// System.out.println(stopTime);
            	result += (stopTime * s.taste);
            }
            
        }

		br.close();
		System.out.println(result);
		PrintWriter out = new PrintWriter(new File("reststops.out"));
		out.println(result);
		out.close();
	}

	static class Stop {
		int loc;
		int taste;

		Stop(int a, int b) {
			loc = a;
			taste = b;
		}
	}
}