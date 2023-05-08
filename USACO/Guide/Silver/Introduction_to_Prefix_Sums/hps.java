import java.util.*;
import java.io.*;

public final class hps {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("hps.in"));
		int n = in.nextInt();
		int[] h = new int[n+1];
		int[] p = new int[n+1];
		int[] s = new int[n+1];
		for(int i = 1; i<=n; i++){
			char temp = in.next().charAt(0);
			h[i]=h[i-1];
			p[i]=p[i-1];
			s[i]=s[i-1];
			if(temp == 'H'){
				h[i]++;
			}
			if(temp == 'P'){
				p[i]++;
			}
			if(temp == 'S'){
				s[i]++;
			}
		}
		// System.out.println(Arrays.toString(h));
		// System.out.println(Arrays.toString(p));
		// System.out.println(Arrays.toString(s));

		// i = first gesture, j = gesture fj switched to
		//0=h,1=p,2=s

		int result = -1;

		for(int x=0; x<=n; x++){
			int before = Math.max(h[x],Math.max(p[x],s[x]));
			int after = Math.max(h[n]-h[x],Math.max(p[n]-p[x],s[n]-s[x]));
			result = Math.max(result, before+after);
		}
		System.out.println(result);
		PrintWriter out = new PrintWriter(new File("hps.out"));
		out.println(result);
		out.close();
	}
}