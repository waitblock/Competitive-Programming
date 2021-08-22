import java.util.*;
import java.io.*;

public class backforth {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner( new File("backforth.in") );
        int[] bucksA = new int[10];
        int[] bucksB = new int[11];
        for(int i = 0; i<10; i++) bucksA[i] = in.nextInt();
        for(int i = 0; i<10; i++) bucksB[i] = in.nextInt();
        in.close();
        
        int tankA = 1000;
        
        boolean[] poss = new boolean[1200];
        
        for(int tue = 0; tue<10; tue++) {
        	int tueAmount = bucksA[tue];
        	bucksA[tue] = 0;
        	bucksB[10] = tueAmount;
        	
        	tankA -= tueAmount;
        	
        	for(int wed = 0; wed<11; wed++) {
        		int wedAmount = bucksB[wed];
        		bucksB[wed] = 0;
        		bucksA[tue] = wedAmount;
        		
        		tankA += wedAmount;
        		
        		for(int thu = 0; thu < 10; thu++) {
        			int thuAmount = bucksA[thu];
        			
        			bucksA[thu] = 0;
        			bucksB[wed] = thuAmount;
        			
        			tankA -= thuAmount;
        			
        			for(int fri = 0; fri<11; fri++) {
        				int friAmount = bucksB[fri];
        				
        				tankA += friAmount;
        				
        				poss[tankA] = true;
        				
        				tankA -= friAmount;
        			}
        			tankA += thuAmount;
        			
        			bucksB[wed] = 0;
        			bucksA[thu] = thuAmount;
        		}
        		tankA -= wedAmount;
        		
        		bucksA[tue] = 0;
        		bucksB[wed] = wedAmount;
        	}
        	tankA += tueAmount;
        	bucksB[10] = 0;
        	bucksA[tue] = tueAmount;
        }
        
        int result = 0;
        
        for(int i = 0; i<1200; i++) {
        	if(poss[i]) result++;
        }
        
        PrintWriter out = new PrintWriter( new File("backforth.out") );
        out.println(result);
        System.out.println(result);
        out.close();
        
    }
}
