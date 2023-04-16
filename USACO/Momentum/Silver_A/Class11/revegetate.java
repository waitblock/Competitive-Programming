import java.util.*;
import java.io.*;

public final class revegetate {
	static HashSet<Integer>[] sameAdj;
	static HashSet<Integer>[] diffAdj;
	static int[] color;
	static boolean imp = false;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("revegetate.in"));
		int n = in.nextInt();
        int m = in.nextInt();
		sameAdj = new HashSet[n+1];
		diffAdj = new HashSet[n+1];
		color = new int[n+1];

        for(int i = 0; i<=n; i++){
            sameAdj[i] = new HashSet<Integer>();
            diffAdj[i] = new HashSet<Integer>();
        }

        for(int i = 0; i<m; i++){
            String type = in.next();
            int a = in.nextInt();
            int b = in.nextInt();
            if(type.equals("S")){
                sameAdj[a].add(b);
                sameAdj[b].add(a);
            }
            else if(type.equals("D")){
                diffAdj[a].add(b);
                diffAdj[b].add(a);
            }
        }
        in.close();

        int result = 0;

        for(int i = 1; i<=n; i++){
            if(color[i] == 0){
                colorIn(i,1);
                result++;
            }
        }

        PrintWriter out = new PrintWriter(new File("revegetate.out"));

        if(imp){
            out.print(0);
        }
        else{
            out.print(1);
            for(int i = 0; i<result; i++) out.print(0);
        }
        out.println();
        out.close();

	}

    static void colorIn(int node, int c){
        color[node] = c;
        for(int adj : sameAdj[node]){
            if(color[adj] == 3-c) imp = true;
            if(color[adj] == 0) colorIn(adj, c);
        }
        for(int adj : diffAdj[node]){
            if(color[adj] == c) imp = true;
            if(color[adj] == 0) colorIn(adj, 3-c);
        }
    }
}