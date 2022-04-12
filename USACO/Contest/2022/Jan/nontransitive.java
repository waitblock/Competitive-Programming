import java.util.*;

public class nontransitive {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();

    int[][] dice = new int[t][8];

    for(int i = 0; i<t; i++){
      for(int j = 0; j<8; j++){
        dice[i][j] = in.nextInt();
      }
    }

    // for(int[] arr : dice) System.out.println(Arrays.toString(arr));

    for(int i = 0; i<t; i++){
      int aBeatsB = 0; // number of times dice a will beat dice b
      int bBeatsA = 0;

      int[] diceA = new int[4];
      int[] diceB = new int[4];

      for(int j = 0; j<4; j++){
        diceA[j] = dice[i][j];
      }
      for(int j = 4; j<8; j++){
        diceB[j-4] = dice[i][j];
      }

      for(int j = 0; j<4; j++){
        for(int k = 0; k<4; k++){
          if(diceA[j] > diceB[k]){
            aBeatsB++;
          }
          if(diceB[j] > diceA[k]){
            bBeatsA++;
          }
        }
      }

      // System.out.println(String.valueOf(aBeatsB));

      boolean possible = false;

      for(int j = 1; j<=10; j++){
        for(int k = 1; k<=10; k++){
          for(int l = 1; l<=10; l++){
            for(int m = 1; m<=10; m++){
              int[] diceC = {j,k,l,m};
              int cBeatsA = 0;
              int cBeatsB = 0;
              int aBeatsC = 0;
              int bBeatsC = 0;
              for(int n = 0; n<4; n++){
                for(int o = 0; o<4; o++){
                  if(diceC[n] > diceA[o]){
                    cBeatsA++;
                  }
                  if(diceC[n] > diceB[o]){
                    cBeatsB++;
                  }
                  if(diceA[n] > diceC[o]){
                    aBeatsC++;
                  }
                  if(diceB[n] > diceC[o]){
                    bBeatsC++;
                  }
                }
              }
              if(aBeatsB > bBeatsA && bBeatsC > cBeatsB && cBeatsA > aBeatsC){
                possible = true;
                // System.out.println(Arrays.toString(diceC));
                // System.out.println(aBeatsB);
                // System.out.println(aBeatsC);
                // System.out.println(bBeatsA);
                // System.out.println(bBeatsC);
                // System.out.println(cBeatsA);
                // System.out.println(cBeatsB);
                j=10;
                k=10;
                l=10;
                m=10;
              }
              if(bBeatsA > aBeatsB && cBeatsB > bBeatsC && aBeatsC > cBeatsA){
                possible = true;
                // System.out.println(Arrays.toString(diceC));
                // System.out.println(aBeatsB);
                // System.out.println(aBeatsC);
                // System.out.println(bBeatsA);
                // System.out.println(bBeatsC);
                // System.out.println(cBeatsA);
                // System.out.println(cBeatsB);
                j=10;
                k=10;
                l=10;
                m=10;
              }
            }
          }
        }
      }
      // System.out.println(possible);
      if(possible){
        System.out.println("yes");
      }
      else{
        System.out.println("no");
      }
  }
}
}