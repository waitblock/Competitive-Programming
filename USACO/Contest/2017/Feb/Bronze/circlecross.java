import java.util.*;
import java.io.*;

public class circlecross {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner( new File("circlecross.in") );
        String letters = in.next();
        in.close();
        
        int result = 0;
        
        for(char cow1 = 'A'; cow1 <= 'Z'; cow1++) {
        	String cow1Str = "" + cow1;
        	
        	int left = letters.indexOf(cow1Str);
        	int right = letters.indexOf(cow1Str, left+1);
        	
        	int[] cow2Counts = new int[26];
        	
        	for(int i = left + 1; i<right; i++) {
        		char cow2 = letters.charAt(i);
        		
        		cow2Counts[cow2-'A']++;
        	}
        	
        	for(int i = 0; i<26; i++) {
        		if(cow2Counts[i] == 1)
        			result++;
        	}
        }
        
        result /= 2;
        
        PrintWriter out = new PrintWriter( new File("circlecross.out") );
        out.println(result);
        System.out.println(result);
        out.close();
        
    }
}



/*
	 A
   B   B
     A
*/

//ABAB

/*
     A
   B   A
     B
*/
//AABB
