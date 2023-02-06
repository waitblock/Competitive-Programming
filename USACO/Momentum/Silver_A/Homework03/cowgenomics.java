// time complexity: O(n^2*m)
// n^2*m <= 125 * 10^5

import java.util.*;
import java.io.*;

public final class cowgenomics {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.print("Enter directory: ");
    String dir = in.next();
    while(true){
      System.out.print("Enter filename: ");
      String f = in.next();
      try{
        solve(dir+"/"+f);
      }
      catch(Exception e){
        e.printStackTrace(System.err);
      }
    }
  }
  static void solve(String filename) throws FileNotFoundException {
    Scanner in = new Scanner(new File(filename));
		int n = in.nextInt();
		int m = in.nextInt();
		char[][] spotty = new char[n][m];
		for(int i = 0; i<n; i++){
			spotty[i] = in.next().toCharArray();
		}
		char[][] plain = new char[n][m];
		for(int i = 0; i<n; i++){
			plain[i] = in.next().toCharArray();
		}
		in.close();
		int result = -1;
		for(int i = 0; i<n; i++){ // n <= 500
			for(int j = 0; j<n; j++){ // n <= 500
				int temp = 0;
				for(int k = 0; k<m; k++){ // m <= 50
					if(spotty[i][k] == plain[j][k]){
						temp++;
					}
				}
				result = Math.max(temp, result);
			}
		}
		System.out.println(result);
  }
}