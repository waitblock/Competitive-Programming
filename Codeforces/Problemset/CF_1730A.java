import java.util.*;
import java.io.*;

public final class CF_1730A {
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        int t = in.nextInt();
        for(int i = 0; i<t; i++){
            solve();
        }
        in.close();
        out.close();
    }
    static void solve(){
        int n = in.nextInt();
        int c = in.nextInt();
        int[] planets = new int[101];
        for(int i = 0; i<n; i++){
            planets[in.nextInt()]++;
        }
        int result = 0;
        for(int i = 1; i<101; i++){
            if(planets[i] == 0) continue;
            result += (planets[i] > c) ? c : planets[i];
        }
        out.println(result);
    }
}