// TODO: Finish

import java.util.*;
import java.io.*;

public final class palpath {
	static int n;
	static char[][] grid;
	static HashMap<Integer, HashSet<String>> paths;
	static HashMap<Integer, HashSet<String>> pathsReverse;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("palpath.in"));
		n = in.nextInt();
		pathsReverse = new HashSet<String>[n];
		for(int i = 0; i<n; i++){
			grid[i] = in.nextInt().toCharArray();
		}
		generatePaths(0,0,"");
	}

	static void generatePaths(int r, int c, String path){
		if(r+c == n-1){
			HashSet<String> temp = (paths.get(r) == null) ? new HashSet<String> : paths.get(r);
			temp.add(path);
			paths.put(r,temp);
			return;
		}
		path += grid[r][c];
		generatePaths(r+1,c,path);
		generatePaths(r,c+1,path);
	}
	static void generatePathsReverse(int r, int c, String path){
		if(r+c == n-1){
			HashSet<String> temp = (pathsReverse.get(r) == null) ? new HashSet<String> : pathsReverse.get(r);
			temp.add(path);
			pathsReverse.put(r,temp);
			return;
		}
		path += grid[r][c];
		generatePaths(r-1,c,path);
		generatePaths(r,c-1,path);
	}

}