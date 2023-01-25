import java.util.*;

public final class A {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] board = new int[5];
    for(int i = 0; i<5; i++){
      board[i] = in.nextInt();
    }
    in.close();
    int sum = 0;
    for(int i = 0; i<5; i++){
      sum += board[i];
    }
    if(sum == 5){
      System.out.println(-1);
      System.exit(0);
    }
    for(int i = 0; i<5; i++){
      if(board[i] == 0){
        board[i] = 1;
        break;
      }
    }
    for(int i = 0; i<5; i++){
      System.out.print(board[i]);
      System.out.print(" ");
    }
    System.out.print("\n");
  }
}
