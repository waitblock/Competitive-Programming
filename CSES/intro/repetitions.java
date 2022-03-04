import java.util.*;
 
public class repetitions {
 
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char[] seq = in.nextLine().toCharArray();
        int result = Integer.MIN_VALUE;
        int letter = seq[0];
        int count = 1;
        for(int i = 1; i<seq.length; i++){
            char c = seq[i];
            if(c != letter){
                letter = c;
                result = Math.max(count, result);
                count = 1;
            }
            else{
                count++;
            }
        }
        result = Math.max(count, result);
        System.out.println(result);
    }
}

