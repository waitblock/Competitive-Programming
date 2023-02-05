// TODO: finish

import java.util.*;

public final class diverse {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    char[] digits2 = in.next().toCharArray();
    int[] digits = new int[digits2.length];
    for(int i = 0; i<digits2.length; i++){
      digits[i] = Character.getNumericValue(digits2[i]);
    }
    int result = 0;
    for(int i = 0; i<digits.length; i++){
      int last = (digits.length+99 <= digits.length-1) ? digits.length+99 : digits.length-1;
      int[] appear = new int[10];
      HashSet<Integer> digits = new HashSet<>();
      for(int j = i; j<last; j++){
        digits.add(); // add current digit
        // add to appear arr
        // check if appearances greater than unique
      }
    }
  }
}