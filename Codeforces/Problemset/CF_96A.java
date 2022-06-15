import java.util.*;

public class CF_96A {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        char[] arr = s.toCharArray();
        char current = arr[0];
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == current){
                count++;
            }
            else if(arr[i] != current){
                if(count >= 7){
                    System.out.println("YES");
                    System.exit(0);
                }
                count = 1;
                current = arr[i];
            }
        }
        if(count >= 7){
            System.out.println("YES");
        }
        else System.out.println("NO");
    }
}
