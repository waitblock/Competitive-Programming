import java.util.*;

public final class diameter {
    static ArrayList<HashSet<Integer>> adj = new ArrayList<>();
    static HashMap<Integer,Integer> distancesMapped = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i<n; i++){
            adj.add(new HashSet<Integer>());
        }
        for(int i = 0; i<n-1; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            adj.get(a-1).add(b-1);
        }
        // System.out.println(adj);
        for(int i : adj.get(0)){
            distancesMapped.put(i,Integer.MIN_VALUE);
            solve(i,1,i);
        }
        // System.out.println(distancesMapped);
        ArrayList<Integer> distances = new ArrayList<>();
        for(int i : distancesMapped.values()) distances.add(i);
        Collections.sort(distances);
        Collections.reverse(distances);
        // System.out.println(distances);
        if(distances.size() == 0){
            System.out.println(0);
        }
        if(distances.size() == 1){
            System.out.println(distances.get(0));
        }
        else{
            System.out.println(distances.get(0)+distances.get(1));
        }
    }

    static void solve(int node, int dist, int init){
        if(adj.get(node).size() == 0){
            if(distancesMapped.get(init) < dist){
                distancesMapped.put(init, dist);
            }
            return;
        }
        for(int i : adj.get(node)){
            solve(i, dist+1, init);
        }
    }
}