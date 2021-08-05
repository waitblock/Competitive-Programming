import java.util.*;
import java.io.*;


public class speeding{
	public static void main(String[] args) throws Exception{
		
		Scanner in  = new Scanner(new File("speeding.in"));
		int n = in.nextInt(); // no. of segments of limit
		int m = in.nextInt(); // no. segments of travel
		
		int[] limits = new int[100];
		int[] speeds = new int[100];
		
		int mi = 0; // starting point for next segment
		
		// looping through segments of limit
		for(int i = 0; i<n; i++) {
			int len = in.nextInt();
			int limit = in.nextInt();
			
			for(int j = 0; j<len; j++)
				limits[mi++] = limit;
		}
		
		mi = 0;
		
		// looping through segments of bessie's speed
		for(int i = 0; i<m; i++) {
			int len = in.nextInt();
			int speed = in.nextInt();
			
			for(int j = 0; j<len; j++)
				speeds[mi++] = speed;
		}
		
		in.close();
		
		int result = 0;
		
		for(int j = 0; j<100; j++) {
			result = Math.max(result, speeds[j]-limits[j]);
		}
		
		// ^^^ iterating through each mile and checking each mile and speed
		
		PrintWriter out = new PrintWriter(new File("speeding.out"));
		out.println(result);
		System.out.println("Result: " + String.valueOf(result));
		out.close();
	}
}

/* ANALYSIS 

Sample input:
3 3     <-- n and m (# of segments for limits, and for tractor speeds)

40 75       <-- for 40 miles, speed limit is 75
50 35       <-- for next 50 miles...
10 45

40 76      <-- for 40 miles, bessie travels @76
20 30      <-- for next 20 miles...
40 40


        75            35                  45    <-- speed limits
|--------------|------------------------|----|  <-- limits segments
0              40       60             90   100     <-- mile markers
|--------------|---------|-------------------|  <-- Bessie's segments
        76          30                 40       <-- travel speed


0 1 2  <-- mile markers (points)
|-|-|
 0 1   <-- indexes (spans of road)

 40 elements         20 elems      30 elems      10 elems
 75 75 75 ... 75 35 35 35 ... 35 35 35 ... 35 45 ... 45
 76 76 76 ... 76 30 30 30 ... 30 40 40 ... 40 40 ... 40
 
 0                                                  100


for each mile, find limit vs tractor speed, go through each and find
   difference/amount over one by one
   
we could track which segment we're "looking at" on each side (limits / tractor)
   simultaneously (e.g. "first 40 miles"), looking out for the cases where
   segments don't perfectly overlap (e.g. "next 20 miles")


*/