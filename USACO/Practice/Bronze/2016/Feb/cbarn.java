import java.util.*;
import java.io.*;

public class cbarn {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner( new File("cbarn.in") );
        int n = in.nextInt();
        int[] rooms = new int[n];
        for(int i = 0; i<n; i++) rooms[i] = in.nextInt();
        in.close();

        int result = Integer.MAX_VALUE;

        for(int door = 0; door<n; door++) {
        	int dist = 0;
        	for(int room = 0; room<n; room++) {
        		int d = (room - door);
        		if(d < 0) d += n;

        		dist += d * rooms[room];
        	}
        	result = Math.min(result, dist);
        }

        PrintWriter out = new PrintWriter( new File("cbarn.out") );
        out.println(result);
        System.out.println(result);
        out.close();

    }
}
