import java.util.*;
import java.io.*;

public class records {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("records.in"));
        int n = in.nextInt();
        ArrayList<ArrayList<String>> groups = new ArrayList<ArrayList<String>>();
        for(int i = 0; i<n; i++){
            ArrayList<String> group = new ArrayList<String>();
            for(int j = 0; j<3; j++){
                group.add(in.next());
            }
            groups.add(group);
        }

        for(int i = 0; i < n; i++){
            Collections.sort(groups.get(i));
        }

        System.out.println(groups);

        ArrayList<ArrayList<String>> names = new ArrayList<ArrayList<String>>();
        ArrayList<Integer> count = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            if(names.contains(groups.get(i))){
                int index = names.indexOf(groups.get(i));
                int inc = count.get(index) + 1;
                count.set(index, inc);
            }
            else{
                names.add(groups.get(i));
                count.add(1);
            }
        }
        // System.out.println(names);
        // System.out.println(count);

        int result = Collections.max(count);

        PrintWriter out = new PrintWriter(new File("records.out"));
        out.println(result);
        System.out.println(result);
        out.close();

    }
}