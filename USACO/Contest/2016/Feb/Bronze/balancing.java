// well i'm stupid
// i thought you had to use the b variable to check
// it never occurted to me to use the n variable and then just check around each cow
// （>﹏<）

import java.util.*;
import java.io.*;

public class balancing {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("balancing.in"));
    int n = in.nextInt();
    // int b = in.nextInt();
    in.nextInt();

    // int[][] positions = new int[n][2];
    int[] positionsX = new int[n];
    int[] positionsY = new int[n];

    for(int i = 0; i<n; i++){
      int cowX = in.nextInt();
      int cowY = in.nextInt();
      positionsX[i] = cowX;
      positionsY[i] = cowY;
    }

    int result = n;

    for(int i = 0; i<n; i++){
      for(int j = 0; j<n; j++){
        int fenceX = positionsX[i]+1;
        int fenceY = positionsY[j]+1;
        int quad1 = 0;
        int quad2 = 0;
        int quad3 = 0;
        int quad4 = 0;

        for(int k = 0; k < positionsX.length; k++){
          int cowX = positionsX[k];
          int cowY = positionsY[k];
          if(cowX < fenceX){
            if(cowY > fenceY){
              quad1++;
            }
            else{
              quad3++;
            }
          }
          else{
            if(cowY < fenceY){
              quad2++;
            }
            else{
              quad4++;
            }
          }
        }
        int worst = 0;
        if(quad1 > worst){
          worst = quad1;
        }
        if(quad2 > worst){
          worst = quad2;
        }
        if(quad3 > worst){
          worst = quad3;
        }
        if(quad4 > worst){
          worst = quad4;
        }
        result = Math.min(result, worst);
        // result = Math.min(result, Math.max(Math.max(quad1, quad2), Math.max(quad3, quad4)));
      }
    }

    PrintWriter out = new PrintWriter(new File("balancing.out"));
    out.println(result);
    System.out.println(result);
    out.close();
  }

  // static int checkCows(int a, int b, int[] positionsX, int[] positionsY){
  //   /*
  //   q1 | q2
  //   --------
  //   q3 | q4
  //   */
  //   int quad1 = 0;
  //   int quad2 = 0;
  //   int quad3 = 0;
  //   int quad4 = 0;
  //
  //   for(int i = 0; i < positionsX.length; i++){
  //     int cowX = positionsX[i];
  //     int cowY = positionsY[i];
  //     if(cowX < a){
  //       if(cowY > b){
  //         quad1++;
  //       }
  //       else{
  //         quad3++;
  //       }
  //     }
  //     else{
  //       if(cowY < b){
  //         quad2++;
  //       }
  //       else{
  //         quad4++;
  //       }
  //     }
  //   }
  //
  //   System.out.println("i,j: " + String.valueOf(a) + "," + String.valueOf(b));
  //   System.out.println(quad1);
  //   System.out.println(quad2);
  //   System.out.println(quad3);
  //   System.out.println(quad4);
  //   System.out.println("------------");
  //
  //   return Math.max(Math.max(quad1, quad2), Math.max(quad3, quad4));
  // }

  // static class Cow {
  //   int x, y;
  //   Cow(int x, int y){
  //     this.x = x;
  //     this.y = y;
  //   }
  // }
}
