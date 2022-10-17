import java.util.*;
import java.io.*;

public final class milkvisits {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("milkvisits.in"));
        int n = in.nextInt();
        int m = in.nextInt();
        char[] breeds = in.next().toCharArray();
		Farm[] farms = new Farm[n+1];
		for(int i = 1; i<=n; i++){
			Farm f = new Farm();
			f.milk = (breeds[i] == 'G') ? 1 : -1;
			farms[i] = f;
		}
        for(int i = 0; i<n-1; i++){
            int a = in.nextInt();
			int b = in.nextInt();
			farms[a].connected.add(b);
			farms[b].connected.add(a);
        }
		Path[] paths = new Path[m];
		for(int i = 0; i<m; i++){
			Path p = new Path();
			p.start = in.nextInt();
			p.end = in.nextInt();
			p.milk = in.next() == "G" ? 1 : -1;
			paths[i] = p;
		}
		in.close();
    }
    static class Farm {
        int milk; // G = 1, H = -1
        HashSet<Integer> connected;
    }
	static class Path {
		int start, end, milk;
	}
}