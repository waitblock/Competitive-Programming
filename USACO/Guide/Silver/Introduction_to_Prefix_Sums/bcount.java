import java.util.*;
import java.io.*;
// 1=h=a,2=g=b,3=j=c
public final class bcount {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[] a = new int[n+1];
		int[] b = new int[n+1];
		int[] c = new int[n+1];
		for(int i = 1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			a[i] = a[i-1];
			b[i] = b[i-1];
			c[i] = c[i-1];
			if(temp == 1){
				a[i]++;
			}
			if(temp == 2){
				b[i]++;
			}
			if(temp == 3){
				c[i]++;
			}
		}
		// System.out.println(Arrays.toString(a));
		// System.out.println(Arrays.toString(b));
		// System.out.println(Arrays.toString(c));
		PrintWriter out = new PrintWriter(new File("bcount.out"));
		for(int i = 0; i<q; i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken());
			String result = String.valueOf(a[e]-a[s]) + " " + String.valueOf(b[e]-b[s]) + " " + String.valueOf(c[e]-c[s]);
			out.println(result);
			// System.out.println(result);
		}
		out.close();
	}
}