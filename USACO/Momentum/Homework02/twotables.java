import java.util.*;

public final class twotables {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int a = in.nextInt(); // width of grid
    int b = in.nextInt(); // height of grid

    int x1 = in.nextInt(); // bl x
    int y1 = in.nextInt(); // bl y
    int x2 = in.nextInt(); // tr x
    int y2 = in.nextInt(); // bl y

    int w2 = in.nextInt(); // width of table to be placed
    int h2 = in.nextInt(); // height of table to be placed
    in.close();

    int w = x2-x1; // width of table in grid
    int h = y2-y1; // height of table in grid

    int spaceRight = a-x2; // space between table currently in grid and right of grid
    int spaceLeft = x1; // space between table currently in grid and left of grid
    int spaceTop = b-y2; // space between table currently in grid and top of grid
    int spaceBottom = y1; // space between table currently in grid and bottom of grid

    int result = 0;

    System.out.println(w+w2);
    System.out.println(h+h2);

    if((w+w2) > a || (h+h2) > b){ // it is not possible to fit the table
      System.out.println(-1);
      System.exit(0);
    }

    // moving table to the left would be more optimal
    if((spaceRight - w2) > (spaceLeft - w2)){
      int toMove = Math.abs(spaceRight-w2);
      result += ((spaceRight - w2) > 0) ? 0 : (toMove);
    }

     // moving table to the right would be more optimal
    else{
      int toMove = Math.abs(spaceLeft-w2);
      result += ((spaceLeft - w2) > 0) ? 0 : (toMove);
    }

    // moving table to the bottom would be more optimal
    if((spaceTop - h2) > (spaceBottom - h2)){
      int toMove = Math.abs(spaceTop-h2);
      result += ((spaceTop - h2) > 0) ? 0 : (toMove);
    }

    // moving table to the top would be more optimal
    else{
      int toMove = Math.abs(spaceBottom-h2);
      result += ((spaceBottom - h2) > 0) ? 0 : (toMove);
    }

    System.out.println(result);

  }
}