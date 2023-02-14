import java.util.*;

public final class truckload {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] units = new int[n];
        int[] price = new int[n];
        int[] capacity = new int[m];
        for(int i = 0; i<n; i++){
            units[i] = in.nextInt();
            price[i] = in.nextInt();
        }
        for(int i = 0; i<m; i++){
            capacity[i] = in.nextInt();
        }
        in.close();
        int[] load = new int[m];
        int[] truckPrice = new int[m];
        int unitsInd = 0;
        int loadInd = 0;
        while(true){
            if(unitsInd >= n || loadInd >= m) break;
            int req = capacity[loadInd]-load[loadInd];
            int remaining = Math.max(0,units[unitsInd]-req);
            int fulfilled = units[unitsInd]-remaining;
            load[loadInd] += fulfilled;
            truckPrice[loadInd] += (fulfilled * price[unitsInd]);
            units[unitsInd] = remaining;
            if(capacity[loadInd] == load[loadInd]){
                loadInd++;
            }
            if(units[unitsInd] == 0){
                unitsInd++;
            }
        }
        // System.out.println(Arrays.toString(truckPrice));
        int result = 0;
        for(int i = 0; i<m; i++){
            result += truckPrice[i];
        }
        System.out.println(result);
    }
}
