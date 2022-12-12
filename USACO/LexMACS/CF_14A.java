import java.util.*;

public final class CF_14A {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] grid = new char[n][m];
        for(int i = 0; i<n; i++){
            grid[i] = in.next().toCharArray();
        }
        int minI = Integer.MAX_VALUE;
        int maxI = Integer.MIN_VALUE;
        int minJ = Integer.MAX_VALUE;
        int maxJ = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == '*'){
                    minI = Integer.min(minI, i);
                    maxI = Integer.max(maxI, i);
                    minJ = Integer.min(minJ, j);
                    maxJ = Integer.max(maxJ, j);
                }
            }
        }
        // System.out.println(minI);
        // System.out.println(maxI);
        // System.out.println(minJ);
        // System.out.println(maxJ);

        for(int i = minI; i<=maxI; i++){
            for(int j = minJ; j<=maxJ; j++){
                System.out.print(grid[i][j]);
            }
            System.out.print("\n");
        }
        in.close();
    }
}