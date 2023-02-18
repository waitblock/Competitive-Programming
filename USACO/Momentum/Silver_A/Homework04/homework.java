import java.util.*;
import java.io.*;

public final class homework {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("homework.in"));
        int n = in.nextInt();
        int[] points = new int[n];
        for(int i = 0; i<n; i++){
            points[i] = in.nextInt();
        }
        in.close();
        int min = Integer.MAX_VALUE;
        int sum = 0;
		HashSet<Integer> maxInd = new HashSet<>();
        double max = Integer.MIN_VALUE;
        for(int i = n-1; i>=1; i--){
            sum += points[i];
            min = Math.min(min, points[i]);
            if(i > n-2) continue;
            double temp = (sum-min)/(n-i-1);
            if(temp > max){
                max = temp;
                maxInd.clear();
                maxInd.add(i);
            }
            if(temp == max){
                maxInd.add(i);
            }

		}
        PrintWriter out = new PrintWriter(new File("homework.out"));
        for(int i : maxInd){
            out.println(i);
            System.out.println(i);
        }
        out.close();
    }
}