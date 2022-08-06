import java.util.*;
import java.io.*;

public class herding {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("herding.in"));
		int[] positions = new int[3];
		for(int i = 0; i<3; i++){
			positions[i] = in.nextInt();
		}
		in.close();
		Arrays.sort(positions);
		int min = 2;
		if(positions[0] == positions[1]-1 && positions[1] == positions[2]-1){
			min = 0;
		}
		if(positions[0] == positions[1] - 2 || positions[1] == positions[2] - 2){
			min = 1;
		}
		int max = Math.max(positions[1]-positions[0], positions[2]-positions[1])-1;
		System.out.println(min);
		System.out.println(max);
		PrintWriter out = new PrintWriter(new File("herding.out"));
		out.println(min);
		out.println(max);
		out.close();
	}
}