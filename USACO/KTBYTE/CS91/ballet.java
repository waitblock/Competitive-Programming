import java.util.*;
import java.io.*;

public final class ballet {
  static Pos fl = new Pos(0,1);
  static Pos fr = new Pos(1,1);
  static Pos rl = new Pos(0,0);
  static Pos rr = new Pos(1,0);
  static int dir = 0; // 0 = north, 1 = south, 2 = west, 3 = east


  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("ballet.in"));
    int n = in.nextInt();
    String[] foot = new String[n];
    String[] instr = new String[n];
    for(int i = 0; i<n; i++){
      String line = in.next();
      foot[i] = line.substring(0,2);
      instr[i] = line.substring(2,3);
    }
    // System.out.println(Arrays.toString(foot));
    // System.out.println(Arrays.toString(instr));
  }
  void moveFoot(String foot, String instr){
    if(foot.equals("FL")){
      fl.move(foot, instr);
    }
    if(foot.equals("FR")){
      fr.move(foot, instr);
    }
    if(foot.equals("RL")){
      rl.move(foot, instr);
    }
    if(foot.equals("RR")){
      rr.move(foot, instr);
    }
  }

  static class Pos {
    int x, y;
    Pos(int x, int y){
      this.x = x;
      this.y = y;
    }
    boolean inter(Pos p){
      return (p.x == this.x) && (p.y == this.y);
    }
    void move(String foot, String instr){
      if(instr.equals("F")) this.moveFwd();
      if(instr.equals("B")) this.moveBack();
      if(instr.equals("L")) this.moveLeft();
      if(instr.equals("R")) this.moveRight();
      if(instr.equals("P")) this.pivot(foot);
    }
    void moveFwd(){
      if(dir == 0) this.y++;
      if(dir == 1) this.y--;
      if(dir == 2) this.x--;
      if(dir == 3) this.x++;
    }
    void moveBack(){
      if(dir == 0) this.y--;
      if(dir == 1) this.y++;
      if(dir == 2) this.x++;
      if(dir == 3) this.x--;
    }
    void moveLeft(){
      if(dir == 0) this.x--;
      if(dir == 1) this.x++;
      if(dir == 2) this.y--;
      if(dir == 3) this.y++;
    }
    void moveRight(){
      if(dir == 0) this.x++;
      if(dir == 1) this.x--;
      if(dir == 2) this.y++;
      if(dir == 3) this.y--;
    }
    void pivot(String foot){
      dir++;
      dir %= 4;
      if(foot.equals("FL")){
        fr.y = this.y+fr.x-this.x;
        fr.x = this.x+this.y-fr.y;
        rl.y = this.y+rl.x-this.x;
        rl.x = this.x+this.y-rl.y;
        rr.y = this.y+rr.x-this.x;
        rr.x = this.x+this.y-rr.y;
      }
      if(foot.equals("FR")){
        fl.y = this.y+fl.x-this.x;
        fl.x = this.x+this.y-fl.y;
        rl.y = this.y+rl.x-this.x;
        rl.x = this.x+this.y-rl.y;
        rr.y = this.y+rr.x-this.x;
        rr.x = this.x+this.y-rr.y;
      }
    }
  }
}

/*
north:
- fwd = y+1
- back = y-1
- left = x-1
- right = x+1

south:
- fwd = y-1
- back = y+1
- left = x+1
- right = x-1

west:
- fwd = x-1
- back = x+1
- left = y-1
- right = y+1

east:
- fwd = x+1
- back = x-1
- left = y+1
- right = y-1
*/