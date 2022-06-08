import java.util.*;

public class CF_557A {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        ArrayList<Integer> factors = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            if(x % i == 0){
                factors.add(i);
            }
        }
        int result = 0;
        int temp = (int) Math.sqrt(x);
        if(Math.pow(temp, 2) == temp){
            result--;
            factors.add(1);
        }
        int sub = 0;
        for(int i = 0; i<factors.size(); i++){
            if(!factors.contains(x/factors.get(i))){
                sub += 1;
            }
        }
        result += factors.size() - sub;
        System.out.println(result);
    }
}