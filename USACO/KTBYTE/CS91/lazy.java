// Credit: KTBYTE Computer Science Academy CS91 Course (https://ktbyte.com)

/* Lazy

http://www.usaco.org/index.php?page=viewproblem2&cpid=413

*/

import java.util.*;
import java.io.*;

public class lazy {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("lazy.in"));
        int n = in.nextInt();
        int k = in.nextInt();

        Patch[] grass = new Patch[n];
        for (int i = 0; i < n; i++) grass[i] = new Patch(in);
        in.close();

        Arrays.sort(grass);


        int left = 0;
        int right = 0;   // exclusive

        //   0 1 2 3    <-- indexes of patches
        //  |\         <-- closed window (bounds equal)
        //  |--\       <-- size-1 window (right bound excludes the element
        //                   AFTER the left bound)

        int window = 0;

        // 1. OPEN THE WINDOW
        while (right < n && grass[right].x - grass[left].x <= 2*k) {
            window += grass[right].g;
            right++;
        }

        int result = window;

        // 2. SLIDE THE WINDOW
        while (right < n) {
            // MOVE LEFT END RIGHT
            window -= grass[left].g;
            left++;

            // BRING IN MORE ELEMS ON RIGHT UNTIL WINDOW MAX SIZE IS REACHED
            while (right < n && grass[right].x - grass[left].x <= 2*k) {
                window += grass[right].g;
                right++;
            }

            result = Math.max(result, window);
        }


        PrintWriter out = new PrintWriter(new File("lazy.out"));
        System.out.println(result);
        out.println(result);
        out.close();
    }


    static class Patch implements Comparable<Patch> {
        int g, x;

        Patch(Scanner in) {
            g = in.nextInt();
            x = in.nextInt();
        }

        public int compareTo(Patch other) {
            return this.x - other.x;
            //        remember not to rely solely on subtraction trick!
            //  return a negative, zero, or positive # based on comparison

        }
    }


}
