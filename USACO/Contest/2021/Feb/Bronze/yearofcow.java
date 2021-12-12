import java.util.*;

public class yearofcow {
    static Map<String, String> zodiacLookup = new HashMap<>();

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Map<String, Integer> cows = new HashMap<>();
        int n = in.nextInt();
        cows.put("Bessie", 0);
        zodiacLookup.put("Bessie", "Ox");
        for(int i = 0; i<n; i++){
            String cow1 = in.next();
            in.next(); in.next();
            String pn = in.next();
            String zodiac = in.next();
            in.next(); in.next();
            String cow2 = in.next();
            zodiacLookup.put(cow1, zodiac);
            int diff = findDifference(cow1, cow2, pn, zodiac); // cow2-cow1
            // System.out.println(diff);
            if(cow2 == "Bessie"){
                int bessieDiff = 0-diff; // difference with bessie
                cows.put(cow1, bessieDiff);
            }
            if(cow2 != "Bessie"){
                int cowDiff = cows.get(cow2); // difference of cow2 with bessie
                int bessieDiff = cowDiff-diff;
                cows.put(cow1, bessieDiff);
            }
        }
        // System.out.println(zodiacLookup);
        // System.out.println(cows);
        System.out.println(Math.abs(cows.get("Elsie")));
    }

    //year of cow2 subtracted by year of cow1
    static int findDifference(String cow1, String cow2, String pn, String zodiac){
        // System.out.println(pn);
        String[] lookup = {
            "Ox","Tiger", "Rabbit", "Dragon",
            "Snake", "Horse", "Goat", "Monkey",
            "Rooster", "Dog", "Pig", "Rat"};
        String cow2Zodiac = zodiacLookup.get(cow2);
        // System.out.println(result);
        int result = 0;
        // if(zodiac.equals(cow2Zodiac)){
        //     return -12;
        // }
        String current = cow2Zodiac;
        int currentIndex = Arrays.asList(lookup).indexOf(cow2Zodiac);
        if(pn.equals("next")){
            currentIndex++;
            result++;
            if(currentIndex == 12) currentIndex = 0;
            current = lookup[currentIndex];
        }
        if(pn.equals("previous")){
            currentIndex--;
            result--;
            if(currentIndex == -1) currentIndex = 11;
            current = lookup[currentIndex];
        }
        while(!current.equals(zodiac)){
            if(pn.equals("next")){
                currentIndex++;
                result++;
                if(currentIndex == 12) currentIndex = 0;
                current = lookup[currentIndex];
            }
            if(pn.equals("previous")){
                currentIndex--;
                result--;
                if(currentIndex == -1) currentIndex = 11;
                current = lookup[currentIndex];
            }
            // System.out.println(current);
        }
        return -result;
    }
}
