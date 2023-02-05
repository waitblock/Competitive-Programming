import java.util.*;

public final class blocks {

    static HashSet<String> valid = new HashSet<>();
    static char[][] blocks = new char[4][6];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int i = 0; i<4; i++){
            blocks[i] = in.next().toCharArray();
        }
        String[] words = new String[n];
        for(int i = 0; i<n; i++) words[i] = in.next();
        in.close();
        HashSet<Integer> temp = new HashSet<>();
        for(int i = 0; i<4; i++){
            temp.add(i);
        }
        generateValid("", temp);
        // System.out.println(valid);
        for(String s : words){
            // System.out.println(s);
            System.out.println((valid.contains(s)) ? "YES" : "NO");
        }

    }
    static void generateValid(String word, HashSet<Integer> remaining){
        if(!(remaining.size() == 4)) valid.add(word);
        if(remaining.size() == 0) return;
        for(int i : remaining){
            HashSet<Integer> remainingNow = new HashSet<>();
            for(int j : remaining){
                if(j == i) continue;
                remainingNow.add(j);
            }
            for(int j = 0; j<6; j++){
                generateValid(word+blocks[i][j], remainingNow);
            }
        }
    }

}
